package me.markiscool.hopperblocker;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class HopperCraftListener implements Listener {

    private HopperBlockerPlugin plugin;

    /**
     * Obtains Main Plugin instance
     * @param plugin Main plugin instance
     */
    public HopperCraftListener(HopperBlockerPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Checks for Hopper Material, uses XMaterial for version compatability
     * Also checks for user permission, "hopperblocker.craft"
     * @param event CraftItemEvent argument given by server
     */
    @EventHandler
    public void onHopperCraft(CraftItemEvent event) {
        ItemStack item = event.getCurrentItem();
        Material material = item.getType();
        if(material.equals(XMaterial.HOPPER.parseMaterial())) {
            if(event.getWhoClicked() instanceof Player) {
                Player player = (Player) event.getWhoClicked();
                if(!player.hasPermission(plugin.getPermission())) {
                    event.setCancelled(true);
                    player.sendMessage(HopperBlockerPlugin.colourize("&cYou cannot craft this."));
                    player.closeInventory();
                }
            }
        }
    }

}
