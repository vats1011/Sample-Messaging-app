package com.example.aloo;



import org.w3c.dom.Text;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class listview1 extends Fragment implements OnItemClickListener {
ListView list;
Button Create;
TextView Joined,User;



@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances)
	{
		View rootView = inflater.inflate(R.layout.activity_main, container, false);
		
		
		
		list=(ListView)rootView.findViewById(R.id.listViewGroups);
		list.setAdapter(new CustomBaseAdapter(this.getActivity()));
		list.setOnItemClickListener(this);
		return rootView;
	}

	
	

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		 String titles=GroupStrings.titles[arg2];
		 String des=GroupStrings.BigDes[arg2];
		 String mem=GroupStrings.mem[arg2];
		 int[] images={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		 
		
		 Activity a=getActivity();
		Dialog d=new Dialog(a);
		
		d.setContentView(R.layout.group_dialog);

		
		
		Joined=(TextView)d.findViewById(R.id.tvGroupName);
		Joined.setText(titles);
		((TextView)d.findViewById(R.id.tvBigDes)).setText(des);
		((TextView)d.findViewById(R.id.tvMem)).setText(mem);
		((TextView)d.findViewById(R.id.tv)).setText("Nothing Set yet");
		ImageView img=((ImageView)d.findViewById(R.id.ivGroupIcon));
		Create=(Button)d.findViewById(R.id.bJoin);
		Create.setOnClickListener(new OnClickListener() {
		
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				boolean didItWork = true;
				try {
				
				String joined=Joined.getText().toString();
				
				
				Activity b =getActivity();
	            joineddetails entry = new joineddetails(b);
	            entry.Open();
	            entry.createEntry(Settings.u,joined);
	            entry.Close();
				
				}catch (Exception e){
					didItWork = false;
					Activity c =getActivity();
		            
					String error = e.toString();
					Dialog d = new Dialog(c);
					d.setTitle("Failed :(");
					TextView tv = new TextView(c);
					tv.setText(error);
				    d.setContentView(tv);
				    d.show();
					
				}finally{
					if(didItWork){
						Activity e =getActivity();
			            
						Dialog d = new Dialog(e);
						
						d.setTitle("Done :)");
						TextView tv = new TextView(e);
						tv.setText("Successfully inserted in the Database!");
					    d.setContentView(tv);
					    d.show();
					  
					}
				}
			}

				
				
			
		});
		img.setImageResource(images[arg2]);
		d.show();
		
		
		
		
		
		
		
	

	}	
}
