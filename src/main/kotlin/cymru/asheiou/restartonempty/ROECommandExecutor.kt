package cymru.asheiou.restartonempty

import net.md_5.bungee.api.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import java.util.Locale.getDefault

class ROECommandExecutor : CommandExecutor {
  override fun onCommand(
    sender: CommandSender,
    command: Command,
    label: String,
    args: Array<out String?>) : Boolean{
    if (args.isNotEmpty()) {
      if (args.size > 1) {
        sender.sendMessage("${ChatColor.RED}Too many arguments! Usage:")
        return false
      }
      when (args[0]?.lowercase(getDefault())) {
        "true" -> {
          ROEToggle.status = true
          sender.sendMessage("${ChatColor.GREEN}The server will restart on empty.")
          return true
        }

        "false" -> {
          ROEToggle.status = false
          sender.sendMessage("${ChatColor.GREEN}The server will no longer restart on empty.")
          return true
        }

        "status" -> {
          sender.sendMessage("${ChatColor.GREEN}The server " + (if (ROEToggle.status) "will" else "will not") + " restart on empty.")
          return true
        }

        else -> {
          sender.sendMessage("${ChatColor.RED}Argument not recognised! Usage:")
          return false
        }
      }
    }
    ROEToggle.status = !ROEToggle.status
    sender.sendMessage("${ChatColor.AQUA}The server " + (if (ROEToggle.status) "will" else "will no longer")
            + " restart on empty.")
    return true
  }
}