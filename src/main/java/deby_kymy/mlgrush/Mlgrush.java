package deby_kymy.mlgrush;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mlgrush extends JavaPlugin {


    public static String PREFIX = "[§bMlg§fRush]";
    public static Mlgrush instance;
    public static Mlgrush getInstance(){return instance;}



    @Override
    public void onEnable() {


        PluginManager pluginManager = Bukkit.getPluginManager();

        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
