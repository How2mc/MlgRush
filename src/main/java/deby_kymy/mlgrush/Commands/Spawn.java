package deby_kymy.mlgrush.Commands;

import deby_kymy.mlgrush.Mlgrush;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(command.getName().equalsIgnoreCase("mlgrush")){
            Player player = (Player) sender;
            if(args.length == 2){
                if(args[0].equalsIgnoreCase("set")){
                    if(args[1].equalsIgnoreCase("LobbySpawn")){
                        double x = player.getLocation().getX();
                        double y = player.getLocation().getY();
                        double z = player.getLocation().getZ();
                        String w = player.getWorld().getName();
                        float yaw = player.getLocation().getYaw();
                        float pitch = player.getLocation().getPitch();
                        World world = Bukkit.getWorld(w);
                        Location LobbySpawn = new Location(world, x, y, z, yaw, pitch);

                        Mlgrush.getInstance().getConfig().set("Spawn.Lobby", LobbySpawn);
                    }

                    if(args[1].equalsIgnoreCase("Spawn1")){
                        double x = player.getLocation().getX();
                        double y = player.getLocation().getY();
                        double z = player.getLocation().getZ();
                        String w = player.getWorld().getName();
                        float yaw = player.getLocation().getYaw();
                        float pitch = player.getLocation().getPitch();
                        World world = Bukkit.getWorld(w);
                        Location Spawn1 = new Location(world, x, y, z, yaw, pitch);

                        Mlgrush.getInstance().getConfig().set("Spawn.1", Spawn1);
                    }

                    if(args[1].equalsIgnoreCase("Spawn2")){
                        double x = player.getLocation().getX();
                        double y = player.getLocation().getY();
                        double z = player.getLocation().getZ();
                        String w = player.getWorld().getName();
                        float yaw = player.getLocation().getYaw();
                        float pitch = player.getLocation().getPitch();
                        World world = Bukkit.getWorld(w);
                        Location Spawn2 = new Location(world, x, y, z, yaw, pitch);

                        Mlgrush.getInstance().getConfig().set("Spawn.2", Spawn2);
                    }
                }
            }
        }



        return false;
    }
}
