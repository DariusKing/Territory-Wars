package me.plumstar.territorywars.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(ChatColor.DARK_GRAY + "Your ping is: " + ChatColor.DARK_RED + getPing(p) + "ms"
                    + ChatColor.DARK_GRAY + ".");
        }
        return false;
    }

    public int getPing(Player player) {
        return ((CraftPlayer) player).getHandle().ping;
    }

}
