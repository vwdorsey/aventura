package com.sbg.aventura.factory;

import com.sbg.aventura.object.GameMap;
import com.sbg.aventura.object.components.Tile;
import com.sbg.aventura.object.components.Tile.TileType;

public class MapFactory {
	
	public static GameMap generateMap() {
		GameMap m = new GameMap();
		
		int[] dims = m.getDims();
		
		for(int j = 0; j<dims[1]; j++) {
			for(int i = 0; i<dims[0]; i++) {
				if(i == 0 || j == 0 || i == dims[0]-1 || j == dims[1]-1) m.setTile(new Tile(TileType.Immutable), i, j);
				else m.setTile(new Tile(TileType.Closed), i, j);
				
				System.out.print(m.getTile(i, j).print());
			}
			System.out.print('\n');
		}
		
		
		
		return m;
	}
	
}
