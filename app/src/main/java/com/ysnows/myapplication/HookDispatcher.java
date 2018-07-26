package com.ysnows.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import net.androidwing.hotxposed.IHookerDispatcher;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookDispatcher implements IHookerDispatcher {
    @Override
    public void dispatch(XC_LoadPackage.LoadPackageParam lpparam) {

        if (!lpparam.packageName.equals("com.ruanmei.ithome")) {
            return;
        }

        XposedBridge.log(" in systemUI " + lpparam.packageName);

        XposedHelpers.findAndHookMethod("com.ruanmei.ithome.ui.MainActivity", lpparam.classLoader, "initThings", Bundle.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
//                XposedBridge.log("we are in systemUI " + param.toString());
//
                Toast.makeText((Context) param.thisObject, "你在看什么", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
