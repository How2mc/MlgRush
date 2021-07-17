package deby_kymy.mlgrush.Listener;

import deby_kymy.mlgrush.Mlgrush;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;


public class GameStates implements Listener {


    private static int xp;
    private static int scheduler;
    public static boolean started = false;
    public static int i = 0;


    public static void count(){


        xp = 6;
        scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Mlgrush.getInstance(), new Runnable() {
            @Override
            public void run() {

                if (xp <= 0) {
                    startGame();
                    Bukkit.getScheduler().cancelTask(scheduler);
                    started = true;
                }


            }
        }, 20, 0);



    }





    public static void startGame(){

        ItemStack stick = new ItemStack(Material.STICK);
        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemStack blocks = new ItemStack(Material.SANDSTONE,  32);


        if (JoinListener.lobbyPhase = false) {


            for (Player all : Bukkit.getOnlinePlayers()){


                ItemMeta meta1 = stick.getItemMeta();
                meta1.setDisplayName("§5Knockback Stick");
                meta1.addEnchant(Enchantment.KNOCKBACK, 4, false);
                stick.setItemMeta(meta1);
                all.getInventory().setItem(0, stick);

                all.getInventory().setItem(1, pickaxe);

                all.getInventory().setItem(2, blocks);






            }

        }



    }



    public static void bedCounter(Player player){
        i++;
    }


    public static void killCounter(Player player){

        int k = 0;
        k++;



    }



    public static void setScoreboard(Player player){

        final ScoreboardManager sm = Bukkit.getScoreboardManager();
        assert sm != null;
        final Scoreboard scoreboard;


        if (player.getScoreboard() == Bukkit.getScoreboardManager().getMainScoreboard()) {
            scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            player.setScoreboard(scoreboard);
        } else {
            scoreboard = player.getScoreboard();


            final Objective o = scoreboard.registerNewObjective("how2mc", "dummy", "§bHow§f2mc§b.de");
            o.setDisplaySlot(DisplaySlot.SIDEBAR);
            o.getScore("§aName:").setScore(0);
            o.getScore(player.getName()).setScore(1);
            o.getScore("§aBeds:").setScore(2);
            o.getScore("§f" + i ).setScore(3);
            o.getScore("§aKills:").setScore(4);


            player.setScoreboard(scoreboard);
        }

    }

}
