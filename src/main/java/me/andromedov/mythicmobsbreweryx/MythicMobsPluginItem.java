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

            // Отримуємо ID з конфігурації
            String configItemId = this.getItemId();
            if (configItemId == null) {
                return false;
            }

            // Перевіряємо, чи є ItemStack предметом MythicMobs
            if (!itemManager.isMythicItem(itemStack)) {
                return false;
            }

            // Отримуємо MythicType з поточного ItemStack
            String currentMythicType = itemManager.getMythicTypeFromItem(itemStack);

            // Додаємо детальне логування
            if (MythicMobsAddon.getLogger() != null) {
                MythicMobsAddon.getLogger().info("Checking MythicMobs item - Config ID: " + configItemId +
                        ", Current Type: " + currentMythicType + ", Match: " + configItemId.equals(currentMythicType));
            }

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