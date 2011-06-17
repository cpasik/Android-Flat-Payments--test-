package ru.kradecky;

import android.provider.BaseColumns;

public interface Constants extends BaseColumns 
{
	public static final String TARIFF_TABLE = "tariffs";
	public static final String COUNTER_TABLE = "countrers";
	
	public static final int TARIFF_HOT_WATER  = 1;
	public static final int TARIFF_COLD_WATER = 2;
	public static final int TARIFF_ENERGY     = 3;
	
	public static final String TARIFF_TYPE  = "type";
	public static final String TARIFF_VALUE = "value";
	public static final String TARIFF_DATE  = "date";
	
	public static final String COUNTER_TYPE  = "type";
	public static final String COUNTER_VALUE = "value";
	public static final String COUNTER_DATE  = "date";
	
}
