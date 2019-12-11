package me.franco28.Franco28;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	private kill pluginkill = new kill();
	
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Franco28 Admin Plugins cargado con exito!");
        getCommand(pluginkill.cmd1).setExecutor(pluginkill);
        getCommand(pluginkill.cmd2).setExecutor(pluginkill);
        getCommand(pluginkill.cmd3).setExecutor(pluginkill);
        getCommand(pluginkill.cmd4).setExecutor(pluginkill);
    }

    public void onDisable() {
    	getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Franco28 Admin Plugins desactivado!");
    }
    
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

}
