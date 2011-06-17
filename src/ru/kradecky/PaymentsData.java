package ru.kradecky;

import java.util.Calendar;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PaymentsData extends SQLiteOpenHelper 
{
	
	private static final String DATABASE_NAME = "payments.db";
	private static final int    DATABASE_VER  = 1;

	public PaymentsData (Context context)
	{
		super (context, DATABASE_NAME, null, DATABASE_VER);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		String now = Calendar.getInstance().getTime().toString();
		db.execSQL("create table " + Constants.TARIFF_TABLE + " ( " + 
				Constants._ID          + " integer primary key autoincrement, " +
				Constants.TARIFF_TYPE  + " integer not null, " + 
				Constants.TARIFF_DATE  + " text    not null, " +
				Constants.TARIFF_VALUE + " numeric not null );");
		db.execSQL("create table " + Constants.COUNTER_TABLE + " (" + 
				Constants._ID           + " integer primary key autoincrement, " + 
				Constants.COUNTER_TYPE  + " integer not null, " + 
				Constants.COUNTER_DATE  + " integer not null, " + 
				Constants.COUNTER_VALUE + " numeric not null );");
		db.execSQL("insert into " + Constants.TARIFF_TABLE + " ( " + Constants.TARIFF_TYPE + ", " + Constants.TARIFF_DATE + ", " + Constants.TARIFF_VALUE + ") " +
				" values (" + Constants.TARIFF_ENERGY + ", '" + now + "', 2.66 );");
		db.execSQL("insert into " + Constants.TARIFF_TABLE + " ( " + Constants.TARIFF_TYPE + ", " + Constants.TARIFF_DATE + ", " + Constants.TARIFF_VALUE + ") " +
				" values (" + Constants.TARIFF_HOT_WATER + ", '" + now + "', 105.45 );");
		db.execSQL("insert into " + Constants.TARIFF_TABLE + " ( " + Constants.TARIFF_TYPE + ", " + Constants.TARIFF_DATE + ", " + Constants.TARIFF_VALUE + ") " +
				" values (" + Constants.TARIFF_COLD_WATER + ", '" + now + "', 23.31 );");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) 
	{
		// TODO: Переписать данный метод, так как удалять таблицы не очень хорошо, там могут быть юзерские данные
		db.execSQL("drop table if exists " + Constants.TARIFF_TABLE);
		db.execSQL("drop table if exists " + Constants.COUNTER_TABLE);
		onCreate(db);
	}

}
