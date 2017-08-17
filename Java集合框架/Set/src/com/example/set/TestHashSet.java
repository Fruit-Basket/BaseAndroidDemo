package com.example.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import android.util.Log;

public class TestHashSet {
	public void test(){
		Set<String> set=new HashSet<String>();
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		
		Log.d("set",set.toString());
		
		Iterator<String> iterator=set.iterator();
		
		while(iterator.hasNext()==true){
			Log.d("element",iterator.next());
		}
	}
}
