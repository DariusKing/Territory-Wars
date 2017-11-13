package me.plumstar.territorywars.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Vote implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage(ChatColor.GRAY + "Vote on these links to recieve coool rewards:");
        sender.sendMessage(ChatColor.DARK_GRAY + "- " + ChatColor.DARK_RED
                + "http://minecraft-server-list.com/server/335938/vote/");
        return false;
    }

}
