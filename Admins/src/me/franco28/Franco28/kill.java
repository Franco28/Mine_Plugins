package me.franco28.Franco28;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class kill implements CommandExecutor {

	public String cmd1 = "kill";
	public String cmd2 = "health";
	public String cmd3 = "food";
	public String cmd4 = "fly";
	public Player player = null;

	public void errorplayer()
	{
        	player.sendMessage(ChatColor.RED + "Jugador no encontrado");
	}
	
	public void selectplayer()
	{
      	player.sendMessage(ChatColor.RED + "Por favor seleccione algún jugador");
	}
	
	public void returnplayer(String[] args)
	{
    	Player pl = (Player) Bukkit.getServer().getPlayer(args[0]);
        if (pl == null) {
        	errorplayer();
        }  
	}
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	     	
		if (sender instanceof Player){

        		player = (Player) sender;

    	        if (cmd.getName().equalsIgnoreCase(cmd1)) {

    	        	if (args.length == 0) {
    	            	selectplayer();    		            	    		            	
    		            } else {

    		            	Player pl = (Player) Bukkit.getServer().getPlayer(args[0]);

    			            if (player.equals(pl)) {           	    		          	
     			               player.setHealth(0.0D);
   	 	    	               player.sendMessage(ChatColor.RED + "Te mataste vos mismo!");    	               
    			            } 
    	        	  	        	
		          if (args.length >= 1) {
		            	returnplayer(args);     
    	          } else {
		            	pl.setHealth(0.0D);    	               
                    	player.sendMessage(ChatColor.RED + "El jugador " + player.getName() + " ah muerto por tu culpa");
    	          }
		            
    	        	if (player.equals(null)) { 
		            	returnplayer(args);     
    	        	}
    		            }
    	        }
    	        
    	        if (cmd.getName().equalsIgnoreCase(cmd2)){
    	        	
    	        	if (args.length == 0) {
    	            	selectplayer();    		            	    		            	
    		            } else {

    		            	Player pl = (Player) Bukkit.getServer().getPlayer(args[0]);

    			            if (player.equals(pl)) {           	    		          	
    			            	
    			            	double health = player.getHealth(); 

    			            	if (health == 20.0)
    			            	{
        			                player.sendMessage(ChatColor.GREEN + "Ya tienes toda tu vida!");
    			            	} else {
        			            	player.setHealth(20.0);        			                
        			                player.sendMessage(ChatColor.RED + "Te llenaste tu vida!");
        			                return true;	
    			            	}  	               
    			            } 
    	        	  	        	
		          if (args.length >= 1) {
		            	returnplayer(args);     
    	          } else {
		            	pl.setHealth(20.0);  	               
                    	player.sendMessage(ChatColor.RED + "El jugador " + player.getName() + " recibió vida de tu parte!");
    	          }
		            
    	        	if (player.equals(null)) { 
		            	returnplayer(args);     
    	        	}
    		            }		     
    	        }
    	        
    	        if (cmd.getName().equalsIgnoreCase(cmd3)){
	                
    	        	if (args.length == 0) {
    	            	selectplayer();    		            	    		            	
    		            } else {

    		            	Player pl = (Player) Bukkit.getServer().getPlayer(args[0]);

    			            if (player.equals(pl)) {           	    		          	
    			            	
    	    		          	if (player.getFoodLevel() > 20.0)
    	    		          	{
    		    		          	player.sendMessage(ChatColor.RED + "Te has llenado tu barra de comida!");
    			                    player.setFoodLevel(20);
    	    		          	}
    	    		          	else
    	    		          	{
    		    		          	player.sendMessage(ChatColor.GREEN + "Tu barra de comida ya esta llena!");
    			                    player.setFoodLevel(20);
        			                return true;	
    	    		          	}	               
    			            } 
    	        	  	        	
		          if (args.length >= 1) {
		            	returnplayer(args);     
    	          } else {
		            	pl.setFoodLevel(20);  	               
                    	player.sendMessage(ChatColor.RED + "El jugador " + player.getName() + " recibió comida de tu parte!");
    	          }
		            
    	        	if (player.equals(null)) { 
		            	returnplayer(args);     
    	        	}
    		            }		
    	        }      
    	            
    	        if (cmd.getName().equalsIgnoreCase(cmd4)){
    	        
    	        	if (args.length == 0) {
    	            	selectplayer();    		            	    		            	
    		            } else {

    		            	Player pl = (Player) Bukkit.getServer().getPlayer(args[0]);

    			            if (player.equals(pl)) {           	    		          	
    			            	
    	    		          	if (player.getAllowFlight() == false)
    	    		          	{
        	    		          	player.sendMessage(ChatColor.GREEN + "Ya puedes volar!");
    	    		          		player.setAllowFlight(!player.getAllowFlight());
    	    		          	}
    	    		          	else
    	    		          	{
        	    		          	player.sendMessage(ChatColor.RED + "Ya no puedes volar!");
        	    		          	player.setAllowFlight(false);
        	    		          	return true;
    	    		          	}	               
    			            } 
    	        	  	        	
		          if (args.length >= 1) {
		            	returnplayer(args);     
    	          } else {
		            	pl.setAllowFlight(true);  	               
                    	player.sendMessage(ChatColor.RED + "El jugador " + player.getName() + " ahora puede volar!");
    	          }
		            
    	        	if (player.equals(null)) { 
		            	returnplayer(args);     
    	        	}
    		            }  	
    	        }
    	            	        
	        }
			return false;	       
	    }
}
