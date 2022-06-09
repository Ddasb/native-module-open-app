import { NativeModules, Platform } from "react-native";

const LINKING_ERROR =
  `The package 'native-module-open-app' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: "" }) +
  "- You rebuilt the app after installing the package\n" +
  "- You are not using Expo managed workflow\n";

const NativeModuleOpenApp = NativeModules.NativeModuleOpenApp
  ? NativeModules.NativeModuleOpenApp
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export const openApplication = (packageName: string) =>
  NativeModuleOpenApp.openApplication(packageName);
