package deby_kymy.mlgrush.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBed implements Listener {

    @EventHandler
    public void onBedBreak(BlockBreakEvent event){

        Player player = event.getPlayer();

        if(event.getBlock().getType() == Material.RED_BED){

            GameStates.bedCounter(event.getPlayer());

        }


    }


}
