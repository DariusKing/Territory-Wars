package me.plumstar.territorywars.commands;

import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("territorywars.report")) {
                if (args.length >= 2) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player p = (Player) sender;
                        Player target = Bukkit.getPlayer(args[0]);
                        String report = StringUtils.join(args, " ", 1, args.length);
                        for (Player pla : Bukkit.getOnlinePlayers()) {
                            if (pla.hasPermission("teritorywars.recievereport")) {
                                pla.sendMessage(
                                        ChatColor.DARK_GRAY + "(Report) " + ChatColor.DARK_RED + target.getName()
                                                + ChatColor.GRAY + " has been reported by " + ChatColor.DARK_RED
                                                + p.getName() + ChatColor.GRAY + " for " + ChatColor.BLUE + report);
                            }
                        }
                    } else {
                        sender.sendMessage(ChatColor.DARK_RED + "Player not found.");
                    }
                } else {
                    sender.sendMessage(ChatColor.DARK_RED + "/report <player> <reason>");
                }
            }
        }
        return false;
    }
}
