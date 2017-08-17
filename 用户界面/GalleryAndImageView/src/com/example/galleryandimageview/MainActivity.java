package com.example.galleryandimageview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends Activity {
	int[] imageIDs={
			R.drawable.p1,
			R.drawable.p2,
			R.drawable.p3,
			R.drawable.p4,
			R.drawable.p5
	};
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Gallery gallery=(Gallery)findViewById(R.id.gallery);
		final ImageView imageView=(ImageView)findViewById(R.id.imageView);
		
		gallery.setAdapter(new ImageAdapter(this,imageIDs));
		gallery.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				imageView.setImageResource(imageIDs[position]);
			}
			
		});
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

		@SuppressWarnings("deprecation")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if(convertView==null){
				imageView=new ImageView(this.context);
				imageView.setImageResource(imageIDs[position]);
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				imageView.setLayoutParams(new Gallery.LayoutParams(150,120));
			}
			else{
				imageView=(ImageView)convertView;
			}
			return imageView;
		}
		
	}
}
