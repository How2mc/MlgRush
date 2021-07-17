package deby_kymy.mlgrush;

import deby_kymy.mlgrush.Commands.Spawn;
import deby_kymy.mlgrush.Listener.BreakBed;
import deby_kymy.mlgrush.Listener.GameStates;
import deby_kymy.mlgrush.Listener.JoinListener;
import deby_kymy.mlgrush.Listener.KillCounter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Mlgrush extends JavaPlugin {


    public static String PREFIX = "[§bMlg§fRush]";
    public static Mlgrush instance;
    public static Mlgrush getInstance(){return instance;}



    @Override
    public void onEnable() {


        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new GameStates(), this);
        pluginManager.registerEvents(new BreakBed(), this);
        pluginManager.registerEvents(new KillCounter(), this);

        Objects.requireNonNull(getCommand("mlgrush")).setExecutor(new Spawn());

        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
