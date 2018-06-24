package com.zzu.network.attendance.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import com.zzu.network.attendance.R;
import com.zzu.network.attendance.manager.GreenDaoManager;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate init:" + getApplicationContext());
        GreenDaoManager.init(getApplicationContext());
        setContentView(R.layout.activity_main);

    }

    //按下按钮会调到指定的类
    public void call(View view) {
        Log.d(TAG, "call");
        startActivity(new Intent(this, CallActivity.class));
    }

    public void insert(View view) {
        Log.d(TAG, "insert");
        startActivity(new Intent(this, InsertActivity.class));
    }
    public void leava(View view) {
        Log.d(TAG, "leava");
        startActivity(new Intent(this, LeavaActivity.class));
    }

    public void query(View view) {
        Log.d(TAG, "query");
        startActivity(new Intent(this, QueryActivity.class));
    }

    public void queryall(View view) {
        Log.d(TAG, "queryall");
        startActivity(new Intent(this, QueryallActivity.class));
    }


    public void onClick(View view) {
                AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                alert.setTitle("退出？");
                alert.setMessage("真的要退出吗？");
                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "不", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alert.setButton(DialogInterface.BUTTON_POSITIVE, "是的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alert.show();
            }


//    public void exit(View view) {
//        Log.d(TAG, "exit");
//        Button button = (Button) findViewById(R.id.button5);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
//                alert.setTitle("退出？");
//                alert.setMessage("真的要退出吗？");
//                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "不", new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                    }
//                });
//                alert.setButton(DialogInterface.BUTTON_POSITIVE, "是的", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        finish();
//                    }
//                });
//                alert.show();
//            }
//        });
//      }
    }
