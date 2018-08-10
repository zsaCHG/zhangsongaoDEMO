package com.demo.zhangsongaodemo.FragmentTest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.zhangsongaodemo.R;

/**
 * Created by zsachg on 2018/3/15.
 */

public class TestFragment extends Fragment {


    TextView textView;

    View view;

    private static int flag;

    Integer integer;

    private String string;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        flag=this.hashCode();
        Log.d("text9090",flag+"F onAttach");
        string=getArguments().getString("dfd");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("text9090",flag+"F onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("text9090",flag+"F onCreateView");
        view=inflater.inflate(R.layout.fragment_text,null);
        textView=(TextView) view.findViewById(R.id.tv_ss);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getIntent();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("text9090",flag+"F onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("text9090",flag+"F onResume");
        getActivity().getIntent();
        if (string != null) {
            string.toString();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("text9090",flag+"F onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("text9090",flag+"F onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("text9090",flag+"F onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("text9090",flag+"F onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("text9090",flag+"F onDetach");
    }

    public void setData(){
        getActivity().getIntent();
    }

    public void setVI(){
        view.setVisibility(View.GONE);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void setIn(Integer s){
        this.integer=s;
    }
}
