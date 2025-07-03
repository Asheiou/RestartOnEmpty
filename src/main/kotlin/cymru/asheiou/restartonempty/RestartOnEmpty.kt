package cymru.asheiou.restartonempty

import org.bstats.bukkit.Metrics
import org.bukkit.plugin.java.JavaPlugin
import java.time.Duration
import java.time.Instant

class RestartOnEmpty : JavaPlugin() {
  lateinit var metrics: Metrics

  override fun onEnable() {
    logger.info("Starting load.")
    val startTime: Instant = Instant.now()

    server.pluginManager.registerEvents(EventListener(this), this)
    this.getCommand("restartonempty")?.setExecutor(ROECommandExecutor())

    val pluginId = 26364
    metrics = Metrics(this, pluginId)

    val endTime: Instant? = Instant.now()
    logger.info("\u001B[32mLoad complete in " + Duration.between(startTime, endTime).toMillis() + "ms.\u001B[0m")
  }

  override fun onDisable() {
    metrics.shutdown()
    logger.info("ttyl")
  }
}
