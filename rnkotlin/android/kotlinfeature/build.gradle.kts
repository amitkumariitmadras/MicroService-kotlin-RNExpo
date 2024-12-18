// plugins {
//     alias(libs.plugins.android.application)
//     alias(libs.plugins.kotlin.android)
// }

// android {
//     namespace = "com.example.kotlinapp"
//     compileSdk = 35

//     defaultConfig {
//         applicationId = "com.example.kotlinapp"
//         minSdk = 24
//         targetSdk = 35
//         versionCode = 1
//         versionName = "1.0"

//         testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//     }

//     buildTypes {
//         release {
//             isMinifyEnabled = false
//             proguardFiles(
//                 getDefaultProguardFile("proguard-android-optimize.txt"),
//                 "proguard-rules.pro"
//             )
//         }
//     }
//     compileOptions {
//         sourceCompatibility = JavaVersion.VERSION_1_8
//         targetCompatibility = JavaVersion.VERSION_1_8
//     }
//     kotlinOptions {
//         jvmTarget = "1.8"
//     }
//     buildFeatures {
//         viewBinding = true
//     }
// }

// dependencies {

//     implementation(libs.androidx.core.ktx)
//     implementation(libs.androidx.appcompat)
//     implementation(libs.material)
//     implementation(libs.androidx.constraintlayout)
//     implementation(libs.androidx.navigation.fragment.ktx)
//     implementation(libs.androidx.navigation.ui.ktx)
//     testImplementation(libs.junit)
//     androidTestImplementation(libs.androidx.junit)
//     androidTestImplementation(libs.androidx.espresso.core)
//     implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"

// }

// plugins {
//     // Use the library plugin instead of the application plugin
//     // If your libs.versions.toml defines android.library, you can use:
//     // alias(libs.plugins.android.library)
//     // Otherwise, specify directly:
//     id("com.android.library")
//     alias(libs.plugins.kotlin.android)
// }

// android {
//     namespace = "com.example.kotlinapp"
//     compileSdk = 35

//     defaultConfig {
//         // Remove applicationId, versionCode, versionName as this is a library
//         minSdk = 24
//         targetSdk = 35

//         // Keep the testInstrumentationRunner if you need it for tests
//         testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//     }

//     buildTypes {
//         release {
//             // Library can still have minify and proguard, but it's not as common
//             isMinifyEnabled = false
//             // If you do use ProGuard/R8, keep these lines
//             proguardFiles(
//                 getDefaultProguardFile("proguard-android-optimize.txt"),
//                 "proguard-rules.pro"
//             )
//         }
//     }

//     compileOptions {
//         sourceCompatibility = JavaVersion.VERSION_1_8
//         targetCompatibility = JavaVersion.VERSION_1_8
//     }

//     kotlinOptions {
//         jvmTarget = "1.8"
//     }

//     buildFeatures {
//         // If you rely on viewBinding or other features, these can remain
//         viewBinding = true
//     }
// }

// dependencies {
//     implementation(libs.androidx.core.ktx)
//     implementation(libs.androidx.appcompat)
//     implementation(libs.material)
//     implementation(libs.androidx.constraintlayout)
//     implementation(libs.androidx.navigation.fragment.ktx)
//     implementation(libs.androidx.navigation.ui.ktx)

//     // Ensure Kotlin stdlib version aligns with your Kotlin plugin version
//     implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")

//     testImplementation(libs.junit)
//     androidTestImplementation(libs.androidx.junit)
//     androidTestImplementation(libs.androidx.espresso.core)
// }

// plugins {
//     id("com.android.library")

//     // Remove the version here since it's likely declared globally in the project
//     id("org.jetbrains.kotlin.android")
// }

// android {
//     namespace = "com.example.kotlinapp"
//     compileSdk = 35

//     defaultConfig {
//         minSdk = 24
//         targetSdk = 35
//         testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//     }

//     buildTypes {
//         release {
//             isMinifyEnabled = false
//             proguardFiles(
//                 getDefaultProguardFile("proguard-android-optimize.txt"),
//                 "proguard-rules.pro"
//             )
//         }
//     }

//     compileOptions {
//         sourceCompatibility = JavaVersion.VERSION_1_8
//         targetCompatibility = JavaVersion.VERSION_1_8
//     }

//     kotlinOptions {
//         jvmTarget = "1.8"
//     }

//     buildFeatures {
//         viewBinding = true
//     }
// }

// dependencies {
//     implementation("androidx.core:core-ktx:1.10.1")
//     implementation("androidx.appcompat:appcompat:1.6.1")
//     implementation("com.google.android.material:material:1.9.0")
//     implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//     implementation("androidx.navigation:navigation-fragment-ktx:2.7.1")
//     implementation("androidx.navigation:navigation-ui-ktx:2.7.1")

//     // Make sure this Kotlin stdlib version aligns with the Kotlin version used globally
//     implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")

//     testImplementation("junit:junit:4.13.2")
//     androidTestImplementation("androidx.test.ext:junit:1.1.5")
//     androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
// }

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.kotlinapp"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        targetSdk = 35
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            // proguardFiles(
            //     getDefaultProguardFile("proguard-android-optimize.txt"),
            //     "proguard-rules.pro"
            // )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.1")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
