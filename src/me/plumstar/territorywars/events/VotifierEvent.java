package me.plumstar.territorywars.events;

import com.vexsoftware.votifier.model.Vote;
import me.plumstar.territorywars.TerritoryWars;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class VotifierEvent implements Listener {

    private TerritoryWars plugin;

    public VotifierEvent(TerritoryWars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerVote(com.vexsoftware.votifier.model.VotifierEvent e) {
        Vote v = e.getVote();
        if (Bukkit.getPlayer(v.getUsername()) != null) {
            Player p = (Player) Bukkit.getPlayer(v.getUsername());
            p.getInventory().addItem(new ItemStack(Material.DIAMOND, 2));
            Bukkit.broadcastMessage(
                    ChatColor.DARK_RED + v.getUsername() + ChatColor.GRAY + " has voted on " + v.getServiceName() + "!");
            Bukkit.broadcastMessage(
                    ChatColor.GRAY + "Do /vote now to get 2 diamonds per site you vote on!");
        } else {
            List<String> votingQueue = (List<String>) plugin.votingList.getList("votingQueue");
            votingQueue.add(Bukkit.getOfflinePlayer(v.getUsername()).getUniqueId().toString());
            plugin.saveConfigs();
        }
    }

}
