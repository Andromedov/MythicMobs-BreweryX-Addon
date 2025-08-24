package dev.jsinco.brewery;

import com.dre.brewery.api.addons.AddonInfo;
import com.dre.brewery.api.addons.BreweryAddon;

@AddonInfo(name = "MyAddon", version = "1.0", author = "Jonah")
public class MyAddon extends BreweryAddon {

    @Override
    public void onAddonPreEnable() {
        if (isFolia()) { // isPaper() is also available
            getAddonLogger().info("This addon is running on Folia.");
        } else {
            getAddonLogger().info("This addon is not running on Folia.");
        }
    }

    @Override
    public void onAddonEnable() {
        registerListener(new MyListeners());

        MyConfig config = getAddonConfigManager().getConfig(MyConfig.class);
        getAddonLogger().info(config.getMyString());

        registerCommand("mycommand", new MyCommand());
    }

    @Override
    public void onAddonDisable() {
        // Code which is run when the addon is disabled
    }

    @Override
    public void onBreweryReload() {
        // Code which is run when the `/breweryx reload` command is executed
        MyConfig config = getAddonConfigManager().getConfig(MyConfig.class);
        getAddonLogger().info(config.getMyString());
    }
}