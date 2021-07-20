package deby_kymy.mlgrush.scoreboard;

import deby_kymy.mlgrush.gamestates.EndLobbyPhase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class SetScoreboard {

    public static int beds1 = 0;
    public static int beds2 = 0;
    public static int kills1 = 0;
    public static int kills2 = 0;


    public static void setScoreboard(Player player){

        final ScoreboardManager sm = Bukkit.getScoreboardManager();
        assert sm != null;
        final Scoreboard scoreboard;


        if (player.getScoreboard() == Bukkit.getScoreboardManager().getMainScoreboard()) {
            scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            player.setScoreboard(scoreboard);
        } else {
            scoreboard = player.getScoreboard();


            final Objective o = scoreboard.registerNewObjective("how2mc", "dummy", "§bHow§f2mc§b.de");
            o.setDisplaySlot(DisplaySlot.SIDEBAR);
            o.getScore("§aName:").setScore(0);
            o.getScore(player.getName()).setScore(1);
            o.getScore("§aBeds §f>>" + EndLobbyPhase.ingame.get(0).getName() + ":").setScore(2);
            o.getScore("§f" + beds1 ).setScore(3);
            o.getScore("§aBeds §f>>" + EndLobbyPhase.ingame.get(1).getName() + ":").setScore(4);
            o.getScore("§f" + beds2).setScore(5);
            o.getScore("§aKills:").setScore(6);


            player.setScoreboard(scoreboard);
        }

    }



}
