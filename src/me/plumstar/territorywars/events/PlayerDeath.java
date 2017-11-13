package me.plumstar.territorywars.events;

import me.plumstar.territorywars.TerritoryWars;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerDeath implements Listener {

    private TerritoryWars plugin;

    public PlayerDeath(TerritoryWars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = (Player) e.getEntity();
        Entity killer = p.getKiller();
        if (killer instanceof Player) {
            Player killer1 = (Player) p.getKiller();
            ItemStack itemInHand = ((Player) killer1).getItemInHand();
            List<String> redTeam = (List<String>) plugin.teamsConfig.getList("red");
            List<String> blueTeam = (List<String>) plugin.teamsConfig.getList("blue");
            if (redTeam.contains(p.getUniqueId().toString())) {
                EntityDamageEvent ede = p.getLastDamageCause();
                DamageCause dc = ede.getCause();
                if (dc == DamageCause.ENTITY_ATTACK) {
                    Bukkit.broadcastMessage(ChatColor.BLUE + killer1.getName() + ChatColor.GRAY + "slays"
                            + ChatColor.RED + p.getName() + ChatColor.GRAY + "with" + ChatColor.BLUE
                            + itemInHand.getType().toString());
                } else if (dc == DamageCause.PROJECTILE) {
                    Bukkit.broadcastMessage(ChatColor.BLUE + killer1.getName() + ChatColor.GRAY + "shot"
                            + ChatColor.RED + p.getName() + ChatColor.GRAY + "with" + ChatColor.BLUE
                            + itemInHand.getType().toString());
                }
            } else if (blueTeam.contains(p.getUniqueId().toString())) {
                EntityDamageEvent ede = p.getLastDamageCause();
                DamageCause dc = ede.getCause();
                if (dc == DamageCause.ENTITY_ATTACK) {
                    Bukkit.broadcastMessage(ChatColor.RED + killer1.getName() + ChatColor.GRAY + " slays "
                            + ChatColor.BLUE + p.getName() + ChatColor.GRAY + " with " + ChatColor.RED
                            + itemInHand.getType().toString());
                } else if (dc == DamageCause.PROJECTILE) {
                    Bukkit.broadcastMessage(ChatColor.RED + killer1.getName() + ChatColor.GRAY + " slays "
                            + ChatColor.BLUE + p.getName() + ChatColor.GRAY + " with " + ChatColor.RED
                            + itemInHand.getType().toString());
                }
            }
        }
    }

}
