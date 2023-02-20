package me.simonfoy.minigame.kit;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum KitType {

    KNIGHT(ChatColor.GOLD + "Knight", Material.IRON_HELMET, "Knight Kit"),
    ASSASSIN(ChatColor.RED + "Assassin", Material.LEATHER_HELMET, "Assassin Kit"),
    MAGE(ChatColor.RED + "Mage", Material.GOLDEN_HELMET, "Mage Kit");

    private String display, description;
    private Material material;

    KitType(String display, Material material, String description) {
        this.display = display;
        this.material = material;
        this.description = description;
    }

    public String getDisplay() { return display; }
    public Material getMaterial() { return material; }
    public String getDescription() { return description; }

}
