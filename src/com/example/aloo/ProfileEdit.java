package com.example.aloo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;


public class ProfileEdit extends Activity {

	EditText name, interests,checklist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profileedit);
		
		name= (EditText)findViewById(R.id.etpname);
		interests = (EditText)findViewById(R.id.etinterests);
		checklist =(EditText)findViewById(R.id.etchecklist);
		
	}

	
}
