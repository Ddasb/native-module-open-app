import { NativeModules } from "react-native";

const { NativeModuleOpenApp } = NativeModules;

export const openApplication = (packageName: string) =>
  NativeModuleOpenApp.openApplication(packageName);
