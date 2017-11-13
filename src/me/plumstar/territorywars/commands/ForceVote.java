package me.plumstar.territorywars.commands;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Date;

public class ForceVote implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("territorywars.forcevote")) {
            String otherPlayer = args[0];
            Vote forceVote = new Vote();
            forceVote.setAddress("1.2.3.4");
            forceVote.setServiceName("forcevote");
            if (args.length > 2) {
                forceVote.setServiceName(args[1]);
            }
            Date date = new Date();
            forceVote.setTimeStamp(String.valueOf(date.getTime()));
            forceVote.setUsername(otherPlayer);
            Bukkit.getPluginManager().callEvent(new VotifierEvent(forceVote));
        }
        return false;
    }

}
