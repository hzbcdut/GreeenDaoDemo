package com.cdut.hzb.greendaodemo.db;

import android.content.Context;

import com.cdut.hzb.greendaodemo.db.bean.DaoMaster;
import com.cdut.hzb.greendaodemo.db.bean.DaoSession;
import com.cdut.hzb.greendaodemo.db.bean.StudentDao;

/**
 * Created by hans on 2018/2/26 0026.
 *
 * vert-tv  DBMaster
 *
 */

public class DBService {
    private static final String DB_NAME = "greedDaoDemo.db";
    private DaoSession daoSession;

    public void init(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME);

        DaoMaster daoMaster = new DaoMaster(helper.getWritableDb());

        daoSession = daoMaster.newSession();
    }

    public StudentDao getStudentDao() {
        return daoSession.getStudentDao();
    }
}
