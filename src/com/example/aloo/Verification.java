package com.example.aloo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Verification extends Activity implements OnClickListener{
	
	EditText vcode;
	Button verify;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.verification);
		vcode= (EditText) findViewById(R.id.etverifycode);
		verify = (Button) findViewById(R.id.bverify);
		verify.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
if(v.getId()==R.id.bverify){
		Intent intent = new Intent(Verification.this,MainActivity.class);
		startActivity(intent);
}
	}

}
