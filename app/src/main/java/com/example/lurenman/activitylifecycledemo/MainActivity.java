package com.example.lurenman.activitylifecycledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button bt_skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate:------ ");
        bt_skip = (Button) findViewById(R.id.bt_skip);
        bt_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

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
}
