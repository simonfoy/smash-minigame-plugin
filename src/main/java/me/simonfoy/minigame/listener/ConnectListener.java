package me.simonfoy.minigame.listener;

import me.simonfoy.minigame.GameState;
import me.simonfoy.minigame.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;

public class ConnectListener implements Listener {

    private Minigame minigame;

    public ConnectListener(Minigame minigame) {
        this.minigame = minigame;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {

        if (minigame.getArena().getState() == GameState.LIVE) {
            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "You cannot join this game right now as it is currently live.");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        player.setGameMode(GameMode.ADVENTURE);
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }

        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        player.setInvulnerable(true);

        minigame.getArena().addPlayer(e.getPlayer());

        FileConfiguration config = this.minigame.getConfig();

        Location spawn = new Location(
                Bukkit.getWorld(config.getString("lobby-spawn.world")),
                config.getDouble("lobby-spawn.x"),
                config.getDouble("lobby-spawn.y"),
                config.getDouble("lobby-spawn.z"),
                (float) config.getDouble("lobby-spawn.yaw"),
                (float) config.getDouble("lobby-spawn.pitch"));
        player.teleport(spawn);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        minigame.getArena().removePlayer(e.getPlayer());

    }
}
