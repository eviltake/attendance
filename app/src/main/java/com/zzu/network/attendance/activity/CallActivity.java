package com.zzu.network.attendance.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zzu.network.attendance.R;
import com.zzu.network.attendance.bean.Student;
import com.zzu.network.attendance.manager.GreenDaoManager;

import java.util.List;

public class CallActivity extends AppCompatActivity {
    private static String TAG = "CallActivity";

    private TextView nameTV;
    private TextView sidTV;
    private TextView absentTV;
    private TextView leavaTV;
    private List<Student> students;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        //加载布局中的activity_call文件
        setContentView(R.layout.activity_call);
        initUI();
        initData();
    }
    //在页面显示
    private void initUI() {
        nameTV = (TextView) findViewById(R.id.name);
        sidTV = (TextView) findViewById(R.id.sid);
        absentTV = (TextView) findViewById(R.id.absenteeism);
        leavaTV=(TextView)findViewById(R.id.leavaNum);
    }
    //数据库
    private void initData() {
        Log.d(TAG, "initData");
        students = GreenDaoManager.getInstance().getNewSession().getStudentDao().queryBuilder().list();
        Log.d(TAG, "students:" + students);
        index = 0;
        show();
    }

    private void show() {
        Log.d(TAG, "show：" + index);
        if (students == null || students.size() < 1) {
            //若数据库无学生，则弹出提示框，提示先添加学生
            Toast.makeText(this, "请先添加学生信息！", Toast.LENGTH_SHORT).show();
            finish();
            return  ;
        }
        if (index < 0) {
            return;
        }
        if (index >= students.size()) {
            Toast.makeText(this, "点名完毕~", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        //显示学生姓名
        nameTV.setText(students.get(index).getName());
        //显示学生学号
        sidTV.setText(students.get(index).getSid());
        //显示学生旷课的次数
        absentTV.setText(String.valueOf(students.get(index).getNoclass()));

        leavaTV.setText(String.valueOf(students.get(index).getLeava()));
    }
    //点击call已到，index+1
    public void attend(View view) {
        Log.d(TAG, "attend");
        index++;
        show();
    }
    //点击call里面的未到，旷课+1，更新到数据库，index+1
    public void absent(View view) {
        Log.d(TAG, "absent");
        Student student = students.get(index);
        student.setNoclass(student.getNoclass() + 1);
        GreenDaoManager.getInstance().getNewSession().getStudentDao().update(student);
        index++;
        show();
    }
    //点击call里面的请假，请假+1，更新到数据库，index+1
    public void qingJia(View view) {
        Log.d(TAG, "qingJia");
        Student student = students.get(index);
        student.setLeava(student.getLeava() + 1);
        GreenDaoManager.getInstance().getNewSession().getStudentDao().update(student);
        index++;
        show();
    }
}
