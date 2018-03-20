package tld.example.myplugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	private String broadcastMessage;




	public void onEnable() {
    	Bukkit.getPluginManager().registerEvents ((Listener) this, this);
    	
	}
	
	public void loadConfiguration(){
	     String path = "Commands.ServerName";
	     getConfig().addDefault(path, "I did!");
	     getConfig().options().copyDefaults(true);
	     saveConfig();
	}

	
	
	@EventHandler
		
		
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    
    	Player player = (Player) sender;
    	Location location = player.getLocation();
    	this.getConfig();
    	FileConfiguration config = this.getConfig();
    	config.addDefault("servername", true);
    	config.addDefault("discord", true);
    	String servername = (String) "ServerName";
    	
    	
    	
    	
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
		    		player.sendMessage(ChatColor.DARK_RED + "ServerEssentials" + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "ServerEssentials Plugin created by: KingCloudNinja. Get more plugins here: https://discord.gg/zGTRYuh");
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
			if(commandLabel.equalsIgnoreCase("v")){
				player.setGameMode(GameMode.SPECTATOR);
				player.sendMessage(ChatColor.GRAY + "You are now " + ChatColor.GREEN + "Vanished" + ChatColor.GRAY + ".");
				location.getBlock().getLocation();
			}
			if(commandLabel.equalsIgnoreCase("unv")){
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(ChatColor.GRAY + "You are now " + ChatColor.GREEN + "Unvanished" + ChatColor.GRAY + ".");
				player.teleport(location);
			
		
		}
	
		
	if(commandLabel.equalsIgnoreCase("fakeleave")){
		player.setGameMode(GameMode.SPECTATOR); 
		Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + ChatColor.YELLOW + " left the game");
		player.sendMessage(ChatColor.GRAY + "You are now " + ChatColor.GREEN + "Vanished" + ChatColor.GRAY + ".");
		player.performCommand("ev");
	}
		if(commandLabel.equalsIgnoreCase("unfakeleave")){
    		player.setGameMode(GameMode.SURVIVAL);
    		Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + ChatColor.YELLOW + " joined the game");
			player.sendMessage(ChatColor.GRAY + "You are now " + ChatColor.GREEN + "Unvanished" + ChatColor.GRAY + ".");
			player.performCommand("ev");
			
    	
	}
		if(commandLabel.equalsIgnoreCase("dab")){
			Bukkit.broadcastMessage(ChatColor.WHITE + "<" + player.getDisplayName() + ">" + ChatColor.BOLD + " <o/");
	}
		if(commandLabel.equalsIgnoreCase("shrug")){
			Bukkit.broadcastMessage(ChatColor.WHITE + "<" + player.getDisplayName() + ">" + ChatColor.BOLD + " Shrugged");
	}
		if(commandLabel.equalsIgnoreCase("ban")){
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if(args.length == 0 || args.length == 1){
				player.sendMessage(ChatColor.RED + "Usage: /ban (player) Reason");
			}
				
			if(args[1].equals("hacking") || args[1].equals("threat") || args[1].equals("threats")){
				if(args.length == 2){
				player.performCommand("eban " + target.getName());
				Bukkit.broadcastMessage(player.getName() + ChatColor.GREEN + " banned " + ChatColor.WHITE + target.getName() + ChatColor.GREEN + " for " + args[1]);
			}
				else{
					if(args[3].equals("-s")){
						player.performCommand("eban " + target.getName());
					}
				}
				
			if(args[1].equals("evasion")){
				if(args.length == 2){
					player.performCommand("eban " + target.getName());
					Bukkit.broadcastMessage(player.getName() + ChatColor.GREEN + " banned " + ChatColor.WHITE + target.getName() + ChatColor.GREEN + " for " + args[1]);
				}
					else{
						if(args[3].equals("-s")){
							player.performCommand("eban " + target.getName());
						}
					}
			}
			if(args[1].equals("abuse")){
				if(args.length == 2){
					player.performCommand("eban " + target.getName());
					Bukkit.broadcastMessage(player.getName() + ChatColor.GREEN + " banned " + ChatColor.WHITE + target.getName() + ChatColor.GREEN + " for " + args[1]);
				}
					else{
						if(args[3].equals("-s")){
							player.performCommand("eban " + target.getName());
						}
					}
			}
			if(args[1].equals("perm")){
				if(args.length == 2){
					player.performCommand("eban " + target.getName());
					Bukkit.broadcastMessage(player.getName() + ChatColor.GREEN + " banned " + ChatColor.WHITE + target.getName() + ChatColor.GREEN + " for " + args[1]);
				}
					else{
						if(args[3].equals("-s")){
							player.performCommand("eban " + target.getName());
						}
					}
			}
	}
		}
		if(commandLabel.equalsIgnoreCase("mute")){
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if(args.length == 0 || args.length == 1){
				player.sendMessage(ChatColor.RED + "Usage: /ban (player) Reason"); 
			}
			if(args[1].equals("cussing") || args[1].equals("cursing") || args[1].equals("language") || args[1].equals("impersonation") || args[1].equals("impersonating")){
				if(args.length == 2){
					player.performCommand("emute " + target.getName());
					Bukkit.broadcastMessage(player.getName() + ChatColor.GREEN + " muted " + ChatColor.WHITE + target.getName() + ChatColor.GREEN + " for " + args[1]);
				}
					else{
						if(args[3].equals("-s")){
							player.performCommand("emute " + target.getName());
						}
					}
			}
			if(args[1].equals("advertising") || args[1].equals("ad") || args[1].equals("ads") || args[1].equals("threat") || args[1].equals("threats")){
				if(args.length == 2){
					player.performCommand("emute " + target.getName());
					Bukkit.broadcastMessage(player.getName() + ChatColor.GREEN + " muted " + ChatColor.WHITE + target.getName() + ChatColor.GREEN + " for " + args[1]);
				}
					else{
						if(args[3].equals("-s")){
							player.performCommand("emute " + target.getName());
						}
					}
			}
			if(args[1].equals("rude") || args[1].equals("disrespect") || args[1].equals("disrespective")){
				if(args.length == 2){
					player.performCommand("emute " + target.getName());
					Bukkit.broadcastMessage(player.getName() + ChatColor.GREEN + " muted " + ChatColor.WHITE + target.getName() + ChatColor.GREEN + " for " + args[1]);
				}
					else{
						if(args[3].equals("-s")){
							player.performCommand("emute " + target.getName());
						}
					}
			}
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
		if(commandLabel.equalsIgnoreCase("serveressentials") || commandLabel.equalsIgnoreCase("se")){
			if(args[0] == "reload"){
				//plugin.reloadConfig()
			}
		}
		if(commandLabel.equalsIgnoreCase("fly")){
			if(player.isFlying()){
			player.setFlying(false);
			}
			if(!player.isFlying()){
			player.setFlying(true);
			}
			if(player.hasPermission("server.togglefly")){
			if(args.length == 1){
			Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target.isFlying()){
					target.setFlying(false);
			}
			if (!target.isFlying()){
			target.setFlying(true);
			}
			}
			}
			else{
				player.sendMessage(ChatColor.RED + "Usage: /fly OR /fly (player)");
			}
		}
		
	return false;
	}

}
