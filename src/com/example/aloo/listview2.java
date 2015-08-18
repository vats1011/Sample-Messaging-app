package com.example.aloo;



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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class listview2 extends Fragment implements OnItemClickListener {
ListView list;




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
		
		Intent intent = new Intent(this.getActivity(),MessagingScreen.class);
		startActivity(intent);
		
		/* String titles=GroupStrings.titles[arg2];
		 String des=GroupStrings.BigDes[arg2];
		 String mem=GroupStrings.mem[arg2];
		 int[] images={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		 
		
		 Activity a=getActivity();
		 
		 
		Dialog d=new Dialog(a);
		d.setContentView(R.layout.group_dialog);
		((TextView)d.findViewById(R.id.tvGroupName)).setText(titles);
		((TextView)d.findViewById(R.id.tvBigDes)).setText(des);
		((TextView)d.findViewById(R.id.tvMem)).setText(mem);
		((TextView)d.findViewById(R.id.tv)).setText("Nothing Set yet");
		ImageView img=((ImageView)d.findViewById(R.id.ivGroupIcon));
		img.setImageResource(images[arg2]);
		d.show();
		*/
		
		
	}

	
}
