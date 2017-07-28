package com.vanzh.immersive;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by zp on 2017/7/27.
 */

public class ImmersiveUitls {

    public static void setContentView(Activity activity, int resId) {
        //  if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        activity.setContentView(resId);
    }

    public static void immerView(Context context, View view) {
        int statusHeight = getStatusHeight(context);
        view.setPadding(0, view.getPaddingTop() + statusHeight, 0, 0);
        view.getLayoutParams().height = view.getLayoutParams().height + statusHeight;
    }

    public static void setStatusBarColor(Activity activity, int statusBarColor) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().setStatusBarColor(statusBarColor);
        }
    }

    public static void setNavigationBarColor(Activity activity, int navigationBarColor) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().setNavigationBarColor(navigationBarColor);
        }
    }

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    private static int getStatusHeight(Context context) {
        int statusHeight = -1;

        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            String status_bar_height = clazz.getField("status_bar_height").get(object).toString();
            int statusHeight_dp = Integer.valueOf(status_bar_height);
            statusHeight = context.getResources().getDimensionPixelSize(statusHeight_dp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return statusHeight;
    }
}
