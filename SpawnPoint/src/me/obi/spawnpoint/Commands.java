package me.obi.spawnpoint;


import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.CommandExecute;

public class Commands extends CommandExecute implements Listener, CommandExecutor {
	private SpawnPoint plugin;

	public Commands(SpawnPoint plugin){
	    this.plugin = plugin;
	}

	public String cmd1 = "spawnpoint";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    Player player =(Player) sender;
		Location loc = player.getLocation();
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase(cmd1)) {
				plugin.getConfig().set("World", loc.getWorld().getName());
				plugin.getConfig().set("X", loc.getX());
				plugin.getConfig().set("Y", loc.getY());
				plugin.getConfig().set("Z", loc.getZ());
				plugin.getConfig().set("Pitch", loc.getPitch());
				plugin.getConfig().set("Yaw", loc.getYaw());
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
