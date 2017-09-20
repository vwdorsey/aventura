package com.sbg.aventura.object.components;

import java.util.Random;

public class Tile {
	
	public enum TileType {
		Immutable,
		Open,
		Closed
	}
	
	private TileType type;
	private int hardness;
	private char displayAs;
	
	public Tile() {
		type = TileType.Closed;
		assembleTile();
	}
	
	public Tile(TileType t) {
		type = t;
		assembleTile();
	}
	
	private void assembleTile() {
		switch(type) {
			case Immutable:
				hardness = 100;
				displayAs = '@';
				break;
			case Closed:
				hardness = new Random().nextInt(99) + 1;
				displayAs = '#';
				break;
			default:
				hardness = 0;
				displayAs = '.';
				break;
		}
	}
	
	public boolean isType(TileType t) {
		if(this.type == t) return true;
		else return false;
	}
	
	public char print() {
		return displayAs;
	}
}
