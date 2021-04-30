package com.nativebridgecommunication;
import java.lang.Math.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableNativeArray;

public class Sample extends ReactContextBaseJavaModule {
  private static ReactApplicationContext reactContext;

  Sample(ReactApplicationContext context) {
    super(context);
    reactContext = context;
  }
  
  @Override
  public String getName() {
    return "Sample";
  }

  @ReactMethod
  public void show(int value, Promise promise) {
    WritableNativeArray data = new WritableNativeArray();
    double pi = Math.PI;
    String hashes = "";
    for(int i=0;i<value;i++){
        hashes += "#"; 
    }
    DecimalFormat df = new DecimalFormat("#."+(hashes));
    df.setRoundingMode(RoundingMode.CEILING);
    data.pushString(df.format(pi));
    // data.pushString("Sample Data A");
    // data.pushString("Sample Data B");
    // data.pushString("Sample Data C");
    promise.resolve(data);
  }

}