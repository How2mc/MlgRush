package deby_kymy.mlgrush.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoHunger implements Listener {

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event){
        event.setCancelled(true);

    }

}
