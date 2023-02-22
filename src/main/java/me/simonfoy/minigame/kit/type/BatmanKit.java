package me.simonfoy.minigame.kit.type;

import com.mojang.authlib.GameProfile;
import me.simonfoy.minigame.Minigame;
import me.simonfoy.minigame.kit.Kit;
import me.simonfoy.minigame.kit.KitType;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BatmanKit extends Kit {


    public BatmanKit(Minigame minigame, UUID uuid) {
        super(minigame, KitType.BATMAN, uuid);
    }

    @Override
    public void onStart(Player player) {
        ItemStack batmanHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) batmanHead.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new com.mojang.authlib.properties.Property("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmY0NzkzNWZlZTExZTVjMGU1ZDI2ZTNkZjA1OGNiZjA2MzRiNDMwMWYyMGVkZDA2YThkYTU2OTc1NjM5YTY2In19fQ=="));

        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        batmanHead.setItemMeta(meta);

// Set the helmet slot to the player's head
        player.getInventory().setHelmet(batmanHead);

        ItemStack batarang = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta batarangMeta = batarang.getItemMeta();
        batarangMeta.setDisplayName(ChatColor.GREEN + "BATARANG " + ChatColor.GRAY + "- " + ChatColor.GREEN + "Right Click");

// Add the ability information to the item's lore
        List<String> batarangLore = new ArrayList<>();
        batarangLore.add("");
        batarangLore.add(ChatColor.GREEN + "Right Click " + ChatColor.GRAY + "to throw a");
        batarangLore.add(ChatColor.GRAY + "batarang that deals damage");
        batarangLore.add(ChatColor.GRAY + "to an enemy and");
        batarangLore.add(ChatColor.GRAY + "temporarily stuns them.");
        batarangMeta.setLore(batarangLore);

        batarang.setItemMeta(batarangMeta);
        player.getInventory().setItem(0, batarang);

        ItemStack grapplinghook = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta grapplinghookMeta = grapplinghook.getItemMeta();
        grapplinghookMeta.setDisplayName(ChatColor.GREEN + "GRAPPLING HOOK " + ChatColor.GRAY + "- " + ChatColor.GREEN + "[2]");

// Add the ability information to the item's lore
        List<String> grapplinghookLore = new ArrayList<>();
        grapplinghookLore.add("");
        grapplinghookLore.add(ChatColor.GRAY + "Press " + ChatColor.GREEN + "[2] " + ChatColor.GRAY + "to quickly travel");
        grapplinghookLore.add(ChatColor.GRAY + "short distances or pull");
        grapplinghookLore.add(ChatColor.GRAY + "enemies towards you.");
        grapplinghookMeta.setLore(grapplinghookLore);

        grapplinghook.setItemMeta(grapplinghookMeta);
        player.getInventory().setItem(1, grapplinghook);

        ItemStack smokebomb = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta smokebombMeta = smokebomb.getItemMeta();
        smokebombMeta.setDisplayName(ChatColor.GREEN + "SMOKE BOMB " + ChatColor.GRAY + "- " + ChatColor.GREEN + "[3]");

// Add the ability information to the item's lore
        List<String> smokebombLore = new ArrayList<>();
        smokebombLore.add("");
        smokebombLore.add(ChatColor.GRAY + "Press " + ChatColor.GREEN + "[3] " + ChatColor.GRAY + "to throw a smoke bomb");
        smokebombLore.add(ChatColor.GRAY + "that obscures the vision of");
        smokebombLore.add(ChatColor.GRAY + "nearby enemies, making it");
        smokebombLore.add(ChatColor.GRAY + "harder for them to hit you.");
        smokebombMeta.setLore(smokebombLore);

        smokebomb.setItemMeta(smokebombMeta);
        player.getInventory().setItem(2, smokebomb);

        ItemStack batmobile = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta batmobileMeta = batmobile.getItemMeta();
        batmobileMeta.setDisplayName(ChatColor.GREEN + "BATMOBILE " + ChatColor.GRAY + "- " + ChatColor.GREEN + "[4]");

// Add the ability information to the item's lore
        List<String> batmobileLore = new ArrayList<>();
        batmobileLore.add(ChatColor.GRAY + "Ultimate");
        batmobileLore.add("");
        batmobileLore.add(ChatColor.GRAY + "Press " + ChatColor.GREEN + "[4] " + ChatColor.GRAY + "to summon the Batmobile,");
        batmobileLore.add(ChatColor.GRAY + "which you can drive around the");
        batmobileLore.add(ChatColor.GRAY + "arena, dealing damage to");
        batmobileLore.add(ChatColor.GRAY + "any enemies in your way.");
        batmobileMeta.setLore(batmobileLore);

        batmobile.setItemMeta(batmobileMeta);
        player.getInventory().setItem(3, batmobile);

        ItemStack stealthmode = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta stealthmodeMeta = stealthmode.getItemMeta();
        stealthmodeMeta.setDisplayName(ChatColor.GREEN + "STEALTH MODE");

// Add the ability information to the item's lore
        List<String> stealthmodeLore = new ArrayList<>();
        stealthmodeLore.add(ChatColor.GRAY + "Passive");
        stealthmodeLore.add("");
        stealthmodeLore.add(ChatColor.GRAY + "You can sneak without making");
        stealthmodeLore.add(ChatColor.GRAY + "any noise or particles,");
        stealthmodeLore.add(ChatColor.GRAY + "making you harder to detect.");
        stealthmodeMeta.setLore(stealthmodeLore);

        stealthmode.setItemMeta(stealthmodeMeta);
        player.getInventory().setItem(8, stealthmode);
    }


}

