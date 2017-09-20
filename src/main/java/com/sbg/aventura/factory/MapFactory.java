package com.sbg.aventura.factory;

import java.util.Random;

import com.sbg.aventura.object.GameMap;
import com.sbg.aventura.object.components.Tile;
import com.sbg.aventura.object.components.Tile.TileType;

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
			boolean result = m.placeRoom(10+ng.nextInt(11), 5+ng.nextInt(16), ng.nextInt(dims[0]), ng.nextInt(dims[1]));
			if(result) placedRooms++;
		}
		
		return m;
	}
	
}
