package com.demo.zhangsongaodemo.androidtest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.demo.zhangsongaodemo.R;

/**
 * Created by zsachg on 2018/9/5.
 */

public class MediaSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private SurfaceHolder surfaceHolder;
    private Canvas canvas;

    private Rect bitmapRect;

    private Bitmap bitmap;

    private Paint paint;

    private boolean isDrawing = true;


    public MediaSurfaceView(Context context) {
        super(context);
        intSurface();
    }

    private void intSurface() {
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
        paint = new Paint();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        Resources res = getResources();
        //abc_text_select_handle_left_mtrl_dark
        bitmap = BitmapFactory.decodeResource(res, R.drawable.abc_text_select_handle_left_mtrl_dark);
    }

    public MediaSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        intSurface();
    }

    public MediaSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intSurface();
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        isDrawing = false;
    }

    @Override
    public void run() {
        while (isDrawing) {
            draw();
        }
    }

    private void draw() {
        try {
            canvas = surfaceHolder.lockCanvas();
            if (canvas != null && bitmap!=null) {
//                canvas.drawColor(Color.WHITE);
                canvas.drawBitmap(bitmap, null, bitmapRect, paint);
            }
        }catch(Exception e){

        }
        finally {
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public void updatePositionAndSize(Rect rect) {
        this.bitmapRect = rect;
    }

    public void stopDraw() {
        isDrawing = false;

    }

    public void startDraw() {
        isDrawing = true;
    }


}
