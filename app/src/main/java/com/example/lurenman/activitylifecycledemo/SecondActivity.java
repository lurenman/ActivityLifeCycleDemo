package com.example.lurenman.activitylifecycledemo;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * @author: baiyang.
 * Created on 2017/10/30.
 */

public class SecondActivity extends Activity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // savedInstanceState这个东西空不空不一定，需要判断
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.e(TAG, "onCreate: --------");
    }

    /*
    * 这个方法在异常销毁onPause()之后调用
    */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("onSave", "haha");
        Log.e(TAG, "onSaveInstanceState: -------");
    }

    /*
    * 这个方法在异常恢复onStart()之后调用
    */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //savedInstanceState这个东西一定不为空，不用判断，一般恢复数据都在这里，不建议在Oncreate方法中
        String onSaveString = (String) savedInstanceState.get("onSave");
        Log.e(TAG, "onRestoreInstanceState: -------");
        // Log.e(TAG, "onRestoreInstanceState: "+savedInstanceState.toString() );
        Log.e(TAG, "onRestoreInstanceState:" + onSaveString);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ------");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: --------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: -------");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: -------");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: -------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: --------");
    }
  /*  当清单文件配置android:configChanges="orientation|screenSize"这个调用的方法(不配置不调用)
  * */

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        if (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            //这个方法没走我草（红米note4测试）
            //横屏时候某些操作
            Toast.makeText(getApplicationContext(), "此时横屏", Toast.LENGTH_SHORT).show();
        }
        super.onConfigurationChanged(newConfig);
        int layoutDirection = newConfig.getLayoutDirection();
        String toString = newConfig.toString();
        Log.e(TAG, "onConfigurationChanged: --------");
        Log.e(TAG, "onConfigurationChanged:layoutDirection:" + layoutDirection);
        Log.e(TAG, "onConfigurationChanged:toString" + toString);

    }
}
