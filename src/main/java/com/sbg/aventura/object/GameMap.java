package com.sbg.aventura.object;

import java.util.ArrayList;
import java.util.Random;

import com.sbg.aventura.object.components.Room;
import com.sbg.aventura.object.components.Tile;
import com.sbg.aventura.object.components.Tile.TileType;
import com.sbg.aventura.util.between;

public class GameMap {
	private Tile[][] layout;
	private ArrayList<Room> rooms;
	private int boundX;
	private int boundY;
	
	public GameMap() {
		boundX = 160;
		boundY = 96;
		layout = new Tile[boundX][boundY];
		rooms = new ArrayList<>();
	}
	
	public GameMap(int x, int y) {
		boundX = x;
		boundY = y;
		layout = new Tile[boundX][boundY];
		rooms = new ArrayList<>();
	}
	
	public Tile getTile(int x, int y) {
		if(!between.isBetweenWithEnds(x, 0, boundX-1) || !between.isBetweenWithEnds(y, 0, boundY-1)) return null;
		else return layout[x][y];
	}
	
	public void setTile(Tile t, int x, int y) {
		if(t == null || !between.isBetweenWithEnds(x, 0, boundX-1) || !between.isBetweenWithEnds(y, 0, boundY-1)) return;
		else layout[x][y] = t;
	}
	
	public int[] getDims() {
		return new int[] {boundX, boundY};
	}
	
	public boolean placeRoom(int lenX, int lenY, int firstX, int firstY) {
		if( !between.isBetween(firstX,0,boundX) || !between.isBetween(firstY,0,boundY)) return false;
		else if(firstX + lenX >= boundX || firstY + lenY >= boundY) return false;
		else if(firstX - 5 <= 0 || firstY - 5 <= 0) return false;
		else {
			if(!roomPlacementCheck(firstX,firstY,lenX,lenY)) return false;
			else {
				for(int x = firstX; x < firstX + lenX; x++) {
					for(int y = firstY; y < firstY + lenY; y++) {
						if(between.isBetweenWithEnds(x, firstX, firstX + lenX) || between.isBetweenWithEnds(y, firstY, firstY + lenY)) setTile(new Tile(TileType.Open),x,y);
					}
				}
				rooms.add(new Room(firstX, firstY, lenX, lenY));
				return true;
			}
		}
	}
	
	private boolean roomPlacementCheck(int sX, int sY, int lX, int lY) {
		for(int x = sX - 5; x <= sX+lX+5; x++) {
			for(int y = sY - 5; y <=sY+lY+5; y++) {
				if(!getTile(x,y).isType(TileType.Closed)) return false;
			}
		}
		return true;
	}

	public void printMap() {
		for(int i = 0; i < boundY; i++) {
			for(int j = 0; j < boundX; j++) {
				System.out.print(getTile(j,i).print());
			}
			System.out.print('\n');
		}
	}
}
