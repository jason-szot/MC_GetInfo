package com.bubbamc;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.bubbamc.Listeners.BlockPlaceListener;
import com.bubbamc.Listeners.InfoListener;
import com.bubbamc.Listeners.InventoryShuffleListener;

public class GetInfo extends JavaPlugin{
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new InfoListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryShuffleListener(), this);
		Bukkit.getServer().getLogger().info("Get Info v" + this.getDescription().getVersion() + " enabled!");
	}
	
	public void onDisable() {
		Bukkit.getServer().getLogger().info("Get Info v" + this.getDescription().getVersion() + " disabled!");
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("info")) {
			//create info wand
			ItemStack wand = CreateWand();
				p.getInventory().addItem(wand);
		}
		return false;
	}

	
	// makes a wand with a display name and description
	public ItemStack CreateWand() {
		ItemStack wand = createWand(Material.STICK, "§bInfoWand", "§a2 Get Info about a block");
		return wand;
	}
	
	public static ItemStack createWand(Material material, String name, String... lore) {
		final ItemStack item = new ItemStack(material, 1);
		final ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		item.setItemMeta(meta);
		return item;
	}
	
	public static boolean checkInventory(PlayerInventory inventory, int count) {
		int i = 0;
		for ( ItemStack item : inventory) {
			if (item == null) i++;
			if (i == count) return false;
		}
		return true;
	}
	
}
