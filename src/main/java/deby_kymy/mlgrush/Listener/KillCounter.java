package deby_kymy.mlgrush.Listener;

import deby_kymy.mlgrush.Mlgrush;
import deby_kymy.mlgrush.gamestates.EndLobbyPhase;
import deby_kymy.mlgrush.scoreboard.SetScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class KillCounter implements Listener {

    @EventHandler
    public void onKill(PlayerDeathEvent event){


        Player player1 = EndLobbyPhase.ingame.get(0);
        Player player2 = EndLobbyPhase.ingame.get(1);

        if (event.getEntity().getPlayer() == player1){

            SetScoreboard.kills2++;

            for (Player all : Bukkit.getOnlinePlayers()){

                SetScoreboard.setScoreboard(all);
            }

            Location Spawn1 = (Location) Mlgrush.getInstance().getConfig().get("Lobby.1");
            assert Spawn1 != null;
            player1.teleport(Spawn1);

            Location Spawn2 = (Location) Mlgrush.getInstance().getConfig().get("Lobby.2");
            assert Spawn2 != null;
            player2.teleport(Spawn2);

        }else if(event.getEntity().getPlayer() == player2){

            SetScoreboard.kills1++;

            for (Player all : Bukkit.getOnlinePlayers()){

                SetScoreboard.setScoreboard(all);
            }

            Location Spawn1 = (Location) Mlgrush.getInstance().getConfig().get("Lobby.1");
            assert Spawn1 != null;
            player1.teleport(Spawn1);

            Location Spawn2 = (Location) Mlgrush.getInstance().getConfig().get("Lobby.2");
            assert Spawn2 != null;
            player2.teleport(Spawn2);
        }


    }

}
