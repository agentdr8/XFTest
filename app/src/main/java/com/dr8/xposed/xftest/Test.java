package com.dr8.xposed.xftest;

import android.content.res.XModuleResources;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;

public class Test implements IXposedHookZygoteInit, IXposedHookInitPackageResources {

    private static String MODULE_PATH;
    private static String PKG = "com.android.systemui";

    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam iPResParam) throws Throwable {

        XModuleResources modRes = XModuleResources.createInstance(MODULE_PATH, iPResParam.res);

        try {
            if (iPResParam.packageName.equals(PKG)) {
                XposedBridge.log("XFTest: In SysUI, replacing drawables");
                iPResParam.res.setReplacement(PKG, "drawable", "stat_sys_wifi_signal_0", modRes.fwd(R.drawable.stat_sys_wifi_signal_0));
                iPResParam.res.setReplacement(PKG, "drawable", "stat_sys_wifi_signal_1", modRes.fwd(R.drawable.stat_sys_wifi_signal_1));
                iPResParam.res.setReplacement(PKG, "drawable", "stat_sys_wifi_signal_2", modRes.fwd(R.drawable.stat_sys_wifi_signal_2));
                iPResParam.res.setReplacement(PKG, "drawable", "stat_sys_wifi_signal_3", modRes.fwd(R.drawable.stat_sys_wifi_signal_3));
                iPResParam.res.setReplacement(PKG, "drawable", "stat_sys_wifi_signal_4", modRes.fwd(R.drawable.stat_sys_wifi_signal_4));

                iPResParam.res.setReplacement(PKG, "drawable", "stat_sys_wifi_signal_0_fully", modRes.fwd(R.drawable.stat_sys_wifi_signal_0));
                iPResParam.res.setReplacement(PKG, "drawable", "stat_sys_wifi_signal_1_fully", modRes.fwd(R.drawable.stat_sys_wifi_signal_1));
                iPResParam.res.setReplacement(PKG, "drawable", "stat_sys_wifi_signal_2_fully", modRes.fwd(R.drawable.stat_sys_wifi_signal_2));
                iPResParam.res.setReplacement(PKG, "drawable", "stat_sys_wifi_signal_3_fully", modRes.fwd(R.drawable.stat_sys_wifi_signal_3));
                iPResParam.res.setReplacement(PKG, "drawable", "stat_sys_wifi_signal_4_fully", modRes.fwd(R.drawable.stat_sys_wifi_signal_4));
            }
        } catch (Throwable t) {
            XposedBridge.log("XFTest: " + t);
        }
    }

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {

        MODULE_PATH = startupParam.modulePath;

    }
}