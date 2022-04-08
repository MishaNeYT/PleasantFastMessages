package ru.mishaneyt.fm.utils;

import org.bukkit.ChatColor;
import ru.mishaneyt.fm.Main;

public class UtilsManager {

    public static String getString(String msg) {
        return Main.getInstance().getConfig().getString(msg);
    }

    public static String getStringColor(String msg) {
        return ChatColor.translateAlternateColorCodes('&', getString(msg));
    }

    public static String getColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', "&f" + text);
    }
}