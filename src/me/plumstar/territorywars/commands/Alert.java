package me.plumstar.territorywars.commands;

import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Alert implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("territorywars.alert")) {
            if (args.length < 1) {
                return false;
            }
            String message = StringUtils.join(args, " ", 0, args.length);
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Alert" + ChatColor.DARK_GRAY
                    + "] " + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', message));
        }
        return false;
    }

}
