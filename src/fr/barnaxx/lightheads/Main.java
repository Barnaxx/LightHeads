package fr.barnaxx.lightheads;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class Main extends JavaPlugin
{
  static final Logger log = Logger.getLogger("Minecraft");

  public void onDisable()
  {
    info("has been Disabled!");
  }

public void onEnable()
  {
    info("has been Enabled!");
  }

  public void info(String msg) {
    Logger.getLogger("Minecraft").info("[" + getDescription().getName() + " v" + getDescription().getVersion() + "] " + msg);
  }

  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if (cmd.getName().equalsIgnoreCase("head")) {
    	if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.AQUA + "[LightHeads] " + ChatColor.RED + "This command can only be run by a player.");
		} else {
			Player player = (Player) sender;
		    if (args.length == 0) {
			    ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			    SkullMeta meta = (SkullMeta) is.getItemMeta();
			    meta.setOwner(player.getName());
			    is.setItemMeta(meta);
			    player.getInventory().addItem(is);
			    player.updateInventory();
		    	sender.sendMessage(ChatColor.AQUA + "[LightHeads] " + ChatColor.GREEN + "Successfully spawned the head of " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + "!");
		        return true;
		    }
		    if (args.length > 2) {
		    	sender.sendMessage(ChatColor.AQUA + "[LightHeads] " + ChatColor.RED + "Too many args!");
		    }
		    String headname = "";
		    for (String s : args) {
		    	headname = headname + s;
		    }
		    ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		    SkullMeta meta = (SkullMeta) is.getItemMeta();
		    meta.setOwner(headname);
		    is.setItemMeta(meta);
		    player.getInventory().addItem(is);
		    player.updateInventory();
		    sender.sendMessage(ChatColor.AQUA + "[LightHeads] " + ChatColor.GREEN + "Successfully spawned the head of " + ChatColor.AQUA + headname + ChatColor.GREEN + "!");
		    return true;	
		}
    }
    return false;
  }
}