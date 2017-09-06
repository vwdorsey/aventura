package com.sbg.aventura.object;

import com.sbg.aventura.object.components.Tile;

public class GameMap {
	private Tile[][] layout;
	private int x_bound;
	private int y_bound;
	
	public GameMap() {
		x_bound = 160;
		y_bound = 96;
		layout = new Tile[x_bound][y_bound];
	}
	
	public GameMap(int x, int y) {
		x_bound = x;
		y_bound = y;
		layout = new Tile[x_bound][y_bound];
	}
	
	public Tile getTile(int x, int y) {
		if(x >= x_bound || y >= y_bound || x < 0 || y < 0) return null;
		else return layout[x][y];
	}
	
	public void setTile(Tile t, int x, int y) {
		if(t == null || x >= x_bound || y >= y_bound || x < 0 || y < 0) return;
		else layout[x][y] = t;
	}
	
	public int[] getDims() {
		return new int[] {x_bound, y_bound};
	}
}
