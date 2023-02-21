package me.simonfoy.minigame.kit.type;

import com.mojang.authlib.GameProfile;
import me.simonfoy.minigame.Minigame;
import me.simonfoy.minigame.kit.Kit;
import me.simonfoy.minigame.kit.KitType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
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
    }


}

