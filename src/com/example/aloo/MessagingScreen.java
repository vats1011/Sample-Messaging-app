package com.example.aloo;

import android.app.Activity;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MessagingScreen extends Activity implements OnClickListener {

	EditText message;
	Button send;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.messaging_screen);

		message = (EditText) findViewById(R.id.etmessage);
		send = (Button) findViewById(R.id.bsend);
		send.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		try {
			String text = message.getText().toString();

			Settings s = new Settings();
			GroupChat gc = new GroupChat(MessagingScreen.this);

			gc.open();

			gc.createEntry("ABC", Settings.u, text);

			String t = gc.getLastData();

			Dialog d = new Dialog(this);
			d.setTitle("Success");
			TextView tv = new TextView(this);
			tv.setText(t);
			d.setContentView(tv);
			d.show();

			gc.close();
		} catch (Exception e) {
			String error = e.toString();
			Dialog d = new Dialog(this);
			d.setTitle("Dang it");
			TextView tv = new TextView(this);
			tv.setText(error);
			d.setContentView(tv);
			d.show();
		}
	}

}
