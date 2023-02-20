package me.simonfoy.minigame.instance;

import me.simonfoy.minigame.GameState;
import me.simonfoy.minigame.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Game {

    private Minigame minigame;
    private Arena arena;
    private HashMap<UUID, Integer> lives;

    public Game(Arena arena) {
        this.arena = arena;
        lives = new HashMap<>();
    }

    public void start(Minigame minigame) {
        this.minigame = minigame;

        arena.setState(GameState.LIVE);
        arena.sendMessage(ChatColor.GREEN + "GAME HAS STARTED! Your objective is this: KILL THE OTHER PLAYER 4 TIMES.");

        for (UUID uuid : arena.getKits().keySet()) {
            arena.getKits().get(uuid).onStart(Bukkit.getPlayer(uuid));
        }
        List<Location> usedLocations = new ArrayList<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            FileConfiguration config = this.minigame.getConfig();

            Location location;
            do {
                int random = (int) (Math.random() * 4) + 1;
                switch (random) {
                    case 1:
                        location = new Location(
                                Bukkit.getWorld(config.getString("arena.world")),
                                config.getDouble("arena.x1"),
                                config.getDouble("arena.y1"),
                                config.getDouble("arena.z1"),
                                (float) config.getDouble("arena.yaw1"),
                                (float) config.getDouble("arena.pitch1"));
                        break;
                    case 2:
                        location = new Location(
                                Bukkit.getWorld(config.getString("arena.world")),
                                config.getDouble("arena.x2"),
                                config.getDouble("arena.y2"),
                                config.getDouble("arena.z2"),
                                (float) config.getDouble("arena.yaw2"),
                                (float) config.getDouble("arena.pitch2"));
                        break;
                    case 3:
                        location = new Location(
                                Bukkit.getWorld(config.getString("arena.world")),
                                config.getDouble("arena.x3"),
                                config.getDouble("arena.y3"),
                                config.getDouble("arena.z3"),
                                (float) config.getDouble("arena.yaw3"),
                                (float) config.getDouble("arena.pitch3"));
                        break;
                    case 4:
                        location = new Location(
                                Bukkit.getWorld(config.getString("arena.world")),
                                config.getDouble("arena.x4"),
                                config.getDouble("arena.y4"),
                                config.getDouble("arena.z4"),
                                (float) config.getDouble("arena.yaw4"),
                                (float) config.getDouble("arena.pitch4"));
                        break;
                    default:
                        location = null;
                        break;
                }
            } while (usedLocations.contains(location));

            usedLocations.add(location);

            player.teleport(location);

            player.setInvulnerable(false);

            lives.put(player.getUniqueId(), 4);
            player.closeInventory();
        }
    }

    public void removeLife(Player player) {
        int playerLives = lives.get(player.getUniqueId()) - 1;
        if (playerLives == 0) {
            arena.sendMessage(ChatColor.RED + player.getName() + " has been eliminated!");
            arena.reset();
            return;
        }
        player.sendMessage(ChatColor.RED + "You have lost a life!");
        lives.replace(player.getUniqueId(), playerLives);
    }
}
