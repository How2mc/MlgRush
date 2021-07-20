package deby_kymy.mlgrush.gamestates;

import deby_kymy.mlgrush.Mlgrush;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StartGame {


    public static boolean started = false;






    static void startGame(){

        ItemStack stick = new ItemStack(Material.STICK);
        ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemStack blocks = new ItemStack(Material.SANDSTONE,  32);

        started = true;

        if (EndLobbyPhase.lobbyPhase = false) {


            for (Player all : Bukkit.getOnlinePlayers()){

                all.setGameMode(GameMode.SURVIVAL);

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
