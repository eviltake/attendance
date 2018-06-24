package com.zzu.network.attendance.manager;

import android.content.Context;

import com.zzu.network.attendance.gen.DaoMaster;
import com.zzu.network.attendance.gen.DaoSession;

public class GreenDaoManager {
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private static volatile GreenDaoManager instance = null;

    private GreenDaoManager(Context context) {
        if (instance == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "student.db");
            daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            daoSession = daoMaster.newSession();
        }
    }

    public static void init(Context context) {
        if (instance == null) {
            synchronized (GreenDaoManager.class) {
                if (instance == null) {
                    instance = new GreenDaoManager(context);
                }
            }
        }
    }

    public static GreenDaoManager getInstance() {
        return instance;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public DaoSession getNewSession() {
        daoSession = daoMaster.newSession();
        return daoSession;
    }
}
