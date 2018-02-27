package com.cdut.hzb.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cdut.hzb.greendaodemo.db.Book;
import com.cdut.hzb.greendaodemo.db.DBService;
import com.cdut.hzb.greendaodemo.db.ServiceFactory;
import com.cdut.hzb.greendaodemo.db.Student;
import com.cdut.hzb.greendaodemo.db.bean.BookDao;
import com.cdut.hzb.greendaodemo.db.bean.StudentDao;

import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText editText;
    private TextView tv;

    private StudentDao studentDao;
    private BookDao bookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et);
        tv = findViewById(R.id.tv);

        DBService dbService = ServiceFactory.getDbService();
        studentDao = dbService.getStudentDao();

        bookDao = dbService.getBookDao();
    }

    public void insertData(View view) {
        String name = editText.getText().toString();
        if (!TextUtils.isEmpty(name)) {

            Student student = new Student();
            student.setName(name);

//            long id = studentDao.insertOrReplace(student);   // 插入一条数据
//            Student s = studentDao.load(id);  // 根据id查询一条数据

//            Log.d("debug", TAG + "  student = " + student + " s = " + s);

            Student student1 = new Student();
            student1.setName("ehjfeow");

            List<Student> lists = new ArrayList<>();
            lists.add(student);
            lists.add(student1);
            studentDao.insertInTx(lists);
        }
    }

    public void queryAll(View view) {
        // 这是按照数据插入的顺序将所有的数据查询出来的
        List<Student> lists = studentDao.loadAll();

        // 根据某个字段进行排序
        lists = query();

        StringBuilder stringBuilder = new StringBuilder();

        for (Student student : lists) {
            stringBuilder.append(student.getName()).append("_");
        }

        tv.setText(stringBuilder.toString());
    }

    // 条件查询
    public List<Student>  query() {
        // 根据名字来排序
        QueryBuilder<Student> studentQueryBuilder = studentDao.queryBuilder();
        Property nameProperty = StudentDao.Properties.Name;
        List<Student> ordersStudents = studentQueryBuilder.orderAsc(nameProperty).limit(1).list();
//        studentQueryBuilder.count();

        return ordersStudents;
    }



    public void queryDataMultiTable(View view) { // 多表关联查询
        Book book1 = new Book(1101L, 110L, "哈利波特");
        Book book2 = new Book(1102L, 110L, "哈哈");
        Book book3 = new Book(1103L,110L, "死亡圣器");

        bookDao.insertOrReplaceInTx(book1, book2, book3);  //使用事务插入或替换数据

        Student student = new Student(110L, "huzhengbiao");
//        student.setName("huzhengbiao");

        studentDao.insertOrReplace(student);

        Query<Student> query = studentDao.queryBuilder().where(StudentDao.Properties.Name.eq("huzhengbiao")).build();

        for (Student studentS :  query.list()) {
            Log.i("debug_log", " studentS = " + studentS);

            // 获取这个表关联的另一个表的数据时， 是懒加载？ 在调用getX()方法后才会返回数据。
            List<Book> books = studentS.getBooks();
            Log.i("debug_log", "  books = " + books);
            for (Book book: books) {
                Log.i("debug_log", " bookName = " + book.getBookName());
            }
        }
    }

}
