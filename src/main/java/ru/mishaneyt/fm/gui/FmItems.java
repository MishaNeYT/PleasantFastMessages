package ru.mishaneyt.fm.gui;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.mishaneyt.fm.Main;
import ru.mishaneyt.fm.utils.UtilsConfig;
import ru.mishaneyt.fm.utils.UtilsManager;

import java.util.List;

public class FmItems {
    static FileConfiguration config = Main.getInstance().getConfig();

    public static void onOpen(Player p) {
        Inventory i = Bukkit.createInventory(null, 45, UtilsConfig.TITLE);

        for (String name_item : config.getConfigurationSection("Items").getValues(false).keySet()) {
            ConfigurationSection section = config.getConfigurationSection("Items." + name_item);

            Material mat = Material.valueOf(section.getString("Material").toUpperCase());
            int data = section.getInt("Data");

            if (!section.isInt("Data")) return;

            ItemStack is = new ItemStack(mat, 1, (byte) data);
            ItemMeta im = is.getItemMeta();

            int slot = section.getInt("Slot");
            String name = section.getString("Name");

            List<String> lo = section.getStringList("Lore");
            String permission = section.getString("Permission");

            im.setDisplayName(ChatColor.translateAlternateColorCodes('&',  name));

            List<String> lore = Lists.newArrayList();
            for (String line : lo) lore.add(UtilsManager.getColor(line));

            im.setLore(lore);
            is.setItemMeta(im);

            if (p.hasPermission(permission)) {
                i.setItem(slot, is);
            } else i.setItem(slot, noPerms());
        }
        p.openInventory(i);
    }

    public static ItemStack noPerms() {
        ItemStack is = new ItemStack(Material.valueOf(UtilsConfig.MATERIAL), 1, (byte) UtilsConfig.DATA);
        ItemMeta im = is.getItemMeta();

        im.setDisplayName(UtilsConfig.NAME);

        List<String> lore = Lists.newArrayList();
        for (String line : config.getStringList("ItemNoPerms.Lore")) lore.add(UtilsManager.getColor(line));

        im.setLore(lore);
        is.setItemMeta(im);

        return is;
    }
}