package com.sbg.aventura.factory;

import com.sbg.aventura.object.GameMap;

public class PathFactory {
	
	public static void makePath(GameMap map, int startX, int startY, int endX, int endY) {
		//Need to code this using A*
	}
	
	private class aStarTile {
		public int posX;
		public int posY;
		public int F;
		public int G;
		public int H;
		public aStarTile(){}
	}
}
