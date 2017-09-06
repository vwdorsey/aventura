package com.sbg.aventura.system;

import java.util.HashMap;

public class Config {
	
	//Singleton game configuration instance. The game should only ever have one configuration when it's running, so no need for extras.
	private static Config gameConfig;
	
	private HashMap<String,Integer> configStore;
	
	private Config() {
		configStore = new HashMap<>();
		
		//Placeholder for file loading routine. For now, all values are statically set elsewhere.
	}
	
	public static Config getConfig() {
		if(gameConfig == null) gameConfig = new Config();
		return gameConfig;
	}
	
	public int getConfigItem(String key) {
		return configStore.get(key);
	}
	
}
