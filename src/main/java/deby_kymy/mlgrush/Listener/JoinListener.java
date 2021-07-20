package deby_kymy.mlgrush.Listener;

import deby_kymy.mlgrush.Mlgrush;
import deby_kymy.mlgrush.gamestates.EndLobbyPhase;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;





public class JoinListener implements Listener {


    ItemStack l = new ItemStack(Material.NETHER_STAR);


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {



        Player player = event.getPlayer();

        event.setJoinMessage("§a>> §f" + event.getPlayer().getName());

        Location LobbySpawn = (Location) Mlgrush.getInstance().getConfig().get("Spawn.Lobby");
        assert LobbySpawn != null;
        player.teleport(LobbySpawn);

        player.getInventory().clear();
        player.setHealth(20);
        player.setFoodLevel(20);

        ItemMeta lm = l.getItemMeta();
        assert lm != null;
        lm.setDisplayName("§8>> §3Back to the §cLobby §8<<");
        l.setItemMeta(lm);
        player.getInventory().setItem(8, l);

        player.setGameMode(GameMode.ADVENTURE);



        if(!EndLobbyPhase.isRunning){
            EndLobbyPhase.count();
            EndLobbyPhase.isRunning = true;
        }else{
            player.sendMessage("its true ... ._.");
        }


    }

}
