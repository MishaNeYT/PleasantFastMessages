package ru.mishaneyt.fm;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.mishaneyt.fm.commands.Commands;
import ru.mishaneyt.fm.gui.FmClick;
import ru.mishaneyt.fm.utils.UtilsConfig;

import java.io.File;

public class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        File config = new File(getDataFolder(), "config.yml");
        if (!config.exists()) this.saveDefaultConfig();

        UtilsConfig.onLoad();

        Bukkit.getPluginManager().registerEvents(new FmClick(), this);
        getCommand("fm").setExecutor(new Commands());

        getLogger().info("");
        getLogger().info("§e FM LC - плагин успешно включен!");
        getLogger().info("§e Спасибо, что скачали! С любовью, PleasantVKChannel.");
        getLogger().info("");
    }

    public static Main getInstance() {
        return instance;
    }
}