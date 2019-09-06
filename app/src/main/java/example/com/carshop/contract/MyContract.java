package example.com.carshop.contract;

import android.provider.BaseColumns;

public final class MyContract  {

    public MyContract() { }

    public static class UserEntry implements BaseColumns {
        public static  final String TABLE_NAME = "user";
        public static  final String COLUMN_NAME = "name";
        public static  final String COLUMN_PSW = "password";
    }
    public static class PictureEntry implements  BaseColumns{
        public static final String TABLE_NAME = "picture";
        public static final String COLUMN_PIC = "picture";
        public static final String COLUMN_DETAIL = "detail";
    }

}
