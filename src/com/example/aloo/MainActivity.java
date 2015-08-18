package com.example.aloo;




import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity{
	ViewPager viewpager=null;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view);
		viewpager= (ViewPager)findViewById(R.id.pager);
		FragmentManager fragmentManager=getSupportFragmentManager();
		viewpager.setAdapter(new MyAdapter(fragmentManager));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater show = getMenuInflater();
		show.inflate(R.menu.menu, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		case R.id.profile:
			Intent i=new Intent(this,Profile.class);
			startActivity(i);
			return super.onOptionsItemSelected(item);
		case R.id.settings:
			Intent j=new Intent(this,Settings.class);
			startActivity(j);
			return super.onOptionsItemSelected(item);
			
			
		}
		return false;
		
			
		
			
		
		
		
		
		
		
		
		
		
		
		
		}
	
}

class MyAdapter extends FragmentPagerAdapter{

	public MyAdapter(FragmentManager fragmentManager) {
		// TODO Auto-generated constructor stub
		super(fragmentManager);
	}

	@Override
	public Fragment getItem(int i) {
		// TODO Auto-generated method stub
		Fragment fragment = null;
		if(i==0)
		{
			fragment = new listview2();
		}
		if(i==1)
		{
			fragment = new listview1();
		}
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	@Override
	public CharSequence getPageTitle(int position){
		String title=new String();
		if(position==0)
		{
			return "Joined";
		}
		if(position==1)
		{
			return "Search";
		}
		return null;
	}


}