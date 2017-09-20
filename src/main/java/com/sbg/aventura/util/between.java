package com.sbg.aventura.util;

public class between {
	public static <T extends Comparable<T>> boolean isBetween(T val, T low, T high) {
		int l = val.compareTo(low);
		int h = high.compareTo(val);
		if(val.compareTo(low) > 0 && val.compareTo(high) < 0) return true;
		else return false;
	}
	
	public static <T extends Comparable<T>> boolean isBetweenWithEnds(T val, T low, T high) {
		int l = low.compareTo(val);
		int h = high.compareTo(val);
		if(val.compareTo(low) >= 0 && val.compareTo(high) <= 0) return true;
		else return false;
	}
	
}
