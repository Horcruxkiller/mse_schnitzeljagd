package com.example.daniel.schnitzeljagd;

import android.app.Application;

import com.example.daniel.schnitzeljagd.model.DaoMaster;
import com.example.daniel.schnitzeljagd.model.DaoMaster.DevOpenHelper;
import com.example.daniel.schnitzeljagd.model.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Daniel on 19.06.2017.
 */

public class App extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DevOpenHelper helper = new DevOpenHelper(this, "user-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return this.daoSession;
    }
}
