package me.plumstar.territorywars.commands;

import me.plumstar.territorywars.TerritoryWars;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class AddSwear implements CommandExecutor {

    private TerritoryWars plugin;

    public AddSwear(TerritoryWars plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("territorywars.addswear")) {
            if (args.length > 0) {
                List<String> curseStringList = (List<String>) plugin.curseList.getList("words");
                curseStringList.add(args[0].toString());
                plugin.saveConfigs();
                sender.sendMessage(
                        ChatColor.DARK_GRAY + "Added word " + ChatColor.DARK_RED + args[0] + ChatColor.DARK_GRAY + ".");
            }
        }
        return false;
    }

}
