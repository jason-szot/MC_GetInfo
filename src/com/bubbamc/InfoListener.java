package com.bubbamc;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InfoListener implements Listener{

	
	public InfoListener() {
	}

	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerUse(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		
		if (p.getItemInHand().getType() == Material.STICK && event.getClickedBlock() != null) {
			Block target = event.getClickedBlock();
			messageInfo(p, target);
		}else return;
	}
	
	private void messageInfo(Player p, Block block) {

		String local = "Location: ";
		String hash = "Hashcode: ";

		local = local + "X: " + block.getX() + ", Y: " + block.getY() + ", Z: " + block.getZ();
		hash = hash + block.hashCode();

		p.sendMessage(local);
		p.sendMessage(hash);
	}
}
