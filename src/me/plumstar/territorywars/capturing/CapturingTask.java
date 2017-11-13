package me.plumstar.territorywars.capturing;

import me.plumstar.territorywars.TerritoryWars;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class CapturingTask extends BukkitRunnable {

    int counter;
    private TerritoryWars plugin;
    private Player p;
    private HashMap<Player, Integer> captureTime;

    public CapturingTask(TerritoryWars plugin, Player p, HashMap<Player, Integer> captureTime) {
        this.plugin = plugin;
        this.p = p;
        this.captureTime = captureTime;
    }

    @Override
    public void run() {
        if (captureTime.containsKey(p)) {
            if (captureTime.get(p) >= 61) {
                this.cancel();
                return;
            } else if (captureTime.containsKey(p) && captureTime.get(p) >= 1) {
                if (captureTime.get(p) == 60 || captureTime.get(p) == 30 || captureTime.get(p) <= 10) {
                    p.sendMessage(ChatColor.GRAY + "Capturing in " + ChatColor.AQUA + captureTime.get(p));
                }
                captureTime.put(p, captureTime.get(p) - 1);
            } else if (captureTime.get(p) == 0) {
                p.sendMessage(ChatColor.GRAY + "Point Captured!");
                for (Player pla : Bukkit._INVALID_getOnlinePlayers()) {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                            "playsound entity.wither.spawn master " + pla.getName() + " 0 0 0 10000");
                }
                Bukkit.broadcastMessage(
                        ChatColor.DARK_GRAY + p.getName() + ChatColor.GRAY + " has captured a point for their team!");
                if (plugin.teamsConfig.getList("red").contains(p.getUniqueId().toString())) {
                    plugin.points.set("redPoints", plugin.points.getInt("redPoints") + 1);
                    plugin.updateScoreboards();
                } else if (plugin.teamsConfig.getList("blue").contains(p.getUniqueId().toString())) {
                    plugin.points.set("bluePoints", plugin.points.getInt("bluePoints") + 1);
                    plugin.updateScoreboards();
                }
                plugin.saveConfigs();
                captureTime.put(p, 61);
            }
        }
    }
}
