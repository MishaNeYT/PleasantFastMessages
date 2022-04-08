package ru.mishaneyt.fm.utils;

import ru.mishaneyt.fm.Main;

public class UtilsConfig {
    public static String TITLE;
    public static String PERMISSION;
    public static String NO_PERM;

    public static String MATERIAL;
    public static int DATA;
    public static String NAME;

    public static void onLoad() {
        TITLE = UtilsManager.getStringColor("Settings.Title");
        PERMISSION = UtilsManager.getString("Settings.Permission");
        NO_PERM = UtilsManager.getStringColor("Messages.NoPerm");

        MATERIAL = UtilsManager.getString("ItemNoPerms.Material");
        DATA  = Main.getInstance().getConfig().getInt("ItemNoPerms.Data");
        NAME = UtilsManager.getStringColor("ItemNoPerms.Name");
    }
}