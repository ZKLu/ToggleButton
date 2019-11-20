package com.samlu.togglebutton.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

/**
 * Created by sam lu on 2019/11/20.
 */

public class ToggleButton extends View{

    //开关状态
    private ToggleState toggleState;
    private Bitmap slideBg;
    private Bitmap switchBg;

    public ToggleButton(Context context) {
        super(context);
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
}
