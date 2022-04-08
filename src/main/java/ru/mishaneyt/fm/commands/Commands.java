package ru.mishaneyt.fm.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.mishaneyt.fm.gui.FmItems;
import ru.mishaneyt.fm.utils.UtilsConfig;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        if (!sender.hasPermission(UtilsConfig.PERMISSION)) {
            sender.sendMessage(UtilsConfig.NO_PERM); return true;
        }

        Player p = (Player) sender;
        FmItems.onOpen(p);

        return false;
    }
}