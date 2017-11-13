package me.plumstar.territorywars.commands;

import me.plumstar.territorywars.TerritoryWars;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GlobalMute implements CommandExecutor {

    private TerritoryWars plugin;

    public GlobalMute(TerritoryWars plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("territorywars.globalmute")) {
            if (plugin.getConfig().getBoolean("globalmute") == false) {
                plugin.getConfig().set("globalmute", true);
                plugin.saveConfig();
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Global Mute is now Enabled.");
            } else if (plugin.getConfig().getBoolean("globalmute") == true) {
                plugin.getConfig().set("globalmute", false);
                plugin.saveConfig();
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "Global Mute is now Disabled.");
            }
        }
        return false;
    }

}
