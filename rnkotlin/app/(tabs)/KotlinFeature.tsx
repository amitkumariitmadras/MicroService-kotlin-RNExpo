import { useEffect } from 'react';
import { Linking, View, Text, StyleSheet } from 'react-native';

export default function KotlinFeature() {
  useEffect(() => {
    // Trigger the deep link when this screen is focused
    Linking.openURL('myapp://feature');
  }, []);

  return (
    <View style={styles.container}>
      <Text>Launching Scanner App Demoo...</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
