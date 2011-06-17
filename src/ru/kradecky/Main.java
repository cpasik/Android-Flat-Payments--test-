package ru.kradecky;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Main extends Activity implements OnClickListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        View btnTariffs = findViewById(R.id.btnTariffs);
        btnTariffs.setOnClickListener(this);
    }
    
    public void onClick(View item)
    {
    	switch (item.getId())
    	{
    		case R.id.btnTariffs:
    			startActivity (new Intent(this, Tariffs.class));
    			break;
    		// other buttons
    	}
    }
    
}