package deby_kymy.mlgrush.gamestates;

import deby_kymy.mlgrush.Mlgrush;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;


import java.util.ArrayList;


public class EndLobbyPhase {

    public static ArrayList<Player> ingame = new ArrayList<>();


    public static int xp;
    public static int scheduler;
    public static boolean lobbyPhase = true;
    public static boolean isRunning = false;


    public static void count(){
        xp = 31;
        scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Mlgrush.getInstance(), new Runnable() {
            @Override
            public void run() {

                if(xp <= 0){
                    if(Bukkit.getOnlinePlayers().size() == 2){

                        Bukkit.getScheduler().cancelTask(scheduler);

                        lobbyPhase = false;

                        ingame.addAll(Bukkit.getOnlinePlayers());
                        Player player1 = ingame.get(0);
                        Player player2 = ingame.get(1);

                        Location Spawn1 = (Location) Mlgrush.getInstance().getConfig().get("Lobby.1");
                        assert Spawn1 != null;
                        player1.teleport(Spawn1);

                        Location Spawn2 = (Location) Mlgrush.getInstance().getConfig().get("Lobby.2");
                        assert Spawn2 != null;
                        player2.teleport(Spawn2);


                        StartGame.startGame();
                        isRunning = false;
                        Bukkit.getScheduler().cancelTask(scheduler);

                    }else{
                        for (Player all : Bukkit.getOnlinePlayers()){
                            all.sendMessage(Mlgrush.PREFIX + " §b" + Bukkit.getOnlinePlayers().size() + "§f/§3" + Bukkit.getMaxPlayers() + " §6More Players are needed: §c1");
                            Bukkit.getScheduler().cancelTask(scheduler);
                            count();
                        }
                    }
                }else {
                    xp--;
                    for (Player all : Bukkit.getOnlinePlayers()){
                        all.setLevel(xp);
                        if(xp == 25){
                            all.sendMessage(Mlgrush.PREFIX + " §7Teleport in §3" + xp + "§7 seconds");
                            all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                        }
                        if(xp == 20){
                            all.sendMessage(Mlgrush.PREFIX + " §7Teleport in §3" + xp + "§7 seconds");
                            all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                        }
                        if(xp == 15){
                            all.sendMessage(Mlgrush.PREFIX + " §7Teleport in §3" + xp + "§7 seconds");
                            all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                        }
                        if(xp == 10){
                            all.sendMessage(Mlgrush.PREFIX + " §7Teleport in §3" + xp + "§7 seconds");
                            all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                        }
                        if(xp == 5){
                            all.sendMessage(Mlgrush.PREFIX + " §7Teleport in §3" + xp + "§7 seconds");
                            all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                        }
                        if(xp == 4){
                            all.sendMessage(Mlgrush.PREFIX + " §7Teleport in §3" + xp + "§7 seconds");
                            all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                        }
                        if(xp == 3){
                            all.sendMessage(Mlgrush.PREFIX + " §7Teleport in §3" + xp + "§7 seconds");
                            all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                        }
                        if(xp == 2){
                            all.sendMessage(Mlgrush.PREFIX + " §7Teleport in §3" + xp + "§7 seconds");
                            all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                        }
                        if(xp == 1){
                            all.sendMessage(Mlgrush.PREFIX + " §7Teleport in §3" + xp + "§7 seconds");
                            all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                        }
                        if(xp == 0){
                            all.sendMessage(Mlgrush.PREFIX + " §7Teleport in §3" + xp + "§7 seconds");
                            all.playSound(all.getLocation(), Sound.ENTITY_DOLPHIN_DEATH, 15,15 );
                        }

                    }
                }


            }
        },0, 20);


    }




}
