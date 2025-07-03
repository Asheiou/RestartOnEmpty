package uk.asheiou.restartonempty

import org.bukkit.Bukkit
import org.bukkit.Server
import org.bukkit.scheduler.BukkitRunnable

class ROEQuitTask : BukkitRunnable() {
  override fun run() {
    Bukkit.getLogger().info("Player left. Checking if the server should restart...")
    val isEmpty = Bukkit.getOnlinePlayers().isEmpty()

    if (isEmpty && ROEToggle.status) {
      val server: Server = Bukkit.getServer()
      Bukkit.getLogger().info("Restarting as the server is empty.")
      server.dispatchCommand(server.consoleSender, "restart")
    } else {
      Bukkit.getLogger().info("No restart because " +
              (if (ROEToggle.status) "the server is not empty." else "ROE is disabled."))
    }
  }
}
