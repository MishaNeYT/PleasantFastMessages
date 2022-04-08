package ru.mishaneyt.fm.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.mishaneyt.fm.Main;
import ru.mishaneyt.fm.utils.UtilsConfig;

public class FmClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.getInventory().getTitle().equals(UtilsConfig.TITLE)) return;

        FileConfiguration config = Main.getInstance().getConfig();
        Player p = (Player) e.getWhoClicked();

        ItemStack is = e.getCurrentItem();
        ItemMeta im = is.getItemMeta();

        if (im == null) return;
        if (!is.hasItemMeta()) return;
        if (im.getDisplayName() == null) return;

        e.setCancelled(true);

        for (String name_item : config.getConfigurationSection("Items").getValues(false).keySet()) {
            ConfigurationSection section = config.getConfigurationSection("Items." + name_item);

            Material mat = Material.valueOf(section.getString("Material").toUpperCase());
            String name = section.getString("Name");
            String name_mat = ChatColor.translateAlternateColorCodes('&', name);

            String message = section.getString("Message");
            String message_click = ChatColor.translateAlternateColorCodes('&', message);

            if (im.getDisplayName().equals(name_mat) && is.getType().equals(mat)) {
                p.chat(message_click);
                p.closeInventory();
            }
        }
    }
}