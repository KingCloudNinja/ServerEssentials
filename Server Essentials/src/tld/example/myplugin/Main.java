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

	public void onEnable() {
    	Bukkit.getPluginManager().registerEvents ((Listener) this, this);
    	
	}
	
	
	
	
	@EventHandler
		
		
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    
    	Player player = (Player) sender;
    	Location location = player.getLocation();
    	this.getConfig();
    	FileConfiguration config = this.getConfig();
    	config.addDefault("servername", true);
    	config.addDefault("discord", true);
    	
    	
    	
    	
    	if(commandLabel.equalsIgnoreCase("trail")) {
        	player.performCommand("trails");
    	}
    	if(commandLabel.equalsIgnoreCase("spawn")) {
        	player.performCommand("ewarp spawn");
    	}
    	if(commandLabel.equalsIgnoreCase("shop")) {
        	player.performCommand("ewarp shop");
    	
		/*}
    	if(commandLabel.equalsIgnoreCase("hype")) {
        	Bukkit.broadcastMessage(ChatColor.GRAY + player.getName() + ChatColor.GRAY + " is hyping big time! Let's go!" );
    		
    	
    	}
    		if(commandLabel.equalsIgnoreCase("help")) {
	    		player.sendMessage(ChatColor.GREEN + "List of Commands: " + ChatColor.GREEN + "COMING SOON!!");
	        	
	*/}
	    	if(commandLabel.equalsIgnoreCase("discord")) {
	    		this.getConfig();
	    		config.addDefault("servername", true);
	    		config.addDefault("discord", true);
	    		player.sendMessage(ChatColor.AQUA + config.getString("servername") + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "Join our Discord!! " + ChatColor.GREEN + config.getString("discord"));	
	/*}
	    	
	    	if(commandLabel.equalsIgnoreCase("forums")) {
	    		player.sendMessage(ChatColor.AQUA + "NightPVP Network" + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "Check out our Forums! " + ChatColor.GREEN + "(COMING SOON)");
	    		
	}
	    	if(commandLabel.equalsIgnoreCase("youtube")) {
	    		player.sendMessage(ChatColor.AQUA + "NightPVP Network" + ChatColor.DARK_GRAY + "> " + ChatColor.GRAY + "Check out KingCloudNinja's Youtube!! " + ChatColor.GREEN + "https://www.youtube.com/channel/UCBPY0o4NS6ZrWibNmOdb4ug");
	    	}
	    	*/}
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
			/*}
			if(commandLabel.equalsIgnoreCase("rules")){
				player.sendMessage(ChatColor.GREEN + "Rules:");
				player.sendMessage(ChatColor.GRAY + "Do not advertise any kind of NightPVP Network.");
				player.sendMessage(ChatColor.GRAY + "Do not leak any personal info.");
				player.sendMessage(ChatColor.GRAY + "Do not join the NightPVP Network with a mod or client that gives you a advantage.");
				player.sendMessage(ChatColor.GRAY + "Do not be toxic.");
				player.sendMessage(ChatColor.GRAY + "Do not spam/flood chat.");
				player.sendMessage(ChatColor.GRAY + "Be respectful to staff members. ");
				player.sendMessage(ChatColor.GRAY + "If other players need help, please help them, this will give you a advantage on getting staff.");
				player.sendMessage(ChatColor.GRAY + "Do not minimod. You are not staff. If you find a player breaking rules please report them on our discord. ");
				player.sendMessage(ChatColor.GRAY + "Do not ask for ranks/permissions.");
				player.sendMessage(ChatColor.GRAY + "If you find any bugs, please report them on our discord.");
				player.sendMessage(ChatColor.GRAY + "Do not abuse any glitches.");
				player.sendMessage(ChatColor.GRAY + "Do not do IRL Money Trades. (Includes Trading for In Game Stuff with real money).");*/
		
		}
	/*if(commandLabel.equalsIgnoreCase("apply") || commandLabel.equalsIgnoreCase("staff")){
		player.sendMessage(ChatColor.GRAY + "Apply for staff here! " + ChatColor.GREEN + "https://goo.gl/KAz13a");
	}*/
		
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
		

		
	return false;
	}

}
