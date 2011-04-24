package com.dreadreaver.bukkit.thunderjoin;

import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;

/**
 * ThunderJoin for Bukkit
 * 
 * @author Dreadreaver
 */

public class ThunderJoinBlockListener extends BlockListener {

	public void onBlockIgnite(BlockIgniteEvent event) {
		if (event.getCause() == IgniteCause.LIGHTNING) {
			event.setCancelled(true);
		}
	}

}
