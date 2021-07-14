package deby_kymy.mlgrush.Listener;

import deby_kymy.mlgrush.Mlgrush;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class GameStates implements Listener {


    private static int xp;
    private static int scheduler;
    public static boolean started = false;

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



}
