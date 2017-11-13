package me.plumstar.territorywars.enchants.sniper;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerToggleSneak implements Listener {

    @EventHandler
    public void onPlayerSneakEvent(PlayerToggleSneakEvent e) {
        Player p = (Player) e.getPlayer();
        if (p.getItemInHand().hasItemMeta() == false || p.getItemInHand().getItemMeta().hasLore() == false) return;
        if (p.isSneaking() == false
                && p.getItemInHand().getItemMeta().getLore().contains(ChatColor.GREEN + "Sniper I")) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 20));
        } else if (p.isSneaking() == true
                && p.getItemInHand().getItemMeta().getLore().contains(ChatColor.GREEN + "Sniper I")) {
            p.removePotionEffect(PotionEffectType.SLOW);
        }
    }
}
