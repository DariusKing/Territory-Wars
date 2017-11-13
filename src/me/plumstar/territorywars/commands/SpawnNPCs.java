package me.plumstar.territorywars.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpawnNPCs implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawnshopkeeper")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("territorywars.spawnvillagers")) {
                    Location pLoc = p.getLocation();
                    Villager shopKeeper = (Villager) p.getWorld().spawnEntity(pLoc, EntityType.VILLAGER);
                    shopKeeper.setCustomName(ChatColor.GOLD + "Shop Keeper Isaac");
                    shopKeeper.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10000000, 6));
                }
            }
        } else if (cmd.getName().equalsIgnoreCase("spawnsomerandyvillager")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("territorywars.spawnvillagers")) {
                    Location pLoc = p.getLocation();
                    Villager shopKeeper = (Villager) p.getWorld().spawnEntity(pLoc, EntityType.VILLAGER);
                    shopKeeper.setCustomName(ChatColor.GOLD + "Some Randy Villager");
                    shopKeeper.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10000000, 6));
                }
            }
        }
        return false;
    }
}
