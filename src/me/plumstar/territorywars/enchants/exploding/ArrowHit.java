package me.plumstar.territorywars.enchants.exploding;

import me.plumstar.territorywars.TerritoryWars;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowHit implements Listener {

    private TerritoryWars plugin;

    public ArrowHit(TerritoryWars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (!(e.getEntityType() == EntityType.ARROW)) {
            return;
        }

        Projectile arrow = e.getEntity();
        Location arrowLoc = arrow.getLocation();
        double blockX = (double) arrowLoc.getBlockX();
        double blockY = (double) arrowLoc.getBlockY();
        double blockZ = (double) arrowLoc.getBlockZ();

        if (arrow.hasMetadata("ExplosiveLvl1")) {
            arrow.getWorld().createExplosion(blockX, blockY, blockZ, 1.0F, false, false);
            arrow.removeMetadata("ExplosiveLvl1", plugin);
        } else if (arrow.hasMetadata("ExplosiveLvl2")) {
            arrow.getWorld().createExplosion(blockX, blockY, blockZ, 2.0F, false, false);
            arrow.removeMetadata("ExplosiveLvl2", plugin);
        } else if (arrow.hasMetadata("ExplosiveLvl3")) {
            arrow.getWorld().createExplosion(blockX, blockY, blockZ, 3.0F, false, false);
            arrow.removeMetadata("ExplosiveLvl3", plugin);
        } else if (arrow.hasMetadata("ExplosiveLvl4")) {
            arrow.getWorld().createExplosion(blockX, blockY, blockZ, 4.0F, false, false);
            arrow.removeMetadata("ExplosiveLvl4", plugin);
        }
    }

}
