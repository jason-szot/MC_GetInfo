package com.bubbamc.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryShuffleListener implements Listener{

	public InventoryShuffleListener() {
		
	}
	
	
	@EventHandler
	public void onInventoryMove(InventoryMoveItemEvent e) {
		
		ItemStack item = e.getItem();
		
		Inventory moveFrom = e.getSource();
		Inventory moveTo = e.getDestination();
		Inventory init = e.getInitiator();
		World world = init.getLocation().getWorld();
		Block moveFromBlock = world.getBlockAt(moveFrom.getLocation());
		Block moveToBlock = world.getBlockAt(moveTo.getLocation());
		Block initBlock = world.getBlockAt(init.getLocation());
		
		
		logBlock(blockType(moveFromBlock), item, moveFromBlock, "From ");
		logBlock(blockType(moveToBlock), item , moveToBlock, "To ");
		logBlock(blockType(initBlock), item , initBlock, "Initiated by ");
		
	}
	
	public void logBlock(String block, ItemStack item, Block b, String info) {
		
		String log = item.getType().toString() + " moved " + info;
		log = log + b.getType().toString() + ": X: " + b.getX() + " Y: " + b.getY() + " Z: " + b.getZ();
		
		Bukkit.getServer().getLogger().info(log);
	}
	
	public String blockType(Block block){
		String type = block.getType().toString();
		return type;
	}
}
