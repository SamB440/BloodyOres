package com.SamB440.BloodyOres.listeners;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.SamB440.BloodyOres.BloodyOres;

public class BlockListener implements Listener {
	
	BloodyOres plugin;
	
	public BlockListener(BloodyOres plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent bbe)
	{
		Player p = bbe.getPlayer();
		Block b = bbe.getBlock();
		ArrayList<Material> types = new ArrayList<Material>();
		for(String s : getConfig().getStringList("Server.Ores.Enabled"))
		{
			types.add(Material.valueOf(s));
		}
		if(types.contains(b.getType()))
		{
			p.damage(getConfig().getDouble("Server.Ores." + b.getType().toString()) * 2);
		} else return;
	}
	
	private FileConfiguration getConfig()
	{
		return plugin.getConfig();
	}
}
