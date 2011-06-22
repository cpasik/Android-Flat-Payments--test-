package ru.kradecky.flat_payments;

import java.util.Calendar;

import ru.kradecky.flat_payments.R;
import android.app.Activity;
import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NewCounter extends Activity implements OnItemSelectedListener, OnClickListener
{
	private int counter_type;
	private PaymentsData payments;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_counter);
		
		payments = new PaymentsData(this);
		
		LayoutParams params = getWindow().getAttributes();
		params.height = LayoutParams.FILL_PARENT;
		params.width  = LayoutParams.FILL_PARENT;
		getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
		
		Spinner spinner = (Spinner) findViewById(R.id.counter_type);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.counter_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		
		View btnOK = findViewById(R.id.btnOK);
		btnOK.setOnClickListener(this);
	}

	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) 
	{
		counter_type = (int) (id + 1);
	}

	public void onNothingSelected(AdapterView parent) 
	{
		// nothing to do
		
	}

	public void onClick(View item) 
	{
		switch (item.getId())
		{
			case R.id.btnOK:
				saveData();
				break;
		}
	}
	
	private void saveData()
	{
		EditText value = (EditText) findViewById(R.id.counter_value);
		;
		SQLiteDatabase db = payments.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(Constants.COUNTER_TYPE , counter_type);
		values.put(Constants.COUNTER_VALUE, value.getText().toString());
		values.put(Constants.COUNTER_DATE, Calendar.getInstance().getTime().toString());
		try
		{
			db.insertOrThrow(Constants.COUNTER_TABLE, null, values);
			Toast.makeText(this, "New value added\nNumber of values is " + getCounterValueCount(), Toast.LENGTH_LONG).show();
		}
		catch (SQLException e)
		{
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		payments.close();
		finish();
	}
	
	private long getCounterValueCount()
	{
		SQLiteDatabase db = payments.getReadableDatabase();
		SQLiteStatement s = db.compileStatement("select count(*) from " + Constants.COUNTER_TABLE);
		return s.simpleQueryForLong();
	}
}
