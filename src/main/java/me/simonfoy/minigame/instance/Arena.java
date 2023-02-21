package me.simonfoy.minigame.instance;

import me.simonfoy.minigame.GameState;
import me.simonfoy.minigame.Minigame;
import me.simonfoy.minigame.kit.Kit;
import me.simonfoy.minigame.kit.KitType;
import me.simonfoy.minigame.kit.type.*;
import me.simonfoy.minigame.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class Arena {

    private Minigame minigame;

    private Location spawn;

    private GameState state;

    private HashMap<UUID, Kit> kits;
    private Countdown countdown;
    private Game game;

    public Arena(Minigame minigame) {
        this.minigame = minigame;
        FileConfiguration config = this.minigame.getConfig();
        spawn = new Location(
                Bukkit.getWorld(config.getString("lobby-spawn.world")),
                config.getDouble("lobby-spawn.x"),
                config.getDouble("lobby-spawn.y"),
                config.getDouble("lobby-spawn.z"),
                (float) config.getDouble("lobby-spawn.yaw"),
                (float) config.getDouble("lobby-spawn.pitch"));

        this.state = GameState.RECRUITING;
        this.kits = new HashMap<>();
        this.countdown = new Countdown(this.minigame, this);
        this.game = new Game(this);
    }

    /* GAME */

    public void start() { game.start(minigame); }

    public void reset() {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF("lobby");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
            removeKit(player.getUniqueId());
            player.sendPluginMessage(minigame, "BungeeCord", b.toByteArray());
        }
        kits.clear();
        sendTitle("", "");
        state = GameState.RECRUITING;
        countdown.cancel();
        countdown = new Countdown(minigame, this);
        game = new Game(this);

        Bukkit.getServer().shutdown();
    }

    /* TOOLS */

    public void sendMessage(String message) {
        for (Player player : Bukkit.getOnlinePlayers() ) {
            player.sendMessage(message);
        }
    }

    public void sendTitle(String title, String subtitle) {
        for (Player player : Bukkit.getOnlinePlayers() ) {
            player.sendTitle(title, subtitle);
        }
    }

    /* PLAYERS */
    public void addPlayer(Player player){
        player.teleport(spawn);

        player.sendMessage(ChatColor.GOLD + "Choose your kit with /kit!");

        if (state.equals(GameState.RECRUITING) && Bukkit.getOnlinePlayers().size() >= ConfigManager.getRequiredPlayers()) {
            countdown.start();
        }
    }

    public void removePlayer(Player player){

        removeKit(player.getUniqueId());

        if (state == GameState.COUNTDOWN && Bukkit.getOnlinePlayers().size() - 1 < ConfigManager.getRequiredPlayers()) {
            sendMessage(ChatColor.RED + "There is not enough players. Countdown stopped.");
            reset();
            return;
        }

        if (state == GameState.LIVE && Bukkit.getOnlinePlayers().size() - 1 < ConfigManager.getRequiredPlayers()) {
            sendMessage(ChatColor.RED + "The game has ended as too many players have left.");
            reset();

        }
    }


    /* INFO */

    public GameState getState() { return state; }
    public Game getGame() { return game; }

    public void setState(GameState state) { this.state = state; }
    public HashMap<UUID, Kit> getKits() { return kits; }

    public void removeKit(UUID uuid) {
        if (kits.containsKey(uuid)) {
            kits.get(uuid).remove();
            kits.remove(uuid);
        }
    }

    public void setKit(UUID uuid, KitType type) {
        removeKit(uuid);
        if (type == KitType.BATMAN) {
            kits.put(uuid, new BatmanKit(minigame, uuid));
        } else if (type == KitType.SPIDERMAN) {
            kits.put(uuid, new SpidermanKit(minigame, uuid));
        } else if (type == KitType.MARIO) {
            kits.put(uuid, new MarioKit(minigame, uuid));
        } else if (type == KitType.NARUTO) {
            kits.put(uuid, new NarutoKit(minigame, uuid));
        } else if (type == KitType.GOKU) {
            kits.put(uuid, new GokuKit(minigame, uuid));
        } else if (type == KitType.YOSHI) {
            kits.put(uuid, new YoshiKit(minigame, uuid));
        } else if (type == KitType.SUPERMAN) {
            kits.put(uuid, new SupermanKit(minigame, uuid));
        } else if (type == KitType.HULK) {
            kits.put(uuid, new HulkKit(minigame, uuid));
        } else if (type == KitType.DARTHVADER) {
            kits.put(uuid, new DarthVaderKit(minigame, uuid));
        } else if (type == KitType.THOR) {
            kits.put(uuid, new ThorKit(minigame, uuid));
        } else if (type == KitType.LOKI) {
            kits.put(uuid, new LokiKit(minigame, uuid));
        } else if (type == KitType.SASUKE) {
            kits.put(uuid, new SasukeKit(minigame, uuid));
        } else if (type == KitType.FRIEZA) {
            kits.put(uuid, new FriezaKit(minigame, uuid));
        } else if (type == KitType.SPONGEBOB) {
            kits.put(uuid, new SpongebobKit(minigame, uuid));
        } else if (type == KitType.SQUIDWARD) {
            kits.put(uuid, new SquidwardKit(minigame, uuid));
        } else if (type == KitType.YODA) {
            kits.put(uuid, new YodaKit(minigame, uuid));
        }
    }

    public KitType getKitType(Player player) {
        return kits.containsKey(player.getUniqueId()) ? kits.get(player.getUniqueId()).getType() : null;
    }

}
