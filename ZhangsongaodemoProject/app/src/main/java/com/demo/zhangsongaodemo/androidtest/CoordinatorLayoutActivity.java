package com.demo.zhangsongaodemo.androidtest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.zhangsongaodemo.R;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorLayoutActivity extends Activity {

    private TextView textViewClick;

    private TextView textViewFollow;

    private TextView tv_click2;

    private CoordinatorLayout coordinatorLayoutActivity;

    private RecyclerView recycle_test;

    private List<String> stringList;

    private AppBarLayout apl;

    private TextView tv_personal;

    private RecyclerView rv_personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        stringList=new ArrayList<>();
        initView();
        initRecycle(recycle_test);
        initRecycle(rv_personal);
    }

    private void initView(){
        coordinatorLayoutActivity =findViewById(R.id.ctl);
        textViewClick=findViewById(R.id.tv_click);
        textViewFollow=findViewById(R.id.tv_follow);
        tv_click2=findViewById(R.id.tv_click2);
        recycle_test=findViewById(R.id.recycle_test);
        apl=findViewById(R.id.abl);
        tv_personal=findViewById(R.id.tv_personal);
        rv_personal=findViewById(R.id.rv_personal);
        tv_click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tv_click2.setX(tv_click2.getX()+50);
                tv_click2.getLayoutParams().height=10;
            }
        });
        textViewClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewClick.setX(textViewClick.getX()+50);
//                textViewClick.setText("textViewClick.setX(textViewClick.getX()+50);");
            }
        });
    }

    private void initRecycle(RecyclerView recyclerView){
        for (int i = 0; i < 100; i++) {
            stringList.add("这时第几个"+i);
        }
        RecyclerView.LayoutManager layout=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);

        Adapter adapter=new Adapter(stringList, this);
        recyclerView.setAdapter(adapter);
    }


    public static class Adapter extends RecyclerView.Adapter{

        private List<String> list;

        private Context context;

        public Adapter(List<String> list, Context context) {
            this.list=list;
            this.context=context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            RelativeLayout relative=new RelativeLayout(context);
            TextView textView=new TextView(context);
            textView.setText("失误失误");
            relative.addView(textView);
            return new Holder(relative);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return this.list.size();
        }

        class Holder extends RecyclerView.ViewHolder{

            public Holder(View itemView) {
                super(itemView);
            }
        }
    }



}
