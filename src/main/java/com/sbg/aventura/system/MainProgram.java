package com.sbg.aventura.system;

import com.sbg.aventura.factory.MapFactory;
import com.sbg.aventura.object.GameMap;

public class MainProgram {
	public static void main(String[] args) {
		GameMap m = MapFactory.generateMap();
		m.printMap();
	}
}
