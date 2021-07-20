package deby_kymy.mlgrush.Listener;

import deby_kymy.mlgrush.gamestates.EndLobbyPhase;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class NoPvP implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        if(EndLobbyPhase.lobbyPhase = true){
            event.setCancelled(true);
        }

    }

}
