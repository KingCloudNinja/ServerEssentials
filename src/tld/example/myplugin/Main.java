package tld.example.myplugin;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener {

	private String broadcastMessage;




	public void onEnable() {
    	Bukkit.getPluginManager().registerEvents ((Listener) this, this);
    	loadConfiguration();
	}
	
	public void loadConfiguration(){
	     String path = "Config.ServerName";	
	     getConfig().addDefault(path, "Servername");
	     getConfig().options().copyDefaults(true);
	     saveConfig();
	     getConfig().getString("Config.Servername");
	}	
	
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		player.setPlayerListName(player.getDisplayName());
	}
	
	
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    
    	Player player = (Player) sender;
    	this.getConfig();
    	
    	FileConfiguration config = this.getConfig();
    	config.addDefault("servername", true);
    	config.addDefault("discord", true);
    	String servername = (String) getConfig().getString("Config.Servername");
    	
    	
    	if(commandLabel.equalsIgnoreCase("trail")) {
        	player.performCommand("trails");
    	}
    	if(commandLabel.equalsIgnoreCase("spawn")) {
        	player.performCommand("ewarp spawn");
    	}
    	if(commandLabel.equalsIgnoreCase("shop")) {
        	player.performCommand("ewarp shop");
    	
		
	    	}
	    		if(commandLabel.equalsIgnoreCase("about")) {
		    		player.sendMessage(ChatColor.DARK_RED + "ServerEssentials" + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "ServerEssentials Plugin created by: " + ChatColor.GREEN + "KingCloudNinja" + ChatColor.GRAY + ". Get more plugins here: " + ChatColor.GREEN + "https://discord.gg/zGTRYuh");
		    	}
			if(commandLabel.equalsIgnoreCase("spec") || commandLabel.equalsIgnoreCase("spectator")){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(args.length == 0){
					player.sendMessage(ChatColor.RED + "Usage: /spec (Player)");
				}
					else {
				
				
				player.teleport(target.getLocation());
				player.setGameMode(GameMode.SPECTATOR);
				player.sendMessage(ChatColor.GRAY + "You are spectating " + ChatColor.GREEN + args[0] + ChatColor.GRAY + "." );
			}
			}

	if(commandLabel.equalsIgnoreCase("fakeleave")){
		player.setGameMode(GameMode.SPECTATOR); 
		Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + ChatColor.YELLOW + " left the game");
		player.sendMessage(ChatColor.GRAY + "You are now " + ChatColor.GREEN + "Vanished" + ChatColor.GRAY + ".");
		player.setPlayerListName(null);
	}
		if(commandLabel.equalsIgnoreCase("fakejoin")){
    		player.setGameMode(GameMode.SURVIVAL);
    		Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + ChatColor.YELLOW + " joined the game");
			player.sendMessage(ChatColor.GRAY + "You are now " + ChatColor.GREEN + "Unvanished" + ChatColor.GRAY + ".");
			player.setPlayerListName(player.getDisplayName());
			
    	
	}
		if(commandLabel.equalsIgnoreCase("dab")){
			Bukkit.broadcastMessage(ChatColor.WHITE + "<" + player.getDisplayName() + ">" + ChatColor.BOLD + " <o/");
	}
		if(commandLabel.equalsIgnoreCase("shrug")){
			Bukkit.broadcastMessage(ChatColor.WHITE + "<" + player.getDisplayName() + ">" + ChatColor.BOLD + " Shrugged");
	}
		if(commandLabel.equalsIgnoreCase("bc") || commandLabel.equalsIgnoreCase("broadcast")){
			if(args.length == 0){
				player.sendMessage(ChatColor.RED + "Not enough args. Usage: '/bc (message)'");
			}
			if(args.length > 0){
			broadcastMessage = String.join(" ", args);
					Bukkit.broadcastMessage(ChatColor.AQUA + servername  + ChatColor.DARK_GRAY + "> " + ChatColor.GREEN + broadcastMessage);
		}
		}
		if(commandLabel.equalsIgnoreCase("feed") || commandLabel.equalsIgnoreCase("eat")){
			if(args.length == 0){
			player.setFoodLevel(20);
			player.sendMessage(ChatColor.GRAY + "Your appetite has been sated.");
			}
			if(args.length == 1){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				target.setFoodLevel(20);
				target.sendMessage(ChatColor.GRAY + "Your appetite has been sated by " + ChatColor.GREEN + player.getName());
				player.sendMessage(ChatColor.GRAY + "You fed " + ChatColor.GREEN + target.getName());
			}
			if(args.length >= 2){
				player.sendMessage(ChatColor.RED + "Too many arguments. Usage: /heal OR /heal (player)");
			}
				
		}
		if(commandLabel.equalsIgnoreCase("heal") || commandLabel.equalsIgnoreCase("restore")){
			if(args.length == 0){
			player.setHealth(20);
			player.sendMessage(ChatColor.GRAY + "You have been healed.");
			player.getActivePotionEffects().remove(true);
			player.setFoodLevel(20);
			}
			if(args.length == 1){
				Player target = Bukkit.getServer().getPlayer(args[0]);
				target.setHealth(20);
				target.sendMessage(ChatColor.GRAY + "You have been healed by " + ChatColor.GREEN + player.getName());
				player.sendMessage(ChatColor.GRAY + "You healed " + ChatColor.GREEN + target.getName());
				target.getActivePotionEffects().remove(true);
				target.setFoodLevel(20);
			}
			if(args.length >= 2){
				player.sendMessage(ChatColor.RED + "Too many arguments. Usage: /heal OR /heal (player)");
			}
		}
		if(commandLabel.equalsIgnoreCase("se") || commandLabel.equalsIgnoreCase("serveressentials")){
			if(args[0].equals("reload")){
				reloadConfig();
				player.sendMessage(ChatColor.GREEN + "Config Reloaded!");
			}
			if(args[0].equals("help")){
				player.sendMessage(ChatColor.GREEN + "Commands: /se reload /se help");
			}
			else{
				player.sendMessage(ChatColor.RED + "Command not found! Do /se help for correct commands.");
			}
			
		}
	return false;
	}

}
