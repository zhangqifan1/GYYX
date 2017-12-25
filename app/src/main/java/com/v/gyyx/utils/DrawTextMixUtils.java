package com.v.gyyx.utils;

import android.graphics.drawable.Drawable;
import android.text.Html;

import com.v.gyyx.R;
import com.v.gyyx.application.App;

/**
 * Created by Administrator on 2017/12/18.
 */

public class DrawTextMixUtils {


    public static Html.ImageGetter getImageGetterInstance() {
        Html.ImageGetter imgGetter = new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                if(source.equals(R.drawable.dialog_progress_round+"")){
                    int fontH = (int) (App.getContext().getResources().getDimension(
                            R.dimen.textSizeMedium) * 1.5);
                    int id = Integer.parseInt(source);
                    Drawable d = App.getContext().getResources().getDrawable(id);

                    int height = fontH;
                    int width = (int) ((float) d.getIntrinsicWidth() / (float) d
                            .getIntrinsicHeight()) * fontH;
                    if (width == 0) {
                        width = d.getIntrinsicWidth();
                    }
                    d.setBounds(0, 0, width, height);
                    return d;
                }
                return null;
            }
        };
        return imgGetter;
    }

    /**
     * @return
     */
    public static String descString() {
        return "希望老了可以有各种移动辅助机器人" + "<img src='" + R.drawable.dialog_progress_round
                + "'/>" + "<img src='" + R.drawable.dialog_progress_round
                + "'/>" + "带我自由奔跑" + "<img src='"
                + R.drawable.dialog_progress_round + "'/>" +"<img src='"
                + R.drawable.dialog_progress_round + "'/>"+ "";
    }

}

