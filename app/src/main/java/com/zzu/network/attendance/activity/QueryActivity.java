package com.zzu.network.attendance.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.zzu.network.attendance.R;
import com.zzu.network.attendance.bean.Student;
import com.zzu.network.attendance.gen.StudentDao;
import com.zzu.network.attendance.manager.GreenDaoManager;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryActivity extends AppCompatActivity {
    private static String TAG = "QueryActivity";

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        Log.d(TAG, "onCreate");
        listView = (ListView) findViewById(R.id.list1);
        initData();
    }

    private void initData() {
        List<Student> students = GreenDaoManager.getInstance().getNewSession().getStudentDao().queryBuilder()
                .where(StudentDao.Properties.Noclass.notEq(0)).build().list();
        Log.d(TAG, "initData students:" + students);
        if (students == null) {
            Toast.makeText(this, "获取学生信息失败，请稍后再试！", Toast.LENGTH_SHORT).show();
            finish();
        }
        List<Map<String, String>> maps = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", students.get(i).getName());
            map.put("sid", students.get(i).getSid());
            map.put("absent", students.get(i).getNoclass() + "次");
            maps.add(map);
        }
        String[] strings = {"name", "sid", "absent"};
        int[] ids = {R.id.name, R.id.sid, R.id.absent};
        Log.d(TAG, "initData maps:" + maps);
        SimpleAdapter adapter = new SimpleAdapter(this, maps, R.layout.item_query, strings, ids);
        listView.setAdapter(adapter);
    }
}
