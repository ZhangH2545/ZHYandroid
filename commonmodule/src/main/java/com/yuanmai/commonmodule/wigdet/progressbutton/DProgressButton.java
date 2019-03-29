package com.yuanmai.commonmodule.wigdet.progressbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

import com.yuanmai.commonmodule.R;

/**
 * Created by zhanghui on 2019/3/26.
 * DownloadProgressButton下载进度条控件
 */

public class DProgressButton extends Button implements ProgressListener {
    private Drawable mBackground;
    private int mStrokeColor;
    private int mStokeWidth = 0;
    private int mStokeWidthOut = 0;
    private STATE mState = STATE.NORMAL;
    private float mFromCornerRadius = 40;

    private static String[] statusString = new String[]{"download", "pause", "complete", "error", "delete"};

    public enum STATE {
        PROGRESS, NORMAL
    }

    public DProgressButton(Context context) {
        super(context);
    }

    public DProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DProgressButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DProgressButton);
        try {
            mStrokeColor = typedArray.getColor(R.styleable.DProgressButton_color, -1);
            mBackground = typedArray.getDrawable(R.styleable.DProgressButton_drawable_xml);
            mStokeWidthOut = typedArray.getInteger(R.styleable.DProgressButton_stroke_width, -1);
            mFromCornerRadius = typedArray.getDimension(R.styleable.DProgressButton_radius, -1);
        } finally {
            typedArray.recycle();
        }

        if (mStrokeColor == -1) {
            mStrokeColor = getResources().getColor(R.color._000000);
        }
        if (mBackground == null) {
            throw new NullPointerException("drawable_xml can not be null");
        }

        if (mStokeWidthOut == -1) {
            mStokeWidthOut = dip2px(getContext(), 1);
        }
        if (mFromCornerRadius == -1) {
            throw new NullPointerException("radius must can not be null");
        }
        mStokeWidth = mStokeWidthOut * 3;
    }

    /**
     * 自己定义状态
     *
     * @param status
     */
    public void initStatus(String[] status) {
        if (status != null && status.length > 0) {
            statusString=status;
        }


    }


    @Override
    public void download(int progress) {

    }

    @Override
    public void normal(int status) {

    }

    @Override
    public void startDownload() {

    }


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
