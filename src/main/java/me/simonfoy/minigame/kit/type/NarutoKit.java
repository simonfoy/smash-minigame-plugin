package me.simonfoy.minigame.kit.type;

import com.google.j2objc.annotations.Property;
import com.mojang.authlib.GameProfile;
import me.simonfoy.minigame.Minigame;
import me.simonfoy.minigame.kit.Kit;
import me.simonfoy.minigame.kit.KitType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NarutoKit extends Kit {
    public NarutoKit(Minigame minigame, UUID uuid) {
        super(minigame, KitType.NARUTO, uuid);
    }

    @Override
    public void onStart(Player player) {
        ItemStack narutoHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) narutoHead.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new com.mojang.authlib.properties.Property("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTcyOTc4ZjI1YjZmM2MzMGI0YzM2OTQ3OGUxMWVjMmIxZTlmMjE1MjcyNzcxNTlmZjc2NTg2YTQ2ZDIwNTI4NCJ9fX0="));

        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        narutoHead.setItemMeta(meta);

// Set the helmet slot to the player's head
        player.getInventory().setHelmet(narutoHead);

// Give the player a feather in slot 1 named "Shadow Clone Jutsu"
        ItemStack feather = new ItemStack(Material.FEATHER, 1);
        ItemMeta featherMeta = feather.getItemMeta();
        featherMeta.setDisplayName(ChatColor.GOLD + "SHADOW CLONE JUTSU! " + ChatColor.GRAY + "- " + ChatColor.GOLD + "Right Click");

// Add the ability information to the item's lore
        List<String> featherLore = new ArrayList<>();
        featherLore.add("");
        featherLore.add(ChatColor.GOLD + "Right Click " + ChatColor.GRAY + "to create a");
        featherLore.add(ChatColor.GRAY + "clone of yourself that");
        featherLore.add(ChatColor.GRAY + "attacks nearby enemies. The");
        featherLore.add(ChatColor.GRAY + "clone disappears after a short");
        featherLore.add(ChatColor.GRAY + "period of time.");
        featherMeta.setLore(featherLore);

        feather.setItemMeta(featherMeta);
        player.getInventory().setItem(0, feather);

// Give the player a diamond in slot 2 named "Rasengan"
        ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
        ItemMeta diamondMeta = diamond.getItemMeta();
        diamondMeta.setDisplayName(ChatColor.GOLD + "RASENGAN! " + ChatColor.GRAY + "- " + ChatColor.GOLD + "[2]");

// Add the ability information to the item's lore
        List<String> diamondLore = new ArrayList<>();
        diamondLore.add("");
        diamondLore.add(ChatColor.GRAY + "Press " + ChatColor.GOLD + "[2] " + ChatColor.GRAY + "to charge up");
        diamondLore.add(ChatColor.GRAY + "and then launch a powerful");
        diamondLore.add(ChatColor.GRAY + "ball of chakra that explodes on");
        diamondLore.add(ChatColor.GRAY + "impact, dealing heavy damage");
        diamondLore.add(ChatColor.GRAY + "to enemies in the area.");
        diamondMeta.setLore(diamondLore);

        diamond.setItemMeta(diamondMeta);
        player.getInventory().setItem(1, diamond);

// Give the player a Nether Star in slot 3 named "Uzumaki Barrage"
        ItemStack netherStar = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta netherStarMeta = netherStar.getItemMeta();
        netherStarMeta.setDisplayName(ChatColor.GOLD + "UZUMAKI BARRAGE! " + ChatColor.GRAY + "- " + ChatColor.GOLD + "[3]");

// Add the ability information to the item's lore
        List<String> netherStarLore = new ArrayList<>();
        netherStarLore.add("");
        netherStarLore.add(ChatColor.GRAY + "Press " + ChatColor.GOLD + "[3] " + ChatColor.GRAY + "to unleash a flurry of");
        netherStarLore.add(ChatColor.GRAY + "punches and kicks, dealing");
        netherStarLore.add(ChatColor.GRAY + "damage to all enemies within");
        netherStarLore.add(ChatColor.GRAY + "a short range.");
        netherStarMeta.setLore(netherStarLore);

        netherStar.setItemMeta(netherStarMeta);
        player.getInventory().setItem(2, netherStar);

// Give the player Blaze Powder in slot 4 named "Nine-Tails Chakra Mode"
        ItemStack blazePowder = new ItemStack(Material.BLAZE_POWDER, 1);
        ItemMeta blazeMeta = blazePowder.getItemMeta();
        blazeMeta.setDisplayName(ChatColor.RED + "NINE-TAILS CHAKRA MODE! " + ChatColor.GRAY + "- " + ChatColor.RED + "[4]");

// Add the ability information to the item's lore
        List<String> blazeLore = new ArrayList<>();
        blazeLore.add("");
        blazeLore.add(ChatColor.GRAY + "Press " + ChatColor.RED + "[4] " + ChatColor.GRAY + "to transform into");
        blazeLore.add(ChatColor.GRAY + "Nine-Tails Chakra Mode,");
        blazeLore.add(ChatColor.GRAY + "increasing your speed and strength.");
        blazeLore.add(ChatColor.GRAY + "You gain temporary invincibility");
        blazeLore.add(ChatColor.GRAY + "and deal massive damage to enemies.");
        blazeMeta.setLore(blazeLore);

        blazePowder.setItemMeta(blazeMeta);
        player.getInventory().setItem(3, blazePowder);

// Give the player a light blue dye in slot 9 named "Chakra Regeneration"
        ItemStack lightBlueDye = new ItemStack(Material.LIGHT_BLUE_DYE, 1);
        ItemMeta lightBlueDyeMeta = lightBlueDye.getItemMeta();
        lightBlueDyeMeta.setDisplayName(ChatColor.GOLD + "CHAKRA REGENERATION!");

// Add the ability information to the item's lore
        List<String> lightBlueDyeLore = new ArrayList<>();
        lightBlueDyeLore.add(ChatColor.GRAY + "Passive");
        lightBlueDyeLore.add("");
        lightBlueDyeLore.add(ChatColor.GRAY + "Regenerates chakra over time,");
        lightBlueDyeLore.add(ChatColor.GRAY + "allowing you to use your");
        lightBlueDyeLore.add(ChatColor.GRAY + "abilities more frequently.");
        lightBlueDyeMeta.setLore(lightBlueDyeLore);

        lightBlueDye.setItemMeta(lightBlueDyeMeta);
        player.getInventory().setItem(8, lightBlueDye);
    }


}
