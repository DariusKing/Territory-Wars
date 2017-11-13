package me.plumstar.territorywars.commands;

import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChat implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("territorywars.staffchat")) {
                if (args.length < 1) {
                    return false;
                }
                String message = StringUtils.join(args, " ", 0, args.length);
                for (Player pla : Bukkit.getOnlinePlayers()) {
                    if (pla.hasPermission("territorywars.staffchat")) {
                        pla.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Staff Chat"
                                + ChatColor.DARK_GRAY + "]" + " " + p.getName() + ": " + ChatColor.GRAY + ""
                                + ChatColor.translateAlternateColorCodes('&', message));
                    }
                }
            }
        }
        return false;
    }

}
