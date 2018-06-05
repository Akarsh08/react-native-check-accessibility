
package com.reactlibrary;


import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.react.bridge.Callback;
import android.view.accessibility.AccessibilityManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNReactNativeCheckAccessibilityModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNReactNativeCheckAccessibilityModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNReactNativeCheckAccessibility";
  }

  @ReactMethod
  public void isAccessibilityEnabled(Callback callback) {
      final AccessibilityManager accessibilityManager = (AccessibilityManager) this.reactContext.getSystemService(Context.ACCESSIBILITY_SERVICE);
      if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
          callback.invoke("0", null);
          return;
      }
      callback.invoke("1", null);
  }
}