package com.example.gridview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {
	int[] imageIDs={
			R.drawable.p1,
			R.drawable.p2,
			R.drawable.p3,
			R.drawable.p4,
			R.drawable.p5
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView gridView=(GridView)findViewById(R.id.gridView);
		gridView.setAdapter(new ImageAdapter(this,imageIDs));
		
		
	}
	
	private class ImageAdapter extends BaseAdapter{
		Context context;
		int [] imageIDs;
		public ImageAdapter(Context context,int[] imageIDs){
			super();
			this.context=context;
			this.imageIDs=imageIDs;
		}
			
		@Override
		public int getCount() {
			return this.imageIDs.length;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if(convertView==null){
				imageView=new ImageView(this.context);
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setLayoutParams(new GridView.LayoutParams(40,40));	
				//imageView.setPadding(5, 5, 5, 5);
			}
			else{
				imageView=(ImageView)convertView;
			}
			imageView.setImageResource(imageIDs[position]);
			return imageView;
		}
	}
}
