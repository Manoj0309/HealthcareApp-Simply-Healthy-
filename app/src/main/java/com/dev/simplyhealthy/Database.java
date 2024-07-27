package com.dev.simplyhealthy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    private char[] fees;

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(username text,email text,password text)";
        sqLiteDatabase.execSQL(qry1);

        String qry2 = "create table  cart(username text,address text,contactno text,pincode text)";
        sqLiteDatabase.execSQL(qry2);

        String qry3 = "create table orderplace(username text, address text,contactno text,pincode int)";
        sqLiteDatabase.execSQL(qry3);

        String qry4 = "create table lab(username text,address text,contactno text,pincode text)";
        sqLiteDatabase.execSQL(qry4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String username, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, cv);
        db.close();

    }

    public int login(String username, String password) {
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username=? and password=?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        return result;
    }

    public void cart(String username, String Address,String pincode ,String contact) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("Address", Address);
        cv.put("pincode", pincode);
        cv.put("contact", contact);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("cart", null, cv);
        db.close();
    }


        public void addOrder(String username, String fullname, String address, String contact){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("fullname",fullname);
        cv.put("address",address);
        cv.put("contactno",contact);


        SQLiteDatabase db = getWritableDatabase();
        db.insert("orderplace",null,cv);
        db.close();
    }

    public void addBook(String username, String fullname, String address,String contact,int pinciode,String date,String time,Float fees,String otype){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("fullname",fullname);
        cv.put("contactno",contact);
        cv.put("pincode",pinciode);
        cv.put("date",date);
        cv.put("time",time);
        cv.put("fees",fees);
        cv.put("otype",otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("orderplace",null,cv);
        db.close();
    }




    public  int checkAppointmentExists(String username, String fullname, String address, String contact, String date, String time, float v)
    {
        int result=0;
        String str[] = new String[7];
        str[0]=  username ;
        str[1]=  fullname ;
        str[2]=   address;
        str[3]=   contact;
        str[4] = String.valueOf(fees);
        str[5]=   date;

        str[6]=   time;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from orderplace where username = ? and fullname = ? and addres = ? and contctno = ? and date = ? and time = ?",str);
        if (c.moveToFirst()){
            result=1;
        }
        db.close();
        return  result;
    }
    public ArrayList getOrderData(String username){
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username ;
        Cursor c = db.rawQuery("select * from orderplace where username = ?",str);
        if (c.moveToFirst()){
            do {
                arr.add(c.getString(1)+"$"+c.getString(2)+"$"+c.getString(3)+"$"+c.getString(4)+"$"+c.getString(5)+"$"+c.getString(6)+"$"+c.getString(7)+"$"+c.getString(8));
            }while (c.moveToNext());
        }
        db.close();
        return arr;
    }



}
