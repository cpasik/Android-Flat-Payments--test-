package ru.kradecky.flat_payments;

import ru.kradecky.flat_payments.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class About extends Activity implements OnClickListener
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
		View btnOK = findViewById(R.id.btnOK);
		btnOK.setOnClickListener(this);
	}

	public void onClick(View v) 
	{
		switch (v.getId())
		{
			case R.id.btnOK:
				this.finish();
				break;
		}
		
	}

}
