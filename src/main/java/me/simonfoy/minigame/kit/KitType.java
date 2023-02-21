package me.simonfoy.minigame.kit;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum KitType {

    BATMAN(ChatColor.GOLD + "Batman", Material.IRON_HELMET, "Batman Kit"),
    SPIDERMAN(ChatColor.RED + "Spiderman", Material.LEATHER_HELMET, "Spiderman Kit"),
    MARIO(ChatColor.RED + "Mario", Material.GOLDEN_HELMET, "Mario Kit"),
    NARUTO(ChatColor.RED + "Naruto", Material.GOLDEN_HELMET, "Naruto Kit"),
    GOKU(ChatColor.RED + "Goku", Material.GOLDEN_HELMET, "Goku Kit"),
    YOSHI(ChatColor.RED + "Yoshi", Material.GOLDEN_HELMET, "Yoshi Kit"),
    SUPERMAN(ChatColor.GOLD + "Superman", Material.IRON_HELMET, "Superman Kit"),
    HULK(ChatColor.RED + "Hulk", Material.LEATHER_HELMET, "Hulk Kit"),
    DARTHVADER(ChatColor.RED + "Darth Vader", Material.GOLDEN_HELMET, "Darth Vader"),
    THOR(ChatColor.RED + "Thor", Material.GOLDEN_HELMET, "Thor Vader"),
    LOKI(ChatColor.RED + "Loki", Material.GOLDEN_HELMET, "Loki Kit"),
    SASUKE(ChatColor.RED + "Sasuke", Material.GOLDEN_HELMET, "Sasuke Kit"),
    FRIEZA(ChatColor.GOLD + "Frieza", Material.IRON_HELMET, "Frieza Kit"),
    SPONGEBOB(ChatColor.RED + "Spongebob", Material.LEATHER_HELMET, "Spongebob Kit"),
    SQUIDWARD(ChatColor.RED + "Squidward", Material.GOLDEN_HELMET, "Squidward Kit"),
    YODA(ChatColor.RED + "Yoda", Material.GOLDEN_HELMET, "Yoda Kit");

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
