package me.plumstar.territorywars.events;

import me.plumstar.territorywars.TerritoryWars;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.List;

public class PlayerChat implements Listener {

    private TerritoryWars plugin;

    public PlayerChat(TerritoryWars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChatSwear(PlayerChatEvent e) {
        List<String> curseStringList = (List<String>) plugin.curseList.getList("words");
        String message = e.getMessage().toLowerCase();
        Player p = (Player) e.getPlayer();
        if (p.hasPermission("territorywars.anticursebypass")) {
            return;
        } else {
            for (String blacklist : curseStringList) {
                if (message.contains(blacklist)) {
                    p.sendMessage(ChatColor.DARK_RED
                            + "Please do not swear or try and circumvent the filter. This will result in a temp or perm mute.");
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onChatGM(PlayerChatEvent e) {
        Player p = (Player) e.getPlayer();
        if (p.hasPermission("territorywars.gmoverride")) {
            return;
        } else {
            if (plugin.getConfig().getBoolean("globalmute") == true) {
                e.setCancelled(true);
                p.sendMessage(ChatColor.DARK_RED + "Global Chat is currently Disabled.");
            }
        }
    }

}
