package example.com.carshop.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import example.com.carshop.contract.MyContract;

public class DBOpenHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;//数据库版本
    public static final String DB_NAME = "my.db";//数据库名

    private static  final String SQL_CREATE__ENTRY =
            "create table " + MyContract.UserEntry.TABLE_NAME + " (" +
                    MyContract.UserEntry._ID + " INTEGER primary key autoincrement," +
                    MyContract.UserEntry.COLUMN_NAME + " varchar(30), " +
                    MyContract.UserEntry.COLUMN_PSW + " varchar(30) " +

            ")";
    private static final String SQL_CREATE_PIC =
            "create table " + MyContract.PictureEntry.TABLE_NAME + " (" +
                    MyContract.PictureEntry._ID + " integer primary key autoincrement," +
                    MyContract.PictureEntry.COLUMN_PIC + " blob not null, " +
                    MyContract.PictureEntry.COLUMN_DETAIL + " text " +
                    ")";
    private static final String SQL_DELETE_ENTRY =
            "drop table if exists " + MyContract.UserEntry.TABLE_NAME;
    private static final String SQL_DELETE_PIC =
            "drop table if exists  " + MyContract.PictureEntry.TABLE_NAME;

    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //首次，数据库不存在时执行
        db.execSQL(SQL_CREATE__ENTRY);
        db.execSQL(SQL_CREATE_PIC);
        Log.i("一：------》","建表成功！");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_ENTRY);
        db.execSQL(SQL_DELETE_PIC);
        onCreate(db);
    }

}
