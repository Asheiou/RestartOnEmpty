package uk.asheiou.restartonempty;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {
  @EventHandler(priority=EventPriority.LOWEST)
  public void onPlayerQuit(PlayerQuitEvent event) {
    Bukkit.getLogger().info("Player left. Checking if the server should restart...");
	boolean isEmpty = Bukkit.getOnlinePlayers().size() == 1;
    if(isEmpty && Toggle.getStatus()) {
      Server server = Bukkit.getServer();
      Bukkit.getLogger().info("Restarting as the server is empty.");
      server.dispatchCommand(server.getConsoleSender(), "restart");
    } else {
      Bukkit.getLogger().info("No restart because " + (isEmpty ? "ROE is disabled." : "the server is not empty."));
    }
  }
}
