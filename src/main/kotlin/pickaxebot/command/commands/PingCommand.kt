package pickaxebot.command.commands

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.rest.builder.message.create.embed

class PingCommand: Extension() {

    override val name = "ping_command_extension"

    override suspend fun setup() {
        publicSlashCommand {
            name = "ping"
            description = "Check the average ping of the bot."
            action {
                val ping = this@publicSlashCommand.kord.gateway.averagePing

                respond {
                    embed {
                        title = "Ping"
                        description = "${ping ?: "Can't get average ping."}"
                        color = if(ping == null) Color(255, 0, 0) else Color(0, 255, 0)
                    }
                }
            }
        }
    }

}
