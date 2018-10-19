package com.ysnows.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.socks.library.KLog;

import net.androidwing.hotxposed.IHookerDispatcher;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookDispatcher implements IHookerDispatcher {
    String TAG="in systemUI";
    @Override
    public void dispatch(XC_LoadPackage.LoadPackageParam lpparam) {

        if (!lpparam.packageName.equals("com.tencent.mm")) {
            return;
        }

        XposedBridge.log(TAG + lpparam.packageName + "---" + lpparam.processName);


        XposedHelpers.findAndHookMethod("com.tencent.mm.ui.LauncherUI", lpparam.classLoader, "onResume", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);

            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Toast.makeText((Context) param.thisObject, "Hello World", Toast.LENGTH_SHORT).show();

                KLog.d(TAG,param);

            }
        });

//        XposedHelpers.findAndHookMethod("com.tencent.ithome.ui.MainActivity", lpparam.classLoader, "initThings", Bundle.class, new XC_MethodHook() {
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                super.afterHookedMethod(param);
////                XposedBridge.log("we are in systemUI " + param.toString());
////
//                Toast.makeText((Context) param.thisObject, "你在看什么", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
