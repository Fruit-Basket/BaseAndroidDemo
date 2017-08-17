package com.example.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import android.util.Log;

public class TestTreeSet {
	public void test(){
		Set<String> set=new HashSet<String>();
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		
		TreeSet<String> treeSet=new TreeSet<String>(set);
		
		Log.d("Sorted tree set",treeSet.toString());
	}
}
