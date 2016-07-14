package com.deepblue.popwindowsdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2016/7/14 0014.
 */
public class PopWindow extends PopupWindow {
    private Context context;
    private DismissPop dismissPop;
    private View mMenuView;

    public PopWindow(int width, int height, Context context, DismissPop dismissPop) {
        super(width, height);
        this.context = context;
        this.dismissPop = dismissPop;
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.pop_layout, null);
        this.setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
    }

    public PopWindow(Context context, DismissPop dismissPop) {
        super(context);
        this.context = context;
        this.dismissPop = dismissPop;
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.pop_layout, null);
        this.setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
    }

    /**
     * pop消失接口
     */
    public interface DismissPop {
        void isDismiss(Boolean flag);
    }
}
