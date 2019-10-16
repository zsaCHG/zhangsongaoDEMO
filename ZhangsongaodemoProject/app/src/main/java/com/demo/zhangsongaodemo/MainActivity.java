package com.demo.zhangsongaodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.zhangsongaodemo.FragmentTest.TextFragmentActivity;
import com.demo.zhangsongaodemo.androidtest.CoordinatorLayoutActivity;
import com.demo.zhangsongaodemo.androidtest.LayoutParamsTest;
import com.demo.zhangsongaodemo.androidtest.NestedScroller.NestedActivity;
import com.demo.zhangsongaodemo.androidtest.SurfaceViewActivity;
import com.demo.zhangsongaodemo.androidtest.activitytest.TestActActivity;
import com.demo.zhangsongaodemo.ipc.IPCActivity;
import com.demo.zhangsongaodemo.viewtest.ViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    List<TextView> textViewList;

    List<String> textViewTitleList;

    private LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initLocalData();

        initTextViewTitle();

        initTextViews();

        initListener();
    }

    private void initView() {
        root = findViewById(R.id.ll_root);
    }

    private void initLocalData() {
        textViewList = new ArrayList<>();
        textViewTitleList = new ArrayList<>();
    }

    private void initTextViewTitle() {
        textViewTitleList.add("Fragment Test");
        textViewTitleList.add("LayoutPrams Test");
        textViewTitleList.add("SurfaceView Test");
        textViewTitleList.add("Coordinator ");
        textViewTitleList.add("NestedScroller");
        textViewTitleList.add("Activity Test");
        textViewTitleList.add("IPC Test");
        textViewTitleList.add("View Test");
    }

    private void initTextViews() {
        if (textViewTitleList != null) {
            for (int i = 0; i < textViewTitleList.size(); i++) {
                TextView textView = new TextView(this);
                textView.setText(textViewTitleList.get(i));
                textView.setId(i);
                textView.setPadding(20, 20, 20, 20);
                textViewList.add(textView);
                root.addView(textView);
            }
        }
    }

    public void initListener() {
        if (textViewList != null) {
            for (TextView textView : textViewList) {
                textView.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case 0:
                Intent intent = new Intent(this, TextFragmentActivity.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(this, LayoutParamsTest.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intentSuface = new Intent(this, SurfaceViewActivity.class);
                startActivity(intentSuface);
                break;
            case 3:
                Intent intentCoordinator = new Intent(this, CoordinatorLayoutActivity.class);
                startActivity(intentCoordinator);
                break;
            case 4:
                Intent intentNested = new Intent(this, NestedActivity.class);
                startActivity(intentNested);
                break;
            case 5:
                Intent intentActivity = new Intent(this, TestActActivity.class);
                startActivity(intentActivity);
                break;
            case 6:
                Intent intentIpc = new Intent(this, IPCActivity.class);
                startActivity(intentIpc);
                break;
            case 7:
                Intent intentViewTest = new Intent(this, ViewActivity.class);
                startActivity(intentViewTest);
                break;
        }
    }
}
