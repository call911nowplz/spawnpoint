package me.obi.spawnpoint.Events;



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
        int pitch, yaw;
		double x, y, z;
		pitch = plugin.getConfig().getInt("Pitch");
		yaw = plugin.getConfig().getInt("Yaw");
		x = plugin.getConfig().getDouble("X");
		y = plugin.getConfig().getDouble("Y");
		z = plugin.getConfig().getDouble("Z");

		Location spawn = new Location(player.getWorld(), x, y, z, yaw, pitch);
		player.teleport(spawn);
	}

	public void onQuit(PlayerQuitEvent event2) {
		event2.setQuitMessage("");

	}
}
