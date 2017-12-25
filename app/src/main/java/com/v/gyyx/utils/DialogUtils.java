package com.v.gyyx.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by Administrator on 2017/12/15.
 */

public class DialogUtils {


    private static MaterialDialog dialog;

    public static void showRoundProcessDialog(Context mContext)
    {
        dialog = new MaterialDialog.Builder(mContext)
                .title("提示")
                .content("正在加载...")
                .progress(true, 0)
                .show();
    }

    public static void  disMissDialog(){
        if(dialog != null){
            dialog.dismiss();
        }
    }
    public static void  setNetDialog(final Activity activity){
        new MaterialDialog.Builder(activity)
                .title("提示:")
                .content("未检测到本地网络/WIFI,是否去设置?")
                .positiveText("是,去")
                .negativeText("不,去")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        activity.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        activity.finish();
                    }
                })
                .canceledOnTouchOutside(false)
                .show();

    }
}
