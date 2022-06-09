#import "NativeModuleOpenApp.h"

@implementation NativeModuleOpenApp

RCT_EXPORT_MODULE()

RCT_REMAP_METHOD(openApplication: (nonnull NSString *)appName withRejecter:(RCTPromiseRejectBlock)reject) {
  NSString *url = "@" + appName;

  BOOL canOpenURL = [[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString:url]];

  if (canOpenUrl) [[UIApplication sharedApplication] openURL:[NSURL URLWithString:url]];
  else reject(@"cannot open url", @"cannot open url", nil);
}

@end
