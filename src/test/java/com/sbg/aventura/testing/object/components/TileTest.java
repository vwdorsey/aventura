package com.sbg.aventura.testing.object.components;

import org.junit.Test;

import com.sbg.aventura.object.components.Tile;
import com.sbg.aventura.object.components.Tile.TileType;

public class TileTest {
	@Test
	public void testEdgeTile() {
		Tile t = new Tile(TileType.Open);
	}
	
	@Test
	public void testEmptyTile() {
		Tile t = new Tile(TileType.Open);
	}
	
	@Test
	public void testWallTile() {
		Tile t = new Tile(TileType.Open);
	}
	
	@Test
	public void testFloorTile() {
		Tile t = new Tile(TileType.Open);
	}
}
