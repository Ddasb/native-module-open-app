package com.nativemoduleopenapp;

import androidx.annotation.NonNull;
import android.content.pm.PackageManager;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = NativeModuleOpenAppModule.NAME)
public class NativeModuleOpenAppModule extends ReactContextBaseJavaModule {
    public static final String NAME = "NativeModuleOpenApp";
    private final ReactApplicationContext reactContext;

    public NativeModuleOpenAppModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    private void openApplication(String packageName, Promise promise) {
        PackageManager pm = this.reactContext.getPackageManager();
        try {
            this.reactContext.startActivity(pm.getLaunchIntentForPackage(packageName));
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
