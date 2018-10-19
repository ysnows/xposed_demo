package com.ysnows.myapplication;

import com.gh0u1l5.wechatmagician.spellbook.SpellBook;
import com.ysnows.myapplication.plugins.Alert;

import net.androidwing.hotxposed.IHookerDispatcher;

import java.util.ArrayList;
import java.util.List;

import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookDispatcher implements IHookerDispatcher {
    String TAG = "in systemUI";

    @Override
    public void dispatch(XC_LoadPackage.LoadPackageParam lpparam) {


        try {
            if (!SpellBook.INSTANCE.isImportantWechatProcess(lpparam)) {
                return;
            }

            XposedBridge.log(TAG + lpparam.packageName + "---" + lpparam.processName);

            List<Object> list = new ArrayList<>();
            list.add(new Alert());

            SpellBook.INSTANCE.startup(lpparam, list);


//            XposedHelpers.findAndHookMethod("com.tencent.mm.ui.LauncherUI", lpparam.classLoader, "onResume", new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    super.beforeHookedMethod(param);
//
//                }
//
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    super.afterHookedMethod(param);
//                    Toast.makeText((Context) param.thisObject, "Hello World", Toast.LENGTH_SHORT).show();
//
//                    KLog.d(TAG, param);
//
//                }
//            });

//        XposedHelpers.findAndHookMethod("com.tencent.ithome.ui.MainActivity", lpparam.classLoader, "initThings", Bundle.class, new XC_MethodHook() {
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                super.afterHookedMethod(param);
////                XposedBridge.log("we are in systemUI " + param.toString());
////
//                Toast.makeText((Context) param.thisObject, "你在看什么", Toast.LENGTH_SHORT).show();
//            }
//        });

        } catch (Exception e) {

        }
    }
}
