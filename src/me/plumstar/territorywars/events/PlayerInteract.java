package me.plumstar.territorywars.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = (Player) e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (p.getItemInHand().getType() == Material.NETHER_STAR && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Team Selector")) {
                Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Team Selector");

                ItemStack redWool = new ItemStack(Material.WOOL, 1, (short) 14);
                ItemMeta redMeta = redWool.getItemMeta();
                redMeta.setDisplayName(ChatColor.RED + "Red Team");
                redWool.setItemMeta(redMeta);

                ItemStack blueWool = new ItemStack(Material.WOOL, 1, (short) 11);
                ItemMeta blueMeta = blueWool.getItemMeta();
                blueMeta.setDisplayName(ChatColor.BLUE + "Blue Team");
                blueWool.setItemMeta(blueMeta);

                inv.setItem(3, redWool);
                inv.setItem(5, blueWool);

                p.openInventory(inv);
            }
        }


    }
}
