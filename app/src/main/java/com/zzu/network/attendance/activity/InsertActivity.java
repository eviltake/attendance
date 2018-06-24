package com.zzu.network.attendance.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zzu.network.attendance.R;
import com.zzu.network.attendance.bean.Student;
import com.zzu.network.attendance.manager.GreenDaoManager;

public class InsertActivity extends Activity {
    private static String TAG = "InsertActivity";

    private EditText nameET;
    private EditText sidET;
    private EditText classET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_insert);
        initUI();
    }

    private void initUI() {
        nameET = (EditText) findViewById(R.id.name);
        sidET = (EditText) findViewById(R.id.sid);
        classET = (EditText) findViewById(R.id.classes);
    }

    public void confirm(View view) {
        Log.d(TAG, "confirm");
        //获取用户输入的信息
        String name = nameET.getText().toString();
        String sid = sidET.getText().toString();
        String classes = classET.getText().toString();
        //若用户输入信息不全，则提出警示信息
        if (isNull(name) || isNull(sid) || isNull(classes)) {
            Toast.makeText(this, "请补全所有信息！", Toast.LENGTH_SHORT).show();
            return;
        }
        //获得的数据封装成类建立在数据库中，
        Student student = new Student(null, name, sid, classes, 0,0);
        GreenDaoManager.getInstance().getNewSession().getStudentDao().insert(student);
        Toast.makeText(this, "新增学生信息成功！", Toast.LENGTH_SHORT).show();
    }

    public void cancel(View view) {
        Log.d(TAG, "cancel");
        finish();
    }
   //判断输入数据不是空格或者为空
    private boolean isNull(String string) {
        if (string == null) {
            return true;
        }
        if (string.length() < 1) {
            return true;
        }
        return false;
    }
}
