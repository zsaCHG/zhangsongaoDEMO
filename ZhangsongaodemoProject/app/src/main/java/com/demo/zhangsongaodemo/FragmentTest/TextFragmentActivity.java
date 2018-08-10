package com.demo.zhangsongaodemo.FragmentTest;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.demo.zhangsongaodemo.R;

/**
 * 主要测试fragment的生命周期和标准用法
 */
public class TextFragmentActivity extends android.support.v4.app.FragmentActivity {

    TestFragment testFragment;

    private FrameLayout frameLayout;

    private static int k=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("text9090","a onCreate");
        setContentView(R.layout.activity_fragment);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("text9090","A onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("text9090","A onResume");
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                    if (testFragment != null) {

                    }else {
                        testFragment=new TestFragment();
                        testFragment.setIn(2);
                    }
                    Bundle bundle=new Bundle();
                    bundle.putString("dfd","dfdfd");
                    testFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,testFragment).commit();
                    k++;
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d("text9090","A onStart");
        super.onStart();
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("text9090","A onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("text9090","A SaveIns");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("text9090","A onStop");
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return super.onRetainCustomNonConfigurationInstance();
    }


}
