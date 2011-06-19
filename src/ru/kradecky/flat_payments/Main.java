package ru.kradecky.flat_payments;

import ru.kradecky.flat_payments.R;
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
        View btnAbout   = findViewById(R.id.btnAbout);
        View btnAddCounter = findViewById(R.id.btnAddCounter);
        btnTariffs.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnAddCounter.setOnClickListener(this);
        
    }
    
    public void onClick(View item)
    {
    	switch (item.getId())
    	{
    		case R.id.btnTariffs:
    			startActivity (new Intent(this, Tariffs.class));
    			break;
    		case R.id.btnAbout:
    			startActivity (new Intent(this, About.class));
    			break;
    		case R.id.btnAddCounter:
    			startActivity (new Intent(this, NewCounter.class));
    			break;
    		// other buttons
    	}
    }
    
}