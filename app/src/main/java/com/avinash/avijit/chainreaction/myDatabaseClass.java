package com.avinash.avijit.chainreaction;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

public class myDatabaseClass {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "persons_name";
    public static final String KEY_PASSWORD = "password";

    private static final String DATABASE_NAME = "myDb";
    private static final String DATABASE_TABLE = "peopleTable";
    private static final int DATABASE_VERSION = 1;

    private DbHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    public long createEntry(String name, String password) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME , name);
        cv.put(KEY_PASSWORD , password);
        return ourDatabase.insert(DATABASE_TABLE, null, cv);
    }

    public String check(String s, String s1) {
        String[] columns = new String[]{KEY_ROWID, KEY_NAME, KEY_PASSWORD};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_NAME + "=?",new String[] { String.valueOf(s)},  null, null, null, null);
        if(c.moveToFirst()){
            String psword = c.getString(c.getColumnIndex(KEY_PASSWORD));
            if (psword.equals(s1)){
                return "success";
            }
        }
        return "failed";
    }




    private static class DbHelper extends SQLiteOpenHelper {
        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_NAME + " TEXT NOT NULL, " +
                    KEY_PASSWORD + " TEXT NOT NULL);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(" DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }

    }
    public myDatabaseClass(Context c) {

        ourContext = c;
    }

    public myDatabaseClass open(){
        ourHelper = new DbHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close(){

        ourHelper.close();
    }
}
