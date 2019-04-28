package me.markiscool.hopperblocker;

import org.bukkit.ChatColor;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Disables players from crafting hoppers, unless otherwise given permission "hopperblocker.craft"
 */
public class HopperBlockerPlugin extends JavaPlugin {

    private Permission craft;

    /**
     * Runs when server is enabled
     */
    @Override
    public void onEnable() {
        craft = new Permission("hopperblocker.craft");
        craft.setDefault(PermissionDefault.OP);
        getServer().getPluginManager().registerEvents(new HopperCraftListener(this), this);
        new Metrics(this);
    }

    /**
     * @return the main permission, access to craft hoppers
     */
    public Permission getPermission() {
        return craft;
    }

    /**
     * Colourizes a message, using &
     * @param message String text to colourize
     * @return colourized String
     */
    public static String colourize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
