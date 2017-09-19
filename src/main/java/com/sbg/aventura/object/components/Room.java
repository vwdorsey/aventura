package com.sbg.aventura.object.components;

public class Room {
	private int x;
	private int y;
	private int lenX;
	private int lenY;
	
	public Room(int x, int y, int lenX, int lenY) {
		this.x = x;
		this.y = y;
		this.lenX = lenX;
		this.lenY = lenY;
	}
	
	public int[] getInfo() {
		return new int[] {x, y, lenX, lenY};
	}
}
