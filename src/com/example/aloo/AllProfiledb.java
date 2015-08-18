package com.example.aloo;






import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AllProfiledb extends Activity implements OnClickListener {
EditText Name,Email,Phone,User;
Button Create;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createacc);
		User=(EditText)findViewById(R.id.editText4);
		Name=(EditText)findViewById(R.id.editText1);
		Email=(EditText)findViewById(R.id.editText2);
		Phone=(EditText)findViewById(R.id.editText3);
		Create=(Button)findViewById(R.id.button1  );
		Create.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:

			boolean didItWork = true;
			try {
			String email = Email.getText().toString();
			String name = Name.getText().toString() ;
			String phone=Phone.getText().toString();
			String user=User.getText().toString();
			
			Settings.u=user;
			Settings.x=name;
			Settings.y=email;
			Settings.z=phone;
            LoginDetails entry = new LoginDetails(this);
            entry.Open();
            entry.createEntry(name,email,phone,user);
            entry.Close();
			break;
			}catch (Exception e){
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Failed :(");
				TextView tv = new TextView(this);
				tv.setText(error);
			    d.setContentView(tv);
			    d.show();
			}finally{
				if(didItWork){
					Dialog d = new Dialog(this);
					d.setTitle("Done :)");
					TextView tv = new TextView(this);
					tv.setText("Successfully inserted in the Database!");
				    d.setContentView(tv);
				    d.show();
				    Intent i=new Intent(AllProfiledb.this,Verification.class);
				    startActivity(i);
				}
			}
		}
	}}

