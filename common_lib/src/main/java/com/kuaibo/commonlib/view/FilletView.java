package com.kuaibo.commonlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kuaibo.commonlib.R;

/**
 * 圆角View
 * Created by 一锅子鱼 on 2018/4/8.
 */

public class FilletView extends View {

    //左右边圆的角度
    private float leftRadius, rightRadius;
    //内容字体大小,大小
    private int contentTextSize, contentTextColor;
    //上下左右内容边距
    private int contentleftPadding, contentRightPadding;
    //背景颜色
    private int backgroundColor;

    public FilletView(Context context) {
        this(context, null);
    }

    public FilletView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.)
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        Paint paint = new Paint();
        //设置画笔为无齿锯
        paint.setAntiAlias(true);
        paint.setColor(backgroundColor);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        RectF rectF = new RectF();
        rectF.left = 0;
        rectF.right = width;
        rectF.top = 0;
        rectF.bottom = height;
        canvas.drawRoundRect(rectF, leftRadius, rightRadius, paint);
    }
}
