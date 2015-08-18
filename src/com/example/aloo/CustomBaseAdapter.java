package com.example.aloo;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
class RowItem
{
	String title;
	int image;
	String des;
	String mem;
	RowItem(String title,String des,String mem,int image){
		this.title=title;
		this.des=des;
		this.image=image;
		this.mem=mem;
		
	}
}
 class CustomBaseAdapter extends BaseAdapter 
{
	 ArrayList<RowItem> list;
	 Context context;
	 
	 CustomBaseAdapter(Context c)
	 {	context=c;
		 list=new ArrayList<RowItem>();
		 Resources res=c.getResources();
		 String[] titles=GroupStrings.titles;
		 String[] des=GroupStrings.description;
		 String[] mem=GroupStrings.mem;
		 int[] images={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		 for(int i = 0;i<titles.length;i++)
		 {
			 list.add(new RowItem(titles[i],des[i],mem[i],images[i]));
		 }
	 }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return list.indexOf(list.get(arg0));
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View row=inflater.inflate(R.layout.groups_listview, arg2,false);
		TextView title=(TextView) row.findViewById(R.id.textView1);
		TextView des=(TextView) row.findViewById(R.id.textView2);
		TextView mem=(TextView) row.findViewById(R.id.textView3);
		ImageView images=(ImageView)row.findViewById(R.id.imageView1);
		RowItem temp=list.get(arg0); 
		title.setText(temp.title);
		des.setText(temp.des);
		mem.setText(temp.mem);
	    images.setImageResource(temp.image);
	    return row;
		
		
	}
}

    

	