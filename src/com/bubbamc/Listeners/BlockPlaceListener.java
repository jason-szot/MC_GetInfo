package com.bubbamc.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.WallSign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener{
	
	public BlockPlaceListener() {
		
	}
	
	@EventHandler
	public void onPlayerBlockPlace(BlockPlaceEvent e) {
		
		Player p = e.getPlayer();
		Block placed = e.getBlockPlaced();
		Bukkit.getServer().getLogger().info("BlockPlaceEvent Triggered by " + placed.getType().toString());
		
		
		if (placed.getType().equals(Material.OAK_WALL_SIGN)) {
			
			Bukkit.getServer().getLogger().info("A Sign was placed");
			WallSign signData = (WallSign) placed.getState().getBlockData();
			BlockFace attached = signData.getFacing().getOppositeFace();
			
			Block posted = placed.getRelative(attached);
			
			p.sendMessage(posted.toString());
			
		}
		
	}
	
	

}
