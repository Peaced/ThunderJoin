package com.dreadreaver.bukkit.thunderjoin;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

/**
 * ThunderJoin for Bukkit
 * 
 * @author Dreadreaver
 */

public class ThunderJoin extends JavaPlugin {
	
	private PermissionHandler Permissions;
	private final ThunderJoinBlockListener blockListener = new ThunderJoinBlockListener();
	private final ThunderJoinEntityListener entityListener = new ThunderJoinEntityListener();
	private final ThunderJoinPlayerListener playerListener = new ThunderJoinPlayerListener(this);
	private static HashMap<Location, Boolean> thunderLocations = new HashMap<Location, Boolean>();

	@Override
	public void onDisable() {
		System.out.println(getDescription().getName() + " disabled");
	}

	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_IGNITE, blockListener, Event.Priority.Highest, this);
		pm.registerEvent(Event.Type.ENTITY_DAMAGE, entityListener, Event.Priority.Highest, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Highest, this);
		setupPermissions(pm);
		System.out.println(getDescription().getName() + " v" + getDescription().getVersion() + " enabled");
	}
	
	public static boolean isThunderLocation(Location location){
		if(thunderLocations.containsKey(location)) {
			return true;
		} else {
			return false;
		}
	}

	public static void addToThunderLocations(Location location) {
		thunderLocations.put(location, false);
	}
	
	public static void deleteThunderLocation(Location location) {
		if(thunderLocations.containsKey(location)){
			thunderLocations.remove(location);
		}
	}
	
	private void setupPermissions(PluginManager pm) {
		Plugin permissions = pm.getPlugin("Permissions");
		if (this.Permissions == null) {
			if (permissions != null) {
				this.Permissions = ((Permissions) permissions).getHandler();
			}
		}
	}
	
	public PermissionHandler getPermissions() {
		return Permissions;
	}
	
}
