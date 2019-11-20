package com.samlu.togglebutton.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by sam lu on 2019/11/20.
 */

public class ToggleButton extends View{

    //开关状态
    private ToggleState toggleState = ToggleState.Open;
    private Bitmap slideBg;
    private Bitmap switchBg;
    private int currentX;//当前触摸点x轴坐标
    private boolean isSlide ;

    public ToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public enum ToggleState{
        Open , Close
    }

    /**设置滑动块的背景图片
    *@param
    *@return
    */
    public void setSlideBackgroundResource(int resource){
        slideBg = BitmapFactory.decodeResource(getResources(),resource);
    }

    /**设置滑动开关的背景图片
    *@param 
    *@return 
    */
    public void setSwitchBackgroundResource(int resource) {
        switchBg = BitmapFactory.decodeResource(getResources(),resource);
    }

    /**设置开关的状态
    *@param
    *@return
    */
    public void setToggleState(ToggleState state) {
        toggleState = state;
    }

    /**设置当前控件显示在屏幕上的宽高
    *@param
    *@return
    */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(switchBg.getWidth(),switchBg.getHeight());
    }

    /**绘制控件显示在屏幕上的样子
    *@param
    *@return
    */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制背景图片
        //第二个参数left:要绘制的图片的左边缘的x轴坐标，第三个参数top:要绘制的图片的顶部的y轴左边
        canvas.drawBitmap(switchBg,0,0,null);

        //滑块的中心跟随鼠标
        if (isSlide){
            int left = currentX - slideBg.getWidth()/2;
            if (left < 0) left =0;
            if (left > switchBg.getWidth() - slideBg.getWidth()) left = switchBg.getWidth()-slideBg.getWidth();
            canvas.drawBitmap(slideBg,left,0,null);
        }else {
            //停止滑动,根据state去绘制滑动块的位置
            if (toggleState == ToggleState.Open){
                //绘制滑动块的图片
                canvas.drawBitmap(slideBg,switchBg.getWidth()-slideBg.getWidth(),0,null);
            }else {
                canvas.drawBitmap(slideBg,0,0,null);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = (int) event.getX();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                isSlide = true;
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                isSlide = false;
                int centerX = switchBg.getWidth()/2;
                if (currentX > centerX){
                    //open
                    if (toggleState != ToggleState.Open){
                        toggleState = ToggleState.Open;
                        if (listener != null){
                            listener.onToggleStateChange(toggleState);
                        }
                    }

                }else {
                    //close
                    if (toggleState != ToggleState.Close){
                        toggleState = ToggleState.Close;
                        if (listener != null){
                            listener.onToggleStateChange(toggleState);
                        }
                    }

                }
                if (listener != null){
                    listener.onToggleStateChange(toggleState);
                }
                break;
        }
        invalidate();
        return true;
    }


    private OnToggleStateChangeListener listener;
    public  void setOnToggleStateChangeListener(OnToggleStateChangeListener listener){
        this.listener = listener;
    }

    public interface  OnToggleStateChangeListener{
        void onToggleStateChange(ToggleState state);
    }
}
