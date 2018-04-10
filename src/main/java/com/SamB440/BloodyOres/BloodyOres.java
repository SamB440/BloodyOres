package com.SamB440.BloodyOres;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.SamB440.BloodyOres.commands.BloodyOresCommand;
import com.SamB440.BloodyOres.listeners.BlockListener;

public class BloodyOres extends JavaPlugin {
	
	Logger log = Bukkit.getLogger();

	@Override
	public void onEnable()
	{
		registerListeners();
		registerCommands();
		getConfig().options().copyDefaults(true);
		createConfig();
	}
	
	private void registerListeners()
	{
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BlockListener(this), this);
	}
	private void registerCommands()
	{
		getCommand("bloodyores").setExecutor(new BloodyOresCommand(this));
	}
	private void createConfig()
	{
		String header;
		String eol = System.getProperty("line.separator");
		header = "BloodyOres Properties:" + eol;
		header += eol;
		header += "List of valid materials:" + eol;
		header += "  https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html" + eol;
		header += eol;
		getConfig().options().header(header);
		List<String> types = Arrays.asList("DIAMOND_ORE", "IRON_ORE", "COAL_ORE", "REDSTONE_ORE", "GOLD_ORE", "LAPIS_ORE", "EMERALD_ORE");
		getConfig().addDefault("Server.Ores.Enabled", types);
		for(String s : types)
		{
			getConfig().addDefault("Server.Ores." + s, 1);
		}
		saveConfig();
	}
}
