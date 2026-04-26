package com.example.library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "library.db";
    private static final int DB_VERSION = 1;

    private static DBHelper instance;

    public static synchronized DBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DBHelper(context.getApplicationContext());
        }
        return instance;
    }

    private DBHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE books(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, author TEXT, status TEXT DEFAULT 'available')");
        db.execSQL("CREATE TABLE students(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, roll TEXT UNIQUE)");
        db.execSQL("CREATE TABLE lend(id INTEGER PRIMARY KEY AUTOINCREMENT, book_id INTEGER, student_id INTEGER, lend_date TEXT, return_date TEXT)");
        db.execSQL("CREATE TABLE reservations(id INTEGER PRIMARY KEY AUTOINCREMENT, book_id INTEGER, student_id INTEGER, reserve_date TEXT)");
        
        // Seed sample data
        db.execSQL("INSERT INTO books(title, author) VALUES('Java Programming', 'Gosling')");
        db.execSQL("INSERT INTO books(title, author) VALUES('Android Dev', 'Meier')");
        db.execSQL("INSERT INTO students(name, roll) VALUES('Alice', 'CS001')");
        db.execSQL("INSERT INTO students(name, roll) VALUES('Bob', 'CS002')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");
        db.execSQL("DROP TABLE IF EXISTS students");
        db.execSQL("DROP TABLE IF EXISTS lend");
        db.execSQL("DROP TABLE IF EXISTS reservations");
        onCreate(db);
    }

    public Cursor getAvailableBooks() {
        return getReadableDatabase().rawQuery("SELECT * FROM books WHERE status='available'", null);
    }

    public Cursor getLentBooks() {
        return getReadableDatabase().rawQuery(
                "SELECT b.title, s.name, l.lend_date FROM lend l " +
                "JOIN books b ON l.book_id=b.id " +
                "JOIN students s ON l.student_id=s.id", null);
    }

    public Cursor getReservations() {
        return getReadableDatabase().rawQuery(
                "SELECT b.title, s.name, r.reserve_date FROM reservations r " +
                "JOIN books b ON r.book_id=b.id " +
                "JOIN students s ON r.student_id=s.id", null);
    }

    public void lendBook(int bookId, int studentId, String date) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues cv = new ContentValues();
            cv.put("book_id", bookId);
            cv.put("student_id", studentId);
            cv.put("lend_date", date);
            db.insert("lend", null, cv);
            
            ContentValues bookCv = new ContentValues();
            bookCv.put("status", "lent");
            db.update("books", bookCv, "id=?", new String[]{String.valueOf(bookId)});
            
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    public void reserveBook(int bookId, int studentId, String date) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("book_id", bookId);
        cv.put("student_id", studentId);
        cv.put("reserve_date", date);
        db.insert("reservations", null, cv);
    }

    public void addBook(String title, String author) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", title);
        cv.put("author", author);
        db.insert("books", null, cv);
    }

    public void deleteBook(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("books", "id=?", new String[]{String.valueOf(id)});
    }
}
