package deby_kymy.mlgrush.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillCounter implements Listener {

    @EventHandler
    public void onKill(PlayerDeathEvent event){

        Player player = event.getEntity().getKiller();



    }

}
