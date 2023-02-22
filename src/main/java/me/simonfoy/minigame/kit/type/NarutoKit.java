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
        ItemStack shadowclonejutsu = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta shadowclonejutsuMeta = shadowclonejutsu.getItemMeta();
        shadowclonejutsuMeta.setDisplayName(ChatColor.GREEN + "SHADOW CLONE JUTSU " + ChatColor.GRAY + "- " + ChatColor.GREEN + "Right Click");

// Add the ability information to the item's lore
        List<String> shadowclonejutsuLore = new ArrayList<>();
        shadowclonejutsuLore.add("");
        shadowclonejutsuLore.add(ChatColor.GREEN + "Right Click " + ChatColor.GRAY + "to create a");
        shadowclonejutsuLore.add(ChatColor.GRAY + "clone of yourself that");
        shadowclonejutsuLore.add(ChatColor.GRAY + "attacks nearby enemies. The");
        shadowclonejutsuLore.add(ChatColor.GRAY + "clone disappears after a short");
        shadowclonejutsuLore.add(ChatColor.GRAY + "period of time.");
        shadowclonejutsuMeta.setLore(shadowclonejutsuLore);

        shadowclonejutsu.setItemMeta(shadowclonejutsuMeta);
        player.getInventory().setItem(0, shadowclonejutsu);

// Give the player a diamond in slot 2 named "Rasengan"
        ItemStack rasengan = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta rasenganMeta = rasengan.getItemMeta();
        rasenganMeta.setDisplayName(ChatColor.GREEN + "RASENGAN " + ChatColor.GRAY + "- " + ChatColor.GREEN + "[2]");

// Add the ability information to the item's lore
        List<String> rasenganLore = new ArrayList<>();
        rasenganLore.add("");
        rasenganLore.add(ChatColor.GRAY + "Press " + ChatColor.GREEN + "[2] " + ChatColor.GRAY + "to charge up");
        rasenganLore.add(ChatColor.GRAY + "and then launch a powerful");
        rasenganLore.add(ChatColor.GRAY + "ball of chakra that explodes on");
        rasenganLore.add(ChatColor.GRAY + "impact, dealing heavy damage");
        rasenganLore.add(ChatColor.GRAY + "to enemies in the area.");
        rasenganMeta.setLore(rasenganLore);

        rasengan.setItemMeta(rasenganMeta);
        player.getInventory().setItem(1, rasengan);

// Give the player a Nether Star in slot 3 named "Uzumaki Barrage"
        ItemStack uzumakibarrage = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta uzumakibarrageMeta = uzumakibarrage.getItemMeta();
        uzumakibarrageMeta.setDisplayName(ChatColor.GREEN + "UZUMAKI BARRAGE " + ChatColor.GRAY + "- " + ChatColor.GREEN + "[3]");

// Add the ability information to the item's lore
        List<String> uzumakibarrageLore = new ArrayList<>();
        uzumakibarrageLore.add("");
        uzumakibarrageLore.add(ChatColor.GRAY + "Press " + ChatColor.GREEN + "[3] " + ChatColor.GRAY + "to unleash a flurry of");
        uzumakibarrageLore.add(ChatColor.GRAY + "punches and kicks, dealing");
        uzumakibarrageLore.add(ChatColor.GRAY + "damage to all enemies within");
        uzumakibarrageLore.add(ChatColor.GRAY + "a short range.");
        uzumakibarrageMeta.setLore(uzumakibarrageLore);

        uzumakibarrage.setItemMeta(uzumakibarrageMeta);
        player.getInventory().setItem(2, uzumakibarrage);

// Give the player Blaze Powder in slot 4 named "Nine-Tails Chakra Mode"
        ItemStack ninetailschakramode = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta ninetailschakramodeMeta = ninetailschakramode.getItemMeta();
        ninetailschakramodeMeta.setDisplayName(ChatColor.GREEN + "NINE-TAILS CHAKRA MODE " + ChatColor.GRAY + "- " + ChatColor.GREEN + "[4]");

// Add the ability information to the item's lore
        List<String> ninetailschakramodeLore = new ArrayList<>();
        ninetailschakramodeLore.add(ChatColor.GRAY + "Ultimate");
        ninetailschakramodeLore.add("");
        ninetailschakramodeLore.add(ChatColor.GRAY + "Press " + ChatColor.GREEN + "[4] " + ChatColor.GRAY + "to transform into");
        ninetailschakramodeLore.add(ChatColor.GRAY + "Nine-Tails Chakra Mode,");
        ninetailschakramodeLore.add(ChatColor.GRAY + "increasing your speed and strength.");
        ninetailschakramodeLore.add(ChatColor.GRAY + "You gain temporary invincibility");
        ninetailschakramodeLore.add(ChatColor.GRAY + "and deal massive damage to enemies.");
        ninetailschakramodeMeta.setLore(ninetailschakramodeLore);

        ninetailschakramode.setItemMeta(ninetailschakramodeMeta);
        player.getInventory().setItem(3, ninetailschakramode);

// Give the player a light blue dye in slot 9 named "Chakra Regeneration"
        ItemStack chakraregeneration = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta chakraregenerationMeta = chakraregeneration.getItemMeta();
        chakraregenerationMeta.setDisplayName(ChatColor.GREEN + "CHAKRA REGENERATION");

// Add the ability information to the item's lore
        List<String> chakraregenerationLore = new ArrayList<>();
        chakraregenerationLore.add(ChatColor.GRAY + "Passive");
        chakraregenerationLore.add("");
        chakraregenerationLore.add(ChatColor.GRAY + "Regenerates chakra over time,");
        chakraregenerationLore.add(ChatColor.GRAY + "allowing you to use your");
        chakraregenerationLore.add(ChatColor.GRAY + "abilities more frequently.");
        chakraregenerationMeta.setLore(chakraregenerationLore);

        chakraregeneration.setItemMeta(chakraregenerationMeta);
        player.getInventory().setItem(8, chakraregeneration);
    }


}
