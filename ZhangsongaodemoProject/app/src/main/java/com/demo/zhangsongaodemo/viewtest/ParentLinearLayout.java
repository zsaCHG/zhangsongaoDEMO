package com.demo.zhangsongaodemo.viewtest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * @Description:
 * @Tips:
 * @Author: zsachg
 * @CreateData: 2019-10-14 14:43
 * @Version: 1.0
 * @UpdateRemark: 更新说明
 * @数据来源:
 * @View处理逻辑: 标准
 * @数据流程:
 * @注意事项: 无
 * @修改提示: 无
 */
public class ParentLinearLayout extends LinearLayout {

    public ParentLinearLayout(Context context) {
        super(context);
    }

    public ParentLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ParentLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Touch","parent onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

}
