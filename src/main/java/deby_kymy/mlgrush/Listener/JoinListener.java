package deby_kymy.mlgrush.Listener;

import deby_kymy.mlgrush.Mlgrush;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class JoinListener implements Listener {

    ArrayList<Player> ingame = new ArrayList<>();

    public int xp;
    public int scheduler;
    public static boolean lobbyPhase = true;
    public boolean isRunning = false;

    ItemStack l = new ItemStack(Material.NETHER_STAR);

    @EventHandler
        public void onJoin(PlayerJoinEvent event){
            Player player = event.getPlayer();

            event.setJoinMessage("§a>>" + event.getPlayer().getName());

            Location LobbySpawn = (Location) Mlgrush.getInstance().getConfig().get("Spawn.Lobby");
            assert LobbySpawn != null;
            player.teleport(LobbySpawn);


            ItemMeta lm = l.getItemMeta();
            assert lm != null;
            lm.setDisplayName("§8>> §cBack to the Lobby §8<< ");
            l.setItemMeta(lm);
            player.getInventory().setItem(8, l);

            if(isRunning = false){
                count();
                isRunning = true;
            }


        for (final Player all : Bukkit.getOnlinePlayers()) {
            GameStates.setScoreboard(event.getPlayer());
        }


    }

        public void count(){
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


                            GameStates.count();
                        }else{
                            for (Player all : Bukkit.getOnlinePlayers()){
                                all.sendMessage(Mlgrush.PREFIX + "§b" + Bukkit.getOnlinePlayers() + "§3" + Bukkit.getMaxPlayers() + "§6More Player a needed: §c 1");
                            }
                        }
                    }else {
                        xp--;
                        for (Player all : Bukkit.getOnlinePlayers()){
                            all.setLevel(xp);
                            if(xp == 25){
                                all.sendMessage(Mlgrush.PREFIX + "§8teleport in §3" + xp + "§8 seconds");
                                all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                            }
                            if(xp == 20){
                                all.sendMessage(Mlgrush.PREFIX + "§8teleport in §3" + xp + "§8 seconds");
                                all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                            }
                            if(xp == 15){
                                all.sendMessage(Mlgrush.PREFIX + "§8teleport in §3" + xp + "§8 seconds");
                                all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                            }
                            if(xp == 10){
                                all.sendMessage(Mlgrush.PREFIX + "§8teleport in §3" + xp + "§8 seconds");
                                all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                            }
                            if(xp == 5){
                                all.sendMessage(Mlgrush.PREFIX + "§8teleport in §3" + xp + "§8 seconds");
                                all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                            }
                            if(xp == 4){
                                all.sendMessage(Mlgrush.PREFIX + "§8teleport in §3" + xp + "§8 seconds");
                                all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                            }
                            if(xp == 3){
                                all.sendMessage(Mlgrush.PREFIX + "§8teleport in §3" + xp + "§8 seconds");
                                all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                            }
                            if(xp == 2){
                                all.sendMessage(Mlgrush.PREFIX + "§8teleport in §3" + xp + "§8 seconds");
                                all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                            }
                            if(xp == 1){
                                all.sendMessage(Mlgrush.PREFIX + "§8teleport in §3" + xp + "§8 seconds");
                                all.playSound(all.getLocation(), Sound.ENTITY_CHICKEN_EGG, 15,15 );
                            }
                            if(xp == 0){
                                all.sendMessage(Mlgrush.PREFIX + "§8teleport in §3" + xp + "§8 seconds");
                                all.playSound(all.getLocation(), Sound.ENTITY_DOLPHIN_DEATH, 15,15 );
                            }

                        }
                    }


                }
            },0, 20);


        }



    @EventHandler()
    public void onLeave(PlayerInteractEvent e) {
        Player p = (Player)e.getPlayer();
        if(e.getItem() == null) return;

        if(e.getItem().getType() == Material.NETHER_STAR)
            if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
            {
                if(Objects.requireNonNull(e.getItem().getItemMeta()).getDisplayName().equalsIgnoreCase("§8>> §3Back to the §cLobby§8 <<")) {

                    ByteArrayOutputStream b = new ByteArrayOutputStream();
                    DataOutputStream out = new DataOutputStream(b);

                    try {
                        out.writeUTF("Connect");
                        out.writeUTF("Lobby-1");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }


                    p.sendPluginMessage(Mlgrush.getInstance(), "BungeeCord", b.toByteArray());
                    p.sendMessage(Mlgrush.PREFIX + "§bYou was teleported to the Lobby");

                }

            }
    }


    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        if (lobbyPhase = true) {
            if (event.getEntity() instanceof Player) {
                event.setCancelled(true);
            }
        }


    }


    @EventHandler
    public void onFoodLost(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }

}
