package com.deepblue.popwindowsdemo;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private PopupWindow pop = null;
    private RelativeLayout parentLayout;
    private PopWindow popWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        bingView();
        bindViewOther();
    }

    private void bindViewOther() {
        parentLayout = (RelativeLayout) findViewById(R.id.container);
        //
        Button mButton = (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindow = new PopWindow(100, 200, MainActivity.this, new PopWindow.DismissPop() {
                    @Override
                    public void isDismiss(Boolean flag) {
                        if (flag) {
                            popWindow.dismiss();
                            finish();
                        }
                    }
                });
                popWindow.showAtLocation(parentLayout, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置

            }
        });
    }

    private void bingView() {
        parentLayout = (RelativeLayout) findViewById(R.id.container);
        //
        Button mButton = (Button) findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop = new PopupWindow(MainActivity.this);
                View popView = getLayoutInflater().inflate(R.layout.pop_layout,
                        null);
                pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                pop.setBackgroundDrawable(new BitmapDrawable());
                pop.setFocusable(true);
                pop.setOutsideTouchable(true);
                pop.setContentView(popView);
                //
                pop.showAtLocation(parentLayout, Gravity.BOTTOM, 0, 0);
            }
        });
    }
}
