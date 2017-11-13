package me.plumstar.territorywars.enchants.exploding;

import me.plumstar.territorywars.TerritoryWars;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class ArrowShoot implements Listener {

    private TerritoryWars plugin;

    public ArrowShoot(TerritoryWars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onArrowShoot(ProjectileLaunchEvent e) {
        if (!(e.getEntity().getShooter() instanceof Player)) {
            return;
        }

        if (!(e.getEntity().getType() == EntityType.ARROW)) {
            return;
        }

        Player p = (Player) e.getEntity().getShooter();

        if (p.getItemInHand() == null || p.getItemInHand().getItemMeta() == null
                || p.getItemInHand().getItemMeta().getLore() == null) {
            return;
        }

        if (p.getItemInHand().getItemMeta().getLore().contains(ChatColor.GREEN + "Exploding I")) {
            e.getEntity().setMetadata("ExplosiveLvl1", new FixedMetadataValue(plugin, true));
        } else if (p.getItemInHand().getItemMeta().getLore().contains(ChatColor.GREEN + "Exploding II")) {
            e.getEntity().setMetadata("ExplosiveLvl2", new FixedMetadataValue(plugin, true));
        } else if (p.getItemInHand().getItemMeta().getLore().contains(ChatColor.GREEN + "Exploding III")) {
            e.getEntity().setMetadata("ExplosiveLvl3", new FixedMetadataValue(plugin, true));
        } else if (p.getItemInHand().getItemMeta().getLore().contains(ChatColor.GREEN + "Exploding IV")) {
            e.getEntity().setMetadata("ExplosiveLvl4", new FixedMetadataValue(plugin, true));
        } else {
            return;
        }
    }
}
