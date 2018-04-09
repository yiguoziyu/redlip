package com.kuaibo.commonlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
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
    private float leftTopRadius, leftBottomRadius, rightTopRadius, rightbottomRadius;
    //内容字体大小,大小
    private int contentTextSize, contentTextColor;
    //上下左右内容边距
    private int contentleftPadding, contentRightPadding;
    //背景颜色
    private int backgroundColor;

    private float[] radiusArray = {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f};

    public FilletView(Context context) {
        this(context, null);
    }

    public FilletView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.FilletView);
        setRadius();
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
        RectF rectF = new RectF();
        rectF.left = 0;
        rectF.right = width;
        rectF.top = 0;
        rectF.bottom = height;
        Path path = new Path();
        path.addRoundRect(rectF, radiusArray, Path.Direction.CW);
        canvas.clipPath(path);
    }

    private void setRadius() {
        radiusArray[0] = leftTopRadius;
        radiusArray[1] = leftTopRadius;
        radiusArray[2] = rightTopRadius;
        radiusArray[3] = rightTopRadius;
        radiusArray[4] = rightbottomRadius;
        radiusArray[5] = rightbottomRadius;
        radiusArray[6] = leftBottomRadius;
        radiusArray[7] = leftBottomRadius;
        invalidate();
    }
}
