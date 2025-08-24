package dev.jsinco.brewery;

import com.dre.brewery.BreweryPlugin;
import com.dre.brewery.api.addons.AddonCommand;
import com.dre.brewery.configuration.files.Lang;
import org.bukkit.command.CommandSender;

import java.util.List;

public class MyCommand implements AddonCommand {
    @Override
    public void execute(BreweryPlugin breweryPlugin, Lang lang, CommandSender sender, String label, String[] args) {
        sender.sendMessage("Hello, world!");
    }

    @Override
    public List<String> tabComplete(BreweryPlugin breweryPlugin, CommandSender sender, String label, String[] args) {
        return null;
    }

    @Override
    public String permission() {
        return "brewery.command.mycommand";
    }

    @Override
    public boolean playerOnly() {
        return false;
    }
}
