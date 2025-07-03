package cymru.asheiou.restartonempty

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.plugin.java.JavaPlugin

class EventListener(private val plugin: JavaPlugin) : Listener {

  @EventHandler(priority = EventPriority.LOWEST)
  fun onPlayerQuit(event: PlayerQuitEvent) {
    ROEQuitTask().runTaskLater(this.plugin, 3)
  }
}
