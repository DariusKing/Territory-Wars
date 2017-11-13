package me.plumstar.territorywars.commands;

import me.plumstar.territorywars.TerritoryWars;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ResetScores implements CommandExecutor {

    private TerritoryWars plugin;

    public ResetScores(TerritoryWars plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("territorywars.resetscores")) {
            plugin.redScore.setScore(0);
            plugin.blueScore.setScore(0);
            plugin.points.set("redPoints", 0);
            plugin.points.set("bluePoints", 0);
        }
        return false;
    }

}
