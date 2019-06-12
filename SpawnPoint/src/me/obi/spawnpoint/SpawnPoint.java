package me.obi.spawnpoint;

import org.bukkit.plugin.java.JavaPlugin;

import me.obi.spawnpoint.Events.SpawnEvents;
import net.md_5.bungee.api.ChatColor;

public class SpawnPoint extends JavaPlugin {
	private Commands commands = new Commands();

	public void onEnable() {
		getCommand(commands.cmd1).setExecutor(commands);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "SpawnPoint made by Obi");
		getServer().getPluginManager().registerEvents(new SpawnEvents(), this);
	}
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "SpawnPoint made by Obi");

	}
}
