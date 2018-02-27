package com.cdut.hzb.greendaodemo;

import android.app.Application;

import com.cdut.hzb.greendaodemo.db.DBService;
import com.cdut.hzb.greendaodemo.db.ServiceFactory;

/**
 * Created by hans on 2018/2/27 0027.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DBService dbService = ServiceFactory.getDbService();
        dbService.init(this);

    }
}
