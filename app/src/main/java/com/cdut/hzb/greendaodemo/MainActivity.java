package com.cdut.hzb.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.cdut.hzb.greendaodemo.db.DBService;
import com.cdut.hzb.greendaodemo.db.ServiceFactory;
import com.cdut.hzb.greendaodemo.db.Student;
import com.cdut.hzb.greendaodemo.db.bean.StudentDao;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText editText;
    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et);

        DBService dbService = ServiceFactory.getDbService();
        studentDao = dbService.getStudentDao();
    }

    public void insertData(View view) {
        String name = editText.getText().toString();
        if (!TextUtils.isEmpty(name)) {

            Student student = new Student();
            student.setName(name);

            long id = studentDao.insert(student);
            Student s = studentDao.load(id);

            Log.d("debug", TAG + "  student = " + student + " s = " + s);

        }
    }
}
