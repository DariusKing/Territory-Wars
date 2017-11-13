package me.plumstar.territorywars.events;

import me.plumstar.territorywars.TerritoryWars;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PlayerJoin implements Listener {

    private TerritoryWars plugin;

    public PlayerJoin(TerritoryWars plugin) {
        this.plugin = plugin;
    }

	/*@EventHandler
    public void onJoinTeams(PlayerJoinEvent e) {
		Player p = (Player) e.getPlayer();
		UUID playerUUID = p.getUniqueId();
		List<String> redPlayers = (List<String>) plugin.teamsConfig.getList("red");
		List<String> bluePlayers = (List<String>) plugin.teamsConfig.getList("blue");
		int redSize = redPlayers.size();
		int blueSize = bluePlayers.size();
		if (redPlayers.contains(p.getUniqueId().toString()) || bluePlayers.contains(p.getUniqueId().toString())) {
			return;
		} else {
			if (redSize > blueSize) {
				bluePlayers.add(playerUUID.toString());
				plugin.saveConfigs();
				Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + " has joined the Blue team.");
			} else if (blueSize > redSize) {
				redPlayers.add(playerUUID.toString());
				plugin.saveConfigs();
				Bukkit.getServer().broadcastMessage(ChatColor.RED + p.getName() + " has joined the Red team.");
			} else if (redSize == blueSize) {
				bluePlayers.add(playerUUID.toString());
				plugin.saveConfigs();
				Bukkit.getServer().broadcastMessage(ChatColor.BLUE + p.getName() + " has joined the Blue team.");
			}
		}
	}*/

    @EventHandler
    public void onJoinTeams(PlayerJoinEvent e) {
        Player p = (Player) e.getPlayer();
        List<String> redPlayers = (List<String>) plugin.teamsConfig.getList("red");
        List<String> bluePlayers = (List<String>) plugin.teamsConfig.getList("blue");
        if (redPlayers.contains(p.getUniqueId().toString()) || bluePlayers.contains(p.getUniqueId().toString())) {
            return;
        }

        ItemStack star = new ItemStack(Material.NETHER_STAR);
        ItemMeta starMeta = star.getItemMeta();
        starMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Team Selector");
        star.setItemMeta(starMeta);

        p.getInventory().setItem(4, star);
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawn " + p.getName());
    }

    @EventHandler
    public void onJoinMessage(PlayerJoinEvent e) {
        Player p = (Player) e.getPlayer();
        p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
                + "-------------------------------------------------------------------");
        p.sendMessage(ChatColor.DARK_GRAY + "Welcome " + p.getName() + " to Territory Wars.");
        p.sendMessage(ChatColor.DARK_GRAY + "This is a game where you capture points on each others territory.");
        p.sendMessage(ChatColor.DARK_GRAY + "There are two teams and each team has 4 capture points on their sides.");
        p.sendMessage(ChatColor.DARK_GRAY
                + "The objective to the game is at the end of the month to have the most capture points.");
        p.sendMessage(
                ChatColor.DARK_GRAY + "You get capture points by standing in the other teams points for 60 seconds.");
        p.sendMessage(ChatColor.DARK_GRAY + "Enjoy the server, and may the best team win.");
        p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
                + "-------------------------------------------------------------------");
    }

    @EventHandler
    public void onJoinVote(PlayerJoinEvent e) {
        Player p = (Player) e.getPlayer();
        List<String> votingQueue = (List<String>) plugin.votingList.getList("votingQueue");
        if (votingQueue.contains(p.getUniqueId().toString())) {
            p.getInventory().addItem(new ItemStack(Material.DIAMOND, 2));
            votingQueue.remove(p.getUniqueId().toString());
            plugin.saveConfigs();
        }
    }

    @EventHandler
    public void onJoinSound(PlayerJoinEvent e) {
        Player p = (Player) e.getPlayer();
        if (p.hasPlayedBefore() == false) {
            for (Player pla : Bukkit._INVALID_getOnlinePlayers()) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                        "playsound entity.wither.spawn master " + pla.getName() + " 0 0 0 10000");
            }
        } else {
            for (Player pla : Bukkit._INVALID_getOnlinePlayers()) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                        "playsound entity.player.levelup master " + pla.getName() + " 0 0 0 10000");
            }
        }
    }

    @EventHandler
    public void onJoinSB(PlayerJoinEvent e) {
        Player p = (Player) e.getPlayer();
        p.setScoreboard(plugin.sb);
    }

}
