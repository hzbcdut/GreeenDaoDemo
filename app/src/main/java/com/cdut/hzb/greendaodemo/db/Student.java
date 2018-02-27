package com.cdut.hzb.greendaodemo.db;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by hans on 2018/2/26 0026.
 *  新建实体类Student 在app/build/generated/greendao目录下生成DaoMaster, DaoSession, StudentDao
 *  [build/generated/source/greendao是默认路径，可以去配置的，配置方法在接下来将会讲到。](http://blog.csdn.net/Chaosminds/article/details/72722139)
 *
 */
@Entity
public class Student {
    @Id(autoincrement = true)
    private Long id;

    @NonNull
    private String name;

    @Generated(hash = 1124112952)
    public Student(Long id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
