package uk.asheiou.restartonempty;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class RestartOnEmptyCommandExecutor implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(args != null && args.length > 0) {
      if(args.length > 1) {
        sender.sendMessage(ChatColor.RED + "Too many arguments! Usage: /restartonempty [true/false]");
        return false; 
      }
      switch(args[0].toLowerCase()) {
      case "true":
        Toggle.setStatus(true);
        sender.sendMessage(ChatColor.GREEN + "The server will restart on empty.");
        return true;
      case "false":
        Toggle.setStatus(false);
        sender.sendMessage(ChatColor.GREEN + "The server will no longer restart on empty.");
        return true;
      default:
        sender.sendMessage(ChatColor.RED + "Argument not recognised! Usage: /restartonempty [true/false]");
        return false;
      }
    }
    boolean toSet = !Toggle.getStatus();
    Toggle.setStatus(toSet);
    sender.sendMessage(ChatColor.GREEN + "The server " + (toSet ? "will" : "will no longer") + " restart on empty.");
    return true;
  } 
}

