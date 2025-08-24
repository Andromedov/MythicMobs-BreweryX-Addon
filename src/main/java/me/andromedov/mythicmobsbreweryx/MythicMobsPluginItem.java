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

            // Перевіряємо, чи є ItemStack предметом MythicMobs
            if (!itemManager.isMythicItem(itemStack)) {
                return false;
            }

            // Отримуємо ID з конфігурації
            String configItemId = this.getItemId();
            if (configItemId == null) {
                return false;
            }

            // Створюємо еталонний ItemStack для порівняння
            return itemManager.getItem(configItemId)
                    .map(mythicItem -> {
                        // Конвертуємо AbstractItemStack у Bukkit ItemStack
                        ItemStack referenceItem = (ItemStack) mythicItem.generateItemStack(itemStack.getAmount());
                        return referenceItem != null && referenceItem.isSimilar(itemStack);
                    })
                    .orElse(false);

        } catch (Exception e) {
            if (MythicMobsAddon.getLogger() != null) {
                MythicMobsAddon.getLogger().warning("Error checking MythicMobs item: " + e.getMessage());
            }
            return false;
        }
    }
}