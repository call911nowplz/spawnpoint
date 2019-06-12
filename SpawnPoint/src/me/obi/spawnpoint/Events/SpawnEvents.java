package me.obi.spawnpoint.Events;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import me.obi.spawnpoint.SpawnPoint;
import net.md_5.bungee.api.ChatColor;

public class SpawnEvents implements Listener {
	private Plugin plugin = SpawnPoint.getPlugin(SpawnPoint.class);

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		event.setJoinMessage(ChatColor.GREEN + "[" + ChatColor.WHITE + "+" + ChatColor.GREEN + "]" + ChatColor.WHITE
				+ player.getName());

		double x, y, z;
		String world = plugin.getConfig().getString("World");
		x = plugin.getConfig().getDouble("X");
		y = plugin.getConfig().getDouble("Y");
		z = plugin.getConfig().getDouble("Z");

		Location spawn = new Location(Bukkit.getWorld(world), x, y, z);
		player.teleport(spawn);
	}

	public void onQuit(PlayerQuitEvent event2) {
		event2.setQuitMessage("");

	}
}
