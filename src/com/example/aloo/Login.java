package com.example.aloo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {

	EditText lname, lemail, lphone, luser;
	Button blogin, bcreate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.login);
		blogin = (Button) findViewById(R.id.blogin);
		lname = (EditText) findViewById(R.id.etloginname);
		lemail = (EditText) findViewById(R.id.etloginemail);
		bcreate = (Button) findViewById(R.id.bCreate);
		lphone = (EditText) findViewById(R.id.etloginphone);
		luser = (EditText) findViewById(R.id.etuser);

		blogin.setOnClickListener(this);

		bcreate.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.blogin:

			String enteredName = lname.getText().toString();
			String enteredEmail = lemail.getText().toString();
			String enteredPhone = lphone.getText().toString();
			String enteredUser = luser.getText().toString();
			LoginDetails obj = new LoginDetails(this);
			obj.Open();
			try {
				if (obj.CheckDetails(enteredName, enteredEmail, enteredPhone,
						enteredUser) == 1) {

					Settings.x = enteredName;
					Settings.y = enteredEmail;
					Settings.z = enteredPhone;

					Dialog d = new Dialog(this);
					d.setTitle("Success :)");
					TextView tv = new TextView(this);
					tv.setText("You Have signed in");
					d.setContentView(tv);
					d.show();

					Intent intent = new Intent(Login.this, MainActivity.class);
					startActivity(intent);
				}

				// if (obj.CheckDetails(enteredUser, enteredName,
				// enteredEmail,enteredPhone) == 2)
				else {
					Dialog d = new Dialog(this);
					d.setTitle("Failed :(");
					TextView tv = new TextView(this);
					tv.setText("Invalid Credentials");
					d.setContentView(tv);
					d.show();

				}
			} catch (Exception e) {

				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Failed :(");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			}
			obj.Close();
			break;

		case R.id.bCreate:

			Intent i = new Intent(Login.this, AllProfiledb.class);
			startActivity(i);
			break;

		}

	}

}
