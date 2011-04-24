package com.dreadreaver.bukkit.thunderjoin;

import org.bukkit.Location;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;

/**
 * ThunderJoin for Bukkit
 * 
 * @author Dreadreaver
 */

public class ThunderJoinEntityListener extends EntityListener {
	
	@Override
	public void onEntityDamage(EntityDamageEvent event) {
		Location location = event.getEntity().getLocation().getBlock().getLocation();
		if(event.getCause().equals(EntityDamageEvent.DamageCause.LIGHTNING)){
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
