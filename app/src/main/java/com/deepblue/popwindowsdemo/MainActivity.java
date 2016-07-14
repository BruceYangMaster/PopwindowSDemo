package com.deepblue.popwindowsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
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
        showPopWindow();
    }

    /**
     * 显示popubwindow窗口
     */
    private void showPopWindow() {
        //父布局
        parentLayout = (RelativeLayout) findViewById(R.id.container);
        //启动按钮
        Button mButton = (Button) findViewById(R.id.btn);
        //添加监听
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindow = new PopWindow(MainActivity.this);
//                popWindow.setOnDismissListener(new PopWindow.OnDismissListener() {
//                    @Override
//                    public void onDismiss() {
////                        popWindow.dismiss();
//                        Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_SHORT).show();
//                    }
//                });
                popWindow.showAtLocation(parentLayout, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置

            }
        });
    }

}
