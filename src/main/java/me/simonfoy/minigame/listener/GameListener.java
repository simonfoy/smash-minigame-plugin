package me.simonfoy.minigame.listener;

import me.simonfoy.minigame.GameState;
import me.simonfoy.minigame.Minigame;
import me.simonfoy.minigame.instance.Arena;
import me.simonfoy.minigame.kit.KitType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class GameListener implements Listener {

    private Minigame minigame;

    public GameListener(Minigame minigame) {
        this.minigame = minigame;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().contains("Kit Selection") && e.getInventory() != null && e.getCurrentItem() != null) {
            e.setCancelled(true);

            KitType type = KitType.valueOf(e.getCurrentItem().getItemMeta().getLocalizedName());

            Arena arena = minigame.getArena();
            if (arena != null) {
                KitType activated = arena.getKitType(player);
                if (activated != null && activated == type) {
                    player.sendMessage(ChatColor.RED + "You already have this kit equipped!");
                } else {
                    player.sendMessage((ChatColor.GREEN + "You have equipped the " + ChatColor.GOLD + "" + ChatColor.BOLD + type.getDisplay() + ChatColor.GREEN + " kit!"));
                    arena.setKit(player.getUniqueId(), type);
                }

                player.closeInventory();
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();

            List<Location> usedLocations = new ArrayList<>();
            FileConfiguration config = this.minigame.getConfig();

            if (minigame.getArena().getState() == GameState.LIVE && player.getHealth() <= e.getFinalDamage()) {
                e.setCancelled(true);
                minigame.getArena().getGame().removeLife(player);
                player.setHealth(20);
                player.setInvulnerable(true);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 2, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 255, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1, false, false)); // Apply blindness effect to prevent movement


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

                Location finalLocation = location;
                Bukkit.getScheduler().runTaskLater(this.minigame, () -> {
                    usedLocations.remove(finalLocation);
                    player.setGameMode(GameMode.ADVENTURE);
                    player.setInvulnerable(false);
                    player.removePotionEffect(PotionEffectType.INVISIBILITY);
                    player.removePotionEffect(PotionEffectType.SLOW);
                    player.removePotionEffect(PotionEffectType.BLINDNESS);
                }, 5 * 20L); // 5 seconds in ticks
            }
        }
    }
}
