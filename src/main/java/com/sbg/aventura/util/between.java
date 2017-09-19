package com.sbg.aventura.util;

public class between {
	public static <T extends Comparable<T>> boolean isBetween(T val, T low, T high) {
		if(low.compareTo(val) < 0 || high.compareTo(val) > 0) return true;
		else return false;
	}
	
	public static <T extends Comparable<T>> boolean isBetweenWithEnds(T val, T low, T high) {
		if(low.compareTo(val) <= 0 || high.compareTo(val) >= 0) return true;
		else return false;
	}
	
}
