package com.sbg.aventura.factory;

import java.util.Random;

import com.sbg.aventura.object.GameMap;
import com.sbg.aventura.object.components.Room;
import com.sbg.aventura.object.components.Tile;
import com.sbg.aventura.object.components.Tile.TileType;
import com.sbg.aventura.util.between;

public class MapFactory {
	
	public static GameMap generateMap() {
		GameMap m = new GameMap();
		Random ng = new Random(); 
		
		int[] dims = m.getDims();
		
		for(int j = 0; j<dims[1]; j++) {
			for(int i = 0; i<dims[0]; i++) {
				if(i == 0 || j == 0 || i == dims[0]-1 || j == dims[1]-1) m.setTile(new Tile(TileType.Immutable), i, j);
				else m.setTile(new Tile(TileType.Closed), i, j);
			}
		}
		
		int numRooms = 12 + ng.nextInt(9);
		int placedRooms = 0;
		
		while(placedRooms != numRooms) {
			int lenX = 10+ng.nextInt(11);
			int lenY = 5+ng.nextInt(16);
			int firstX = ng.nextInt(dims[0]);
			int firstY = ng.nextInt(dims[1]);
			if( !between.isBetween(firstX,0,dims[0]) || !between.isBetween(firstY,0,dims[1])) continue;
			else if(firstX + lenX >= dims[0] || firstY + lenY >= dims[1]) continue;
			else if(firstX - 5 <= 0 || firstY - 5 <= 0) continue;
			else {
				if(!roomPlacementCheck(firstX,firstY,lenX,lenY,m)) continue;
				else {
					for(int x = firstX; x < firstX + lenX; x++) {
						for(int y = firstY; y < firstY + lenY; y++) {
							if(between.isBetweenWithEnds(x, firstX, firstX + lenX) || between.isBetweenWithEnds(y, firstY, firstY + lenY)) m.setTile(new Tile(TileType.Open),x,y);
						}
					}
					m.addRoomInfo(new Room(firstX, firstY, lenX, lenY));
					placedRooms++;
				}
			}
		}
		
		// Path Generation will go to the PathFactory to be used for both path generation and monster routing later.
		// Will implement dijkstras.
		
		return m;
	}
	
	private static boolean roomPlacementCheck(int sX, int sY, int lX, int lY, GameMap m) {
		for(int x = sX - 5; x <= sX+lX+5; x++) {
			for(int y = sY - 5; y <=sY+lY+5; y++) {
				if(!m.getTile(x,y).isType(TileType.Closed)) return false;
			}
		}
		return true;
	}
}
