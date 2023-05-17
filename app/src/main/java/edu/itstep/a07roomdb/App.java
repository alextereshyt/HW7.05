package edu.itstep.a07roomdb;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    private static App app;
    private PhoneBookDB phoneBookDB;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        phoneBookDB = Room.databaseBuilder(
                        this,
                        PhoneBookDB.class,
                        "PhoneBook"
                ).allowMainThreadQueries().build();
    }

    public static App getInstance() {
        return app;
    }

    public PhoneBookDB getPhoneBookDB() {
        return phoneBookDB;
    }
}
