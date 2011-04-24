package com.dreadreaver.bukkit.thunderjoin;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

/**
 * ThunderJoin for Bukkit
 * 
 * @author Dreadreaver
 */

public class ThunderJoinPlayerListener extends PlayerListener {
	
	ThunderJoin plugin;
	
	public ThunderJoinPlayerListener(ThunderJoin instance){
		plugin = instance;
	}
	
	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if(plugin.getPermissions() == null || plugin.getPermissions().has(player, "ThunderJoin.join")) {
			Location location = player.getLocation().getBlock().getLocation();
			ThunderJoin.addToThunderLocations(location);
			System.out.println(location.toString());
			location.getWorld().strikeLightning(location);
		}
	}

}
