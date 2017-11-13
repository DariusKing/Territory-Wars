package me.plumstar.territorywars.commands;

import me.plumstar.territorywars.TerritoryWars;
import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class TeamChat implements CommandExecutor {

    private TerritoryWars plugin;

    public TeamChat(TerritoryWars plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tc")) {
            if (sender.hasPermission("territorywars.teamchat")) {
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    String message = StringUtils.join(args, " ", 0, args.length);
                    List<String> redTeam = (List<String>) plugin.teamsConfig.getList("red");
                    List<String> blueTeam = (List<String>) plugin.teamsConfig.getList("blue");
                    p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Team Chat" + ChatColor.DARK_GRAY
                            + "] " + p.getName() + ": " + ChatColor.GRAY
                            + ChatColor.translateAlternateColorCodes('&', message));
                    if (redTeam.contains(p.getUniqueId().toString())) {
                        for (Player pla : Bukkit.getOnlinePlayers()) {
                            if (pla.getUniqueId() == p.getUniqueId()) {
                                return false;
                            } else {
                                if (redTeam.contains(pla.getUniqueId().toString())) {
                                    pla.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Team Chat"
                                            + ChatColor.DARK_GRAY + "] " + p.getName() + ": " + ChatColor.GRAY
                                            + ChatColor.translateAlternateColorCodes('&', message));
                                }
                            }
                        }
                    } else if (blueTeam.contains(p.getUniqueId().toString())) {
                        for (Player pla : Bukkit.getOnlinePlayers()) {
                            if (pla.getUniqueId() == p.getUniqueId()) {
                                return false;
                            } else {
                                pla.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Team Chat"
                                        + ChatColor.DARK_GRAY + "] " + p.getName() + ": " + ChatColor.GRAY
                                        + ChatColor.translateAlternateColorCodes('&', message));
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}
