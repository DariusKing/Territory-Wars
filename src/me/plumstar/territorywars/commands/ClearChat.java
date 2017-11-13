package me.plumstar.territorywars.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("territorywars.clearchat")) {
            for (int i = 1; i < 150; i++) {
                for (Player pla : Bukkit.getOnlinePlayers()) {
                    pla.sendMessage("");
                }
            }
        }
        return false;
    }

}
