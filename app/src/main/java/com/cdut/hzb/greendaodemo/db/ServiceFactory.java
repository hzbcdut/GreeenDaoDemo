package com.cdut.hzb.greendaodemo.db;

/**
 * Created by hans on 2018/2/27 0027.
 */

public class ServiceFactory {

    private static DBService dbService;

    public static DBService getDbService() {
        if (dbService == null) {
            dbService = new DBService();
        }

        return dbService;
    }
}
