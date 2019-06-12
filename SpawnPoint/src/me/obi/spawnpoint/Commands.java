package me.obi.spawnpoint;


import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.CommandExecute;

public class Commands extends CommandExecute implements Listener, CommandExecutor {
	private Plugin plugin = SpawnPoint.getPlugin(SpawnPoint.class);

	public String cmd1 = "spawnpoint";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    Player player =(Player) sender;
		Location loc = player.getLocation();
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase(cmd1)) {
				plugin.getConfig().set("World", loc.getWorld());
				plugin.getConfig().set("X", loc.getX());
				plugin.getConfig().set("Y", loc.getY());
				plugin.getConfig().set("Z", loc.getZ());
				plugin.getConfig().set("Pitch", loc.getPitch());
				plugin.getConfig().set("Yawn", loc.getYaw());
				plugin.saveConfig();
				sender.sendMessage(ChatColor.GREEN + "Spawnpoint set!");
				return true;
			}
			}else{ sender.sendMessage(ChatColor.RED + "Command only for players");
			return true;
		}

		return false;
	}
}