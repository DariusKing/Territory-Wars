package me.plumstar.territorywars;

import me.plumstar.territorywars.commands.*;
import me.plumstar.territorywars.enchants.exploding.ArrowHit;
import me.plumstar.territorywars.enchants.exploding.ArrowShoot;
import me.plumstar.territorywars.enchants.tank.PlayerEquipArmor;
import me.plumstar.territorywars.events.*;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_9_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_9_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_9_R1.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_9_R1.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class TerritoryWars extends JavaPlugin {

    public File teamsFile;
    public FileConfiguration teamsConfig;
    public File curseFile;
    public FileConfiguration curseList;
    public File rulesFile;
    public FileConfiguration rulesList;
    public File votingFile;
    public FileConfiguration votingList;
    public File pointsFile;
    public FileConfiguration points;
    public ScoreboardManager sm;
    public Scoreboard sb;
    public Objective pointsObj;
    public Score redScore;
    public Score blueScore;
    public HashMap<Player, Integer> captureTime = new HashMap<Player, Integer>();

    @Override
    public void onEnable() {
        registerEvents();
        registerCommands();
        registerConfigs();
        registerScoreboards();
        loadConfigs();

        restarts();
        getServer().getPluginManager().registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
    }

    @Override
    public void onDisable() {
        saveConfigs();
        captureTime.clear();
    }

    private void registerScoreboards() {
        sm = Bukkit.getScoreboardManager();
        sb = sm.getNewScoreboard();
        pointsObj = sb.registerNewObjective("points", "dummy");
        redScore = pointsObj.getScore(ChatColor.RED + "Red: ");
        blueScore = pointsObj.getScore(ChatColor.BLUE + "Blue: ");

        for (Player p : Bukkit._INVALID_getOnlinePlayers()) {
            p.setScoreboard(sb);
        }
        pointsObj.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Points");
        pointsObj.setDisplaySlot(DisplaySlot.SIDEBAR);

        redScore.setScore(points.getInt("redPoints"));
        blueScore.setScore(points.getInt("bluePoints"));
    }

    public void updateScoreboards() {
        redScore.setScore(points.getInt("redPoints"));
        blueScore.setScore(points.getInt("bluePoints"));
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerEquipArmor(), this);
        pm.registerEvents(new ArrowHit(this), this);
        pm.registerEvents(new ArrowShoot(this), this);
        pm.registerEvents(new EntityDamage(), this);
        pm.registerEvents(new PlayerChat(this), this);
        pm.registerEvents(new PlayerDeath(this), this);
        pm.registerEvents(new PlayerInteractEntity(), this);
        pm.registerEvents(new me.plumstar.territorywars.enchants.sniper.PlayerToggleSneak(), this);
        pm.registerEvents(new me.plumstar.territorywars.capturing.PlayerToggleSneak(this), this);
        pm.registerEvents(new ServerListPing(), this);
        pm.registerEvents(new VotifierEvent(this), this);
    }

    private void registerCommands() {
        GlobalMute globalMute = new GlobalMute(this);
        PrivateMessage privateMessage = new PrivateMessage();
        SpawnNPCs spawnNPCs = new SpawnNPCs();
        getCommand("addswear").setExecutor(new AddSwear(this));
        getCommand("alert").setExecutor(new Alert());
        getCommand("cchat").setExecutor(new ClearChat());
        getCommand("ce").setExecutor(new CustomEnchant());
        getCommand("forcevote").setExecutor(new ForceVote());
        getCommand("gm").setExecutor(globalMute);
        getCommand("globalmute").setExecutor(globalMute);
        getCommand("ping").setExecutor(new Ping());
        getCommand("pm").setExecutor(privateMessage);
        getCommand("msg").setExecutor(privateMessage);
        getCommand("w").setExecutor(privateMessage);
        getCommand("whisper").setExecutor(privateMessage);
        getCommand("message").setExecutor(privateMessage);
        getCommand("report").setExecutor(new Report());
        getCommand("resetscores").setExecutor(new ResetScores(this));
        getCommand("rules").setExecutor(new Rules(this));
        getCommand("spawnshopkeeper").setExecutor(spawnNPCs);
        getCommand("spawnsomerandyvillager").setExecutor(spawnNPCs);
        getCommand("sc").setExecutor(new StaffChat());
        getCommand("tc").setExecutor(new TeamChat(this));
        getCommand("vote").setExecutor(new Vote());
        getCommand("youtube").setExecutor(new Youtube());
    }

    public void registerConfigs() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        teamsFile = new File(getDataFolder() + "/teams.yml");
        teamsConfig = new YamlConfiguration().loadConfiguration(teamsFile);
        curseFile = new File(getDataFolder() + "/curse.yml");
        curseList = new YamlConfiguration().loadConfiguration(curseFile);
        rulesFile = new File(getDataFolder() + "/rules.yml");
        rulesList = new YamlConfiguration().loadConfiguration(rulesFile);
        votingFile = new File(getDataFolder() + "/votes.yml");
        votingList = new YamlConfiguration().loadConfiguration(votingFile);
        pointsFile = new File(getDataFolder() + "/points.yml");
        points = new YamlConfiguration().loadConfiguration(pointsFile);
    }

    private void restarts() {
        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit._INVALID_getOnlinePlayers()) {
                    PacketPlayOutTitle restartTitlePacket = new PacketPlayOutTitle(EnumTitleAction.TITLE,
                            ChatSerializer.a("{\"text\":\"Server Restarting\",\"color\":\"dark_red\",\"bold\":true}"),
                            20, 40, 30);

                    PacketPlayOutTitle restartSubtitlePacket = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE,
                            ChatSerializer
                                    .a("{\"text\":\"in 2 minutes.\",\"color\":\"dark_red\",\"italic\":true}"),
                            20, 40, 30);

                    PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
                    connection.sendPacket(restartTitlePacket);
                    connection.sendPacket(restartSubtitlePacket);
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                            "playsound entity.enderdragon.growl master " + p.getName() + " 0 0 0 10000");
                }
            }
        }, 141600L, 141600L);

        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "restart");
            }
        }, 144000L, 144000L);
    }

    public void saveConfigs() {
        try {
            teamsConfig.save(teamsFile);
            curseList.save(curseFile);
            rulesList.save(rulesFile);
            votingList.save(votingFile);
            points.save(pointsFile);
            saveConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadConfigs() {
        if (teamsFile.exists() || curseFile.exists() || rulesFile.exists() || votingFile.exists()
                || pointsFile.exists()) {
            try {
                teamsConfig.load(teamsFile);
                curseList.load(curseFile);
                rulesList.load(rulesFile);
                votingList.load(votingFile);
                points.load(pointsFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidConfigurationException e) {
                e.printStackTrace();
            }
        } else {
            try {
                teamsConfig.save(teamsFile);
                curseList.save(curseFile);
                rulesList.save(rulesFile);
                votingList.save(votingFile);
                points.save(pointsFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
