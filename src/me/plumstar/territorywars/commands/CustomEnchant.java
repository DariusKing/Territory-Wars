package me.plumstar.territorywars.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CustomEnchant implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args[0].toString().equalsIgnoreCase("exploding") && args.length == 2) {
                try {
                    p.getItemInHand().getItemMeta().getLore().add(ChatColor.GREEN + "Exploding " + args[1]);
                } catch (Exception e) {
                    return false;
                }
            } else if (args[0].toString().equalsIgnoreCase("sniper") && args.length == 1) {
                try {
                    p.getItemInHand().getItemMeta().getLore().add(ChatColor.GREEN + "Sniper I");
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }
}
