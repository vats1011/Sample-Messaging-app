package com.example.aloo;



import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class dummy extends Activity implements OnItemClickListener {
ListView list;
Context context=dummy.this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list=(ListView)findViewById(R.id.listViewGroups);
		list.setAdapter(new CustomBaseAdapter(this));
		list.setOnItemClickListener(this);
		
	}
	

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Resources res=context.getResources();
		 String[] titles=res.getStringArray(R.array.titles);
		 String[] des=res.getStringArray(R.array.BigDes);
		 String[] mem=res.getStringArray(R.array.mem);
		 int[] images={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		
		
		Dialog d=new Dialog(this);
		d.setContentView(R.layout.group_dialog);
		((TextView)d.findViewById(R.id.tvGroupName)).setText(titles[arg2]);
		((TextView)d.findViewById(R.id.tvBigDes)).setText(des[arg2]);
		((TextView)d.findViewById(R.id.tvMem)).setText(mem[arg2]);
		((TextView)d.findViewById(R.id.tv)).setText("Nothing Set yet");
		ImageView img=((ImageView)d.findViewById(R.id.ivGroupIcon));
		img.setImageResource(images[arg2]);
		d.show();
		
		
		
	}

	
}
