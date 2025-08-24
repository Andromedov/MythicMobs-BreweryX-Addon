package me.andromedov.mythicmobsbreweryx;

import com.dre.brewery.api.addons.AddonInfo;
import com.dre.brewery.api.addons.AddonLogger;
import com.dre.brewery.api.addons.BreweryAddon;
import com.dre.brewery.recipe.PluginItem;
import org.bukkit.Bukkit;

@AddonInfo(name = "MythicMobsBreweryXAddon", version = "1.0", author = "Andromedov")
public class MythicMobsAddon extends BreweryAddon {
    private static AddonLogger logger;
    private static boolean useMythicMobs = false;

    public MythicMobsAddon() {
        super();
    }

    @Override
    public void onAddonPreEnable() {
        // Перевірка наявності MythicMobs на ранній стадії
        useMythicMobs = Bukkit.getPluginManager().getPlugin("MythicMobs") != null;
        logger = getAddonLogger();

        if (useMythicMobs) {
            try {
                PluginItem.registerForConfig("mythic", MythicMobsPluginItem::new);
                logger.info("MythicMobs support enabled!");
                logger.info("Registered 'mythic' prefix for PluginItem");
            } catch (Exception e) {
                logger.severe("Failed to register MythicMobs PluginItem: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            logger.warning("MythicMobs not found! Support disabled.");
        }
    }

    @Override
    public void onAddonEnable() {
    }

    public static boolean isUsingMythicMobs() {
        return useMythicMobs;
    }

    public static AddonLogger getLogger() {
        return logger;
    }
}