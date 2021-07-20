package deby_kymy.mlgrush.Listener;

import deby_kymy.mlgrush.Mlgrush;
import deby_kymy.mlgrush.gamestates.EndLobbyPhase;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class Leave implements Listener {

    @EventHandler()
    public void onLeave(PlayerInteractEvent event) {
        Player p = (Player) event.getPlayer();
        if (event.getItem() == null) return;

        if (event.getItem().getType() == Material.NETHER_STAR)
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (Objects.requireNonNull(event.getItem().getItemMeta()).getDisplayName().equalsIgnoreCase("§8>> §3Back to the §cLobby §8<<")) {

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

}
