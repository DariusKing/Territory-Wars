package me.plumstar.territorywars.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (e.getEntity().getType() == EntityType.VILLAGER) {
            Villager damaged = (Villager) e.getEntity();
            if (damaged.getCustomName().equals(ChatColor.GOLD + "Shop Keeper Isaac")
                    || damaged.getCustomName().equals(ChatColor.GOLD + "Some Randy Villager")) {
                e.setCancelled(true);
            }
        }
    }

}
