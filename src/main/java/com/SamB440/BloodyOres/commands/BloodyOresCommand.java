package com.SamB440.BloodyOres.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.SamB440.BloodyOres.BloodyOres;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class BloodyOresCommand implements CommandExecutor {
	
	BloodyOres plugin;
	
	public BloodyOresCommand(BloodyOres plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender p, Command cmd, String commandLabel, String[] args)
	{
		if(args.length == 0)
		{
			TextComponent help = new TextComponent(ChatColor.YELLOW + "Showing help for BloodyOres " + ChatColor.WHITE + "1/1");
			help.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.WHITE + "Showing page 1/1 click to go to the next page or use /rr 2.").create()));
			//help.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/rr 2"));
			p.spigot().sendMessage(help);
			TextComponent c1 = new TextComponent(ChatColor.GREEN + "/BloodyOres");
			c1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.WHITE + "Click to paste command.").create()));
			c1.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/BloodyOres"));
			p.spigot().sendMessage(c1);
			p.sendMessage(ChatColor.WHITE + "   Aliases: /bo.");
			p.sendMessage(ChatColor.WHITE + "   Description: Displays help page.");
			TextComponent c2 = new TextComponent(ChatColor.GREEN + "/BloodyOres reload");
			c2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.WHITE + "Click to paste command.").create()));
			c2.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/BloodyOres reload"));
			p.spigot().sendMessage(c2);
			p.sendMessage(ChatColor.WHITE + "   Aliases: None.");
			p.sendMessage(ChatColor.WHITE + "   Description: Reload the plugin.");
			p.sendMessage(ChatColor.WHITE + "   Permission(s): OP");
			p.sendMessage(ChatColor.YELLOW + "© 2018 BloodyOres. Made with" + " ❤ " + "by SamB440.");
		} else if(args.length == 1) {
			
			if(args[0].equalsIgnoreCase("reload"))
			{
				p.sendMessage(ChatColor.GREEN + "Reloading...");
				plugin.reloadConfig();
				plugin.saveConfig();
				p.sendMessage(ChatColor.GREEN + "Done!");
			}
		} return true;
	}
}
