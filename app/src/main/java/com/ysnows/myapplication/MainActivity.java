package com.ysnows.myapplication;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ysnows.myapplication.utils.ShellUtil;

public class MainActivity extends AppCompatActivity {

    public static String TARGET_PACKAGE_NAME = "com.tencent.mm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShellUtil.execCommand("am force-stop " + TARGET_PACKAGE_NAME, true);

        ShellUtil.execCommand("am start -n com.tencent.mm/com.tencent.mm.ui.LauncherUI", true);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
