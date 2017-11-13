package me.plumstar.territorywars.commands;

import me.plumstar.territorywars.TerritoryWars;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class Rules implements CommandExecutor {

    private TerritoryWars plugin;

    public Rules(TerritoryWars plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> rulesStringList = (List<String>) plugin.rulesList.getStringList("rules");
        for (int i = 0; i < rulesStringList.size(); i++) {
            sender.sendMessage(ChatColor.DARK_RED + rulesStringList.get(i));
        }
        return false;
    }

}
