package pickaxebot.command

import com.kotlindiscord.kord.extensions.builders.ExtensibleBotBuilder
import pickaxebot.command.commands.*

class Commands {

    private val commands = listOf(
        ::PingCommand,
        ::InventoryCommand,
        ::TestCommand,
        ::DebugCommand,
        ::RegisterCommand,
        ::QuitCommand
    )

    fun registerCommands(extensionBuilder: ExtensibleBotBuilder.ExtensionsBuilder) {
        extensionBuilder.apply {
            commands.forEach {
                add(it)
            }
        }
    }

}