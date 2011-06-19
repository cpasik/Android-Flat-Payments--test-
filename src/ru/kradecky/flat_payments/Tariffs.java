package ru.kradecky.flat_payments;

import ru.kradecky.flat_payments.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Tariffs extends Activity implements OnClickListener 
{
	private PaymentsData payments;
	private static String[] FIELDS = {Constants._ID, Constants.TARIFF_TYPE, Constants.TARIFF_VALUE, Constants.TARIFF_DATE, };
	private static String ORDER = Constants.TARIFF_DATE + " desc";
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tariffs);
        
        View btnAdd = findViewById(R.id.btnTariffsAdd);
        btnAdd.setOnClickListener(this);
        
        payments = new PaymentsData(this);
        try
        {
        	showTariffs(getTariffs());
        }
        finally
        {
        	payments.close();
        }       
    }
    
    private Cursor getTariffs()
    {
    	SQLiteDatabase db = payments.getWritableDatabase();
    	Cursor cursor = db.query(Constants.TARIFF_TABLE, FIELDS, null, null, null, null, ORDER);
    	startManagingCursor (cursor);
    	return cursor;
    }
    
    private void showTariffs (Cursor cursor)
    {
    	StringBuilder builder = new StringBuilder ("Current tariffs:\n");
    	while (cursor.moveToNext())
    	{
    		builder.append("ID => ").append(cursor.getLong(0));
    		
    		builder.append("\n");
    	}
    	TextView text = (TextView) findViewById(R.id.text);
    	text.setText(builder);
    }

	public void onClick(View item) 
	{
		switch (item.getId())
		{
			case R.id.btnTariffsAdd:
				startActivity(new Intent(this, NewTariff.class));
				break;
		}	
	}

}
