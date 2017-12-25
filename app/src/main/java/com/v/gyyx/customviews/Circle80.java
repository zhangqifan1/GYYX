package com.v.gyyx.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.v.gyyx.R;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Circle80 extends View {

    private  int color;
    private int mRadius;
    private Paint mPaint;
    private DashPathEffect dashPathEffect;

    public Circle80(Context context) {
        this(context, null);
    }

    public Circle80(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint("ResourceAsColor")
    public Circle80(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Circle80);
        mRadius = typedArray.getDimensionPixelSize(R.styleable.Circle80_radius, 100);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        final int colorHui = R.color.colorHui;
        color=colorHui;
        paint.setColor(color);
        paint.setStrokeWidth(2);
        mPaint = paint;
        dashPathEffect = new DashPathEffect(new float[]{5,5,5,5}, 1);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        int x = getWidth() >> 1;
        int y = getHeight() >> 1;

        canvas.drawCircle(x, y, mRadius, mPaint);
        mPaint.setPathEffect(dashPathEffect);
        canvas.drawCircle(x, y, mRadius+20, mPaint);

    }
}
