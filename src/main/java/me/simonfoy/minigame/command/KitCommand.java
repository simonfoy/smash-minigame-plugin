package me.simonfoy.minigame.command;

import me.simonfoy.minigame.GameState;
import me.simonfoy.minigame.Minigame;
import me.simonfoy.minigame.instance.Arena;
import me.simonfoy.minigame.kit.KitUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitCommand implements CommandExecutor {

    private Minigame minigame;

    private Arena arena;

    public KitCommand(Minigame minigame, Arena arena) {
        this.minigame = minigame;
        this.arena = arena;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

                if (arena.getState() != GameState.LIVE) {
                    new KitUI(player);
                } else {
                    player.sendMessage(ChatColor.RED + "You cannot select a kit during a live game!");
                }
            }
        return false;
    }
}
