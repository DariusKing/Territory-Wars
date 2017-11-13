package me.plumstar.territorywars.capturing;

import me.plumstar.territorywars.TerritoryWars;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitTask;

public class PlayerToggleSneak implements Listener {

    private TerritoryWars plugin;

    public PlayerToggleSneak(TerritoryWars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onToggleSneak(PlayerToggleSneakEvent e) {
        Player p = (Player) e.getPlayer();
        Location pLoc = p.getLocation();
        if (plugin.teamsConfig.getList("blue").contains(p.getUniqueId().toString())
                && p.getWorld().getBlockAt(pLoc.getBlockX(), pLoc.getBlockY() - 1, pLoc.getBlockZ()).getData() == 14
                && p.isSneaking() == false
                && p.getWorld().getBlockAt(pLoc.getBlockX(), pLoc.getBlockY() - 1, pLoc.getBlockZ())
                .getType() == Material.STAINED_GLASS) {
            plugin.captureTime.put(p, 60);
            BukkitTask task = new CapturingTask(plugin, p, plugin.captureTime).runTaskTimer(plugin, 0L, 20L);
        } else if (plugin.teamsConfig.getList("red").contains(p.getUniqueId().toString())
                && p.getWorld().getBlockAt(pLoc.getBlockX(), pLoc.getBlockY() - 1, pLoc.getBlockZ()).getData() == 11
                && p.isSneaking() == false
                && p.getWorld().getBlockAt(pLoc.getBlockX(), pLoc.getBlockY() - 1, pLoc.getBlockZ())
                .getType() == Material.STAINED_GLASS) {
            plugin.captureTime.put(p, 60);
            BukkitTask task = new CapturingTask(plugin, p, plugin.captureTime).runTaskTimer(plugin, 0L, 20L);
        } else if (p.isSneaking()) {
            if (plugin.captureTime.containsKey(p)) {
                if (plugin.captureTime.get(p) <= 60) {
                    p.sendMessage(ChatColor.DARK_RED + "Capturing cancelled...");
                }
            }
            plugin.captureTime.put(p, 61);
        }
    }
}
