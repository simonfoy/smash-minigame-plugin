package me.simonfoy.minigame.kit.type;

import com.mojang.authlib.GameProfile;
import me.simonfoy.minigame.Minigame;
import me.simonfoy.minigame.kit.Kit;
import me.simonfoy.minigame.kit.KitType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DarthVaderKit extends Kit {


    public DarthVaderKit(Minigame minigame, UUID uuid) {
        super(minigame, KitType.DARTHVADER, uuid);
    }

    @Override
    public void onStart(Player player) {
        ItemStack darthVaderHead = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) darthVaderHead.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new com.mojang.authlib.properties.Property("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTkwMDA1ZDdhNDIwMTZiMTc0MWYyZTk0YWE0OWZjOGQzZmVjMTcyYjAwNjgzZWMzOGZlNWJhMWE4MzgzZTg0MSJ9fX0="));

        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        darthVaderHead.setItemMeta(meta);

// Set the helmet slot to the player's head
        player.getInventory().setHelmet(darthVaderHead);

        ItemStack forcechoke = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta forcechokeMeta = forcechoke.getItemMeta();
        forcechokeMeta.setDisplayName(ChatColor.GREEN + "FORCE CHOKE " + ChatColor.GRAY + "- " + ChatColor.GREEN + "Right Click");

// Add the ability information to the item's lore
        List<String> forcechokeLore = new ArrayList<>();
        forcechokeLore.add("");
        forcechokeLore.add(ChatColor.GREEN + "Right Click " + ChatColor.GRAY + "to choke a");
        forcechokeLore.add(ChatColor.GRAY + "nearby player, dealing damage");
        forcechokeLore.add(ChatColor.GRAY + "and stunning them");
        forcechokeLore.add(ChatColor.GRAY + "for a short duration.");
        forcechokeMeta.setLore(forcechokeLore);

        forcechoke.setItemMeta(forcechokeMeta);
        player.getInventory().setItem(0, forcechoke);

        ItemStack lightsaberthrow = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta lightsaberthrowMeta = lightsaberthrow.getItemMeta();
        lightsaberthrowMeta.setDisplayName(ChatColor.GREEN + "LIGHTSABER THROW " + ChatColor.GRAY + "- " + ChatColor.GREEN + "[2]");

// Add the ability information to the item's lore
        List<String> lightsaberthrowLore = new ArrayList<>();
        lightsaberthrowLore.add("");
        lightsaberthrowLore.add(ChatColor.GRAY + "Press " + ChatColor.GREEN + "[2] " + ChatColor.GRAY + "to throw your");
        lightsaberthrowLore.add(ChatColor.GRAY + "lightsaber, dealing damage");
        lightsaberthrowLore.add(ChatColor.GRAY + "to enemies in its path and");
        lightsaberthrowLore.add(ChatColor.GRAY + "returning to you after a short delay.");
        lightsaberthrowMeta.setLore(lightsaberthrowLore);

        lightsaberthrow.setItemMeta(lightsaberthrowMeta);
        player.getInventory().setItem(1, lightsaberthrow);

        ItemStack forcepush = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta forcepushMeta = forcepush.getItemMeta();
        forcepushMeta.setDisplayName(ChatColor.GREEN + "FORCE PUSH " + ChatColor.GRAY + "- " + ChatColor.GREEN + "[3]");

// Add the ability information to the item's lore
        List<String> forcepushLore = new ArrayList<>();
        forcepushLore.add("");
        forcepushLore.add(ChatColor.GRAY + "Press " + ChatColor.GREEN + "[3] " + ChatColor.GRAY + "to push all nearby");
        forcepushLore.add(ChatColor.GRAY + "players away from you,");
        forcepushLore.add(ChatColor.GRAY + "dealing damage and");
        forcepushLore.add(ChatColor.GRAY + "knocking them back.");
        forcepushMeta.setLore(forcepushLore);

        forcepush.setItemMeta(forcepushMeta);
        player.getInventory().setItem(2, forcepush);

        ItemStack forcecrush = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta forcecrushMeta = forcecrush.getItemMeta();
        forcecrushMeta.setDisplayName(ChatColor.GREEN + "FORCE CRUSH " + ChatColor.GRAY + "- " + ChatColor.GREEN + "[4]");

// Add the ability information to the item's lore
        List<String> forcecrushLore = new ArrayList<>();
        forcecrushLore.add(ChatColor.GRAY + "Ultimate");
        forcecrushLore.add("");
        forcecrushLore.add(ChatColor.GRAY + "Press " + ChatColor.GREEN + "[4] " + ChatColor.GRAY + "to crush all nearby");
        forcecrushLore.add(ChatColor.GRAY + "players, throwing them to");
        forcecrushLore.add(ChatColor.GRAY + "the ground instantly,");
        forcecrushLore.add(ChatColor.GRAY + "dealing massive damage.");
        forcecrushMeta.setLore(forcecrushLore);

        forcecrush.setItemMeta(forcecrushMeta);
        player.getInventory().setItem(3, forcecrush);

        ItemStack intimidatingpresence = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta intimidatingpresenceMeta = intimidatingpresence.getItemMeta();
        intimidatingpresenceMeta.setDisplayName(ChatColor.GREEN + "INTIMIDATING PRESENCE");

// Add the ability information to the item's lore
        List<String> intimidatingpresenceLore = new ArrayList<>();
        intimidatingpresenceLore.add(ChatColor.GRAY + "Passive");
        intimidatingpresenceLore.add("");
        intimidatingpresenceLore.add(ChatColor.GRAY + "Players within a certain radius");
        intimidatingpresenceLore.add(ChatColor.GRAY + "of you receive a debuff that reduces");
        intimidatingpresenceLore.add(ChatColor.GRAY + "their damage output and slows them down.");
        intimidatingpresenceMeta.setLore(intimidatingpresenceLore);

        intimidatingpresence.setItemMeta(intimidatingpresenceMeta);
        player.getInventory().setItem(8, intimidatingpresence);
    }


}

