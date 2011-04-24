package com.dreadreaver.bukkit.thunderjoin;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * ThunderJoin for Bukkit
 * 
 * @author Dreadreaver
 */

public class ThunderJoin extends JavaPlugin {

	private final ThunderJoinPlayerListener playerListener = new ThunderJoinPlayerListener();
	private final ThunderJoinBlockListener blockListener = new ThunderJoinBlockListener();

	@Override
	public void onDisable() {
		System.out.println(getDescription().getName() + " disabled");
	}

	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Highest, this);
		pm.registerEvent(Event.Type.BLOCK_IGNITE, blockListener, Event.Priority.Highest, this);
		System.out.println(getDescription().getName() + " v" + getDescription().getVersion() + " enabled");
	}

}
