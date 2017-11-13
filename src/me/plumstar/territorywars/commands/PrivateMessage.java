package me.plumstar.territorywars.commands;

import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrivateMessage implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pm") || cmd.getName().equalsIgnoreCase("msg")
                || cmd.getName().equalsIgnoreCase("w") || cmd.getName().equalsIgnoreCase("whisper")
                || cmd.getName().equalsIgnoreCase("message")) {
            if (sender.hasPermission("territorywars.message")) {
                if (args.length < 2) {
                    sender.sendMessage(ChatColor.DARK_RED + "Usage: /msg <player> <message>");
                } else if (args.length >= 2) {
                    Player target = (Player) Bukkit.getPlayer(args[0]);
                    String message = StringUtils.join(args, " ", 1, args.length);
                    if (target != null) {
                        target.sendMessage(ChatColor.DARK_RED + sender.getName() + ChatColor.DARK_GRAY + " -> "
                                + ChatColor.DARK_RED + target.getName() + ChatColor.DARK_GRAY + ": "
                                + ChatColor.DARK_RED + message);
                        sender.sendMessage(ChatColor.DARK_RED + sender.getName() + ChatColor.DARK_GRAY + " -> "
                                + ChatColor.DARK_RED + target.getName() + ChatColor.DARK_GRAY + ": "
                                + ChatColor.DARK_RED + ChatColor.translateAlternateColorCodes('&', message));
                    } else {
                        sender.sendMessage(ChatColor.DARK_RED + args[0] + " is not online.");
                    }
                }
            }
        }
        return false;
    }

}
