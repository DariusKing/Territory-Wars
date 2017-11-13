package me.plumstar.territorywars.enchants.tank;

import me.plumstar.territorywars.ArmorEquipEvent;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerEquipArmor implements Listener {

    @EventHandler
    public void onPlayerEquipArmor(ArmorEquipEvent e) {
        Player p = (Player) e.getPlayer();
        if (e.getNewArmorPiece() != null) {
            if (e.getNewArmorPiece().getItemMeta().getLore() == null) {
                return;
            }
            if (e.getNewArmorPiece().getItemMeta().getLore().contains(ChatColor.GREEN + "Tank I")) {
                p.setMaxHealth(24D);
            } else if (e.getNewArmorPiece().getItemMeta().getLore().contains(ChatColor.GREEN + "Tank II")) {
                p.setMaxHealth(28D);
            } else if (e.getNewArmorPiece().getItemMeta().getLore().contains(ChatColor.GREEN + "Tank III")) {
                p.setMaxHealth(32D);
            } else if (e.getNewArmorPiece().getItemMeta().getLore().contains(ChatColor.GREEN + "Tank IV")) {
                p.setMaxHealth(36D);
            } else if (e.getNewArmorPiece().getItemMeta().getLore().contains(ChatColor.GREEN + "Tank V")) {
                p.setMaxHealth(40D);
            }
        }

        if (e.getOldArmorPiece() != null) {
            if (e.getOldArmorPiece().getItemMeta().getLore().contains(ChatColor.GREEN + "Tank I")
                    || e.getOldArmorPiece().getItemMeta().getLore().contains(ChatColor.GREEN + "Tank II")
                    || e.getOldArmorPiece().getItemMeta().getLore().contains(ChatColor.GREEN + "Tank III")
                    || e.getOldArmorPiece().getItemMeta().getLore().contains(ChatColor.GREEN + "Tank IV")
                    || e.getOldArmorPiece().getItemMeta().getLore().contains(ChatColor.GREEN + "Tank V")) {
                p.setMaxHealth(20);
            }
        }
    }
}
