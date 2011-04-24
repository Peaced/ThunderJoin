package com.dreadreaver.bukkit.thunderjoin;

import org.bukkit.Location;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;

/**
 * ThunderJoin for Bukkit
 * 
 * @author Dreadreaver
 */

public class ThunderJoinBlockListener extends BlockListener {

	@Override
	public void onBlockIgnite(BlockIgniteEvent event) {
		Location location = event.getBlock().getLocation();
		if(event.getCause().equals(BlockIgniteEvent.IgniteCause.LIGHTNING)) {
			if(ThunderJoin.isThunderLocation(location)){
				event.setCancelled(true);
			}
		} else {
			if(ThunderJoin.isThunderLocation(location)){
				ThunderJoin.deleteThunderLocation(location);
			}
		}
	}

}
