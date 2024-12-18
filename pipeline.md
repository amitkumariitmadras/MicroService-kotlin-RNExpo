Below is a step-by-step conceptual guide to combining your Kotlin-based Android feature into your React Native (Expo) project so that you end up with a single APK containing both. The process involves:

1. **Ejecting/Configuring Your React Native (Expo) Project**  
2. **Integrating Your Kotlin Android Project as a Module**  
3. **Utilizing Deep Linking (Optional, but recommended)**  
4. **Structuring the Final Project**  
5. **Building the Final Single APK**

### Important Considerations

- **Ejecting Expo:**  
  To integrate native Android code (Kotlin-based), you need to have direct access to the `android` directory and Gradle build configurations. If you are using the Managed Workflow of Expo, you’ll need to “eject” to the Bare Workflow. This will give you a standard React Native Android project structure.
  
- **Project Architecture:**  
  The React Native project’s `android` directory will serve as the “host” Android application. You will integrate your Kotlin code as either:
  - A library module inside the main Android project, or
  - A set of activities/fragments inside the main `app` module itself.

- **Deep Linking:**  
  Deep linking can be used to navigate from your React Native (JS side) into specific screens or features implemented in Kotlin (native side). This way, your React Native screens and your Kotlin screens can be part of one navigation flow.

### Step-by-Step Procedure

#### 1. Set Up Your React Native (Expo) Project in Bare Workflow

1. **Start with your React Native (Expo) project.**  
   If you’re currently in Managed Workflow, run:
   ```bash
   npx expo prebuild
   ```
   or
   ```bash
   npx expo eject
   ```
   This will create the `android` and `ios` directories, giving you a standard React Native native project structure.

2. **Verify Structure:**  
   After ejecting, your directory may look like:
   ```
   rn_kotlin_app/
   ├─ android/
   │  ├─ app/
   │  ├─ build.gradle
   │  ├─ settings.gradle
   │  └─ gradle.properties
   ├─ ios/
   ├─ (tabs)/   # Your current RN screens, etc.
   ├─ assets/
   ├─ components/
   ├─ ...
   ├─ app.json
   ├─ package.json
   └─ ...
   ```

#### 2. Integrate the Kotlin Android Project as a Module

1. **Obtain Your Kotlin Project:**  
   You have a standalone Kotlin Android app (with `MainActivity.kt`, fragments, and presumably a Gradle setup).

2. **Convert Kotlin App into a Library Module (If Needed):**  
   Inside your Kotlin-based Android app, you can reorganize it into a library module. Instead of having it as a standalone app, consider turning its `app` module into a library module.  
   
   For example, if your Kotlin project currently looks like:
   ```
   kotlinapp/
   ├─ app/
   │  ├─ src/
   │  ├─ build.gradle.kts
   │  └─ ...
   ├─ gradle/
   ├─ build.gradle.kts
   └─ settings.gradle.kts
   ```

   You can rename `app` to something like `kotlinfeature` and convert its `build.gradle.kts` from an `com.android.application` plugin to an `com.android.library` plugin. For example:
   ```gradle
   plugins {
       id("com.android.library")
       kotlin("android")
   }

   android {
       // library config
   }

   dependencies {
       // add necessary dependencies
   }
   ```

3. **Copy the Kotlin Module into the React Native Project’s Android Folder:**  
   Move (or copy) the `kotlinfeature` module folder into your React Native project’s `android` directory. After this, your structure might look like:
   ```
   rn_kotlin_app/
   ├─ android/
   │  ├─ app/
   │  ├─ kotlinfeature/
   │  │  ├─ src/
   │  │  ├─ build.gradle.kts
   │  │  └─ ... (Kotlin code)
   │  ├─ build.gradle
   │  └─ settings.gradle
   ├─ ios/
   ├─ (tabs)/
   ├─ ...
   ```

4. **Include the Kotlin Module in settings.gradle:**  
   In `android/settings.gradle` of your RN project, add:
   ```gradle
   include ':kotlinfeature'
   project(':kotlinfeature').projectDir = new File(rootProject.projectDir, "kotlinfeature")
   ```

5. **Link the Kotlin Library Module in app/build.gradle:**  
   In `android/app/build.gradle`, add the library as a dependency:
   ```gradle
   dependencies {
       implementation project(':kotlinfeature')
       // Other RN dependencies
   }
   ```

#### 3. Integrate Deep Linking for Navigation (Optional but Helpful)

If you want to navigate from React Native screens to your Kotlin screens/activities/fragments:

1. **Android Manifest Setup:**
   In your `android/app/src/main/AndroidManifest.xml`, define an intent filter for deep linking:
   ```xml
   <activity android:name="com.example.kotlinapp.MainActivity">
       <intent-filter>
           <action android:name="android.intent.action.VIEW" />
           <category android:name="android.intent.category.DEFAULT" />
           <category android:name="android.intent.category.BROWSABLE" />
           <data android:scheme="myapp" android:host="feature" />
       </intent-filter>
   </activity>
   ```

2. **React Native Linking:**
   From your React Native code (JS/TS), you can use `Linking.openURL("myapp://feature")` to open the Kotlin activity. You can also use React Navigation with deep linking configuration to seamlessly navigate.

3. **In the Kotlin Code:**
   Handle the incoming intent in `MainActivity.kt` or the respective fragment to display the correct screen.

#### 4. Final Project Structure

The final structure might look like this:

```
rn_kotlin_app/
├─ android/
│  ├─ app/
│  │  ├─ src/
│  │  ├─ build.gradle
│  │  └─ ...
│  ├─ kotlinfeature/
│  │  ├─ src/
│  │  ├─ build.gradle.kts
│  │  └─ ... (Kotlin code for your feature)
│  ├─ build.gradle
│  ├─ settings.gradle
│  └─ gradle.properties
├─ ios/
├─ (tabs)/         # RN screens
├─ assets/
├─ components/
├─ package.json
├─ index.js
├─ app.json
└─ ...
```

#### 5. Building the Final Single APK

1. **Gradle Build:**
   From the root `rn_kotlin_app` directory, run:
   ```bash
   cd android
   ./gradlew assembleRelease
   ```
   or back at root:
   ```bash
   npx react-native run-android --variant=release
   ```
   
   This will produce an APK (usually located in `android/app/build/outputs/apk/release/app-release.apk`) that includes both the React Native JavaScript bundle and the integrated Kotlin code.

2. **Testing Deep Linking:**
   Install the APK on a device/emulator and test deep linking by running:
   ```bash
   adb shell am start -W -a android.intent.action.VIEW -d "myapp://feature" com.yourcompany.rn_kotlin_app
   ```
   This should launch your Kotlin feature screen.

### Summary

- **Eject Expo to Bare Workflow**: Gives you full access to the Android project.
- **Convert Kotlin App to a Library Module & Integrate**: Include the Kotlin code as a submodule in your Android directory and reference it in `settings.gradle` and `app/build.gradle`.
- **Use Deep Linking for Navigation**: Allows React Native screens to open Kotlin screens seamlessly.
- **Single APK Build**: A single Gradle build will produce the unified APK.

This approach keeps your Kotlin-specific libraries intact while still leveraging React Native (and Expo’s features) for the main application’s UI and authentication flow. You end up with a single APK containing all features.