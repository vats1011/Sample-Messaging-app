package com.example.aloo;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends Activity  {
TextView phone,email,name,user;
static String x=new String();
static String y=new String();
static String z=new String();
public static String u;


@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		phone=(TextView)findViewById(R.id.tvphone1);
		email=(TextView)findViewById(R.id.tvemailid1);
		name=(TextView)findViewById(R.id.tvname1);
		user=(TextView)findViewById(R.id.tvuser1);
		
		name.setText(x);
		email.setText(y);
		phone.setText(z);
		user.setText(u);
		
	}
public Settings() {
	// TODO Auto-generated constructor stub
	
}

	
	

}
	


