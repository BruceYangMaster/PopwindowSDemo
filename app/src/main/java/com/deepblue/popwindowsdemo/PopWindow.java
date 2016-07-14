package com.deepblue.popwindowsdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2016/7/14 0014.
 */
public class PopWindow extends PopupWindow {
    private Activity context;
    private View mMenuView;
    private PopWindow.OnDismissListener onDismissListener;

    public PopWindow(Activity context) {
        super(100, 100);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.pop_layout, null);
        this.setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
    }

    public void setOnDismissListener(PopWindow.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    /**
     * pop消失接口
     */
    public interface OnDismissListener {
        void onDismiss();
    }
}
