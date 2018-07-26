package com.ysnows.myapplication;

import net.androidwing.hotxposed.HotXposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Tutorial implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        HotXposed.hook(HookDispatcher.class, lpparam);
    }
}
