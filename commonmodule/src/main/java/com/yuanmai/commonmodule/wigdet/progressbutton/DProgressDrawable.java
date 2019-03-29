package com.yuanmai.commonmodule.wigdet.progressbutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by ${zhanghui} on 2019/3/26.
 */

public class DProgressDrawable extends Drawable {
    private float mSweepAngle = 0;
    private float mStartAngle = -90;

    private RectF mRectF;
    private Paint mPaint;
    private Path mPath;

    private int mSize;
    private int mStrokeWidth;
    private int mStrokeWidthOut;
    private int mStrokeColor;
    private Context mContext;
    private RectF mMiddleRect;

    public DProgressDrawable(Context context, int size, int strokewidth, int strokewidthout, int strokecolor) {
        mContext=context;
        mSize = size;
        mStrokeWidth = strokewidth;
        mStrokeWidthOut = strokewidthout;
        mStrokeColor = strokecolor;

    }
    public void setmSweepAngle(float sweepAngle){
        mSweepAngle=sweepAngle;
    }

    public int getSize() {
        return mSize;
    }

    private RectF getRectInMiddle() {
        int size = getSize();
        mMiddleRect = new RectF(size/3, size/3, size - size/3, size - size/3);
        return mMiddleRect;

    }

    private RectF getRect(int stoken) {
        int size = getSize();
        int index = stoken / 2;
        mRectF = new RectF(index, index, size - index, size - index);
        return mRectF;
    }


    private Paint createPaint(int stokenWidth) {
        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setColor(mStrokeColor);
        }
        if(stokenWidth == 0){
            mPaint.setStyle(Paint.Style.FILL);
        }else{
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(stokenWidth);
        }


        return mPaint;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        final Rect bounds = getBounds();

        if (mPath == null) {
            mPath = new Path();
        }


        mPath.reset();
        mPath.addArc(getRect(mStrokeWidthOut), 0, 360);
        mPath.offset(bounds.left, bounds.top);
        canvas.drawPath(mPath, createPaint(mStrokeWidthOut));

        mPath.reset();
        mPath.addArc(getRect(mStrokeWidth), mStartAngle, mSweepAngle);
        mPath.offset(bounds.left, bounds.top);
        canvas.drawPath(mPath, createPaint(mStrokeWidth));

        mPath.reset();
        mPath.addRect(getRectInMiddle(), Path.Direction.CCW);
        mPath.offset(bounds.left, bounds.top);
        canvas.drawPath(mPath, createPaint(0));
    }

    @Override
    public void setAlpha(int i) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
