package me.andromedov.mythicmobsbreweryx;

import com.dre.brewery.recipe.PluginItem;
import io.lumine.mythic.api.items.ItemManager;
import io.lumine.mythic.bukkit.MythicBukkit;
import org.bukkit.inventory.ItemStack;

public class MythicMobsPluginItem extends PluginItem {

    @Override
    public boolean matches(ItemStack itemStack) {
        if (!MythicMobsAddon.isUsingMythicMobs()) {
            return false;
        }

        try {
            ItemManager itemManager = MythicBukkit.inst().getItemManager();

            // Getting ID from configuration
            String configItemId = this.getItemId();
            if (configItemId == null) {
                return false;
            }

            // Check if ItemStack is a MythicMobs item
            if (!itemManager.isMythicItem(itemStack)) {
                return false;
            }

            // Get MythicType from the current ItemStack
            String currentMythicType = itemManager.getMythicTypeFromItem(itemStack);

            /* debug mode
            if (MythicMobsAddon.getLogger() != null) {
                MythicMobsAddon.getLogger().info("Checking MythicMobs item - Config ID: " + configItemId +
                        ", Current Type: " + currentMythicType + ", Match: " + configItemId.equals(currentMythicType));
            }
            */
            return configItemId.equals(currentMythicType);

        } catch (Exception e) {
            if (MythicMobsAddon.getLogger() != null) {
                MythicMobsAddon.getLogger().warning("Error checking MythicMobs item: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }
}