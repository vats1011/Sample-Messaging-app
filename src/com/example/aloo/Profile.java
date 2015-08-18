package com.example.aloo;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends Activity {

	TextView name;
	Button interests,checklist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		
		interests= (Button)findViewById(R.id.binterests);
		checklist= (Button)findViewById(R.id.bchecklist);
		
	}

	
	}


