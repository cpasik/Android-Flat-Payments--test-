package ru.kradecky;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class NewTariff extends Activity implements OnClickListener
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_tariff);
        
        View btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);
    }

	public void onClick(View item) 
	{
		switch (item.getId())
		{
			case R.id.btnOK:
				processOKButton();
				break;
		}
	}
	
	private void processOKButton()
	{
		this.finish();
	}
	
	private void processCancelButton()
	{
		this.finish();
	}

}
