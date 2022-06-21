package pickaxebot.extension.extensions

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.converters.impl.stringChoice
import com.kotlindiscord.kord.extensions.commands.application.slash.group
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.rest.builder.message.create.embed
import pickaxebot.PickaxeBot

class DebugCommand: Extension() {

    override val name = "debug_command_extension"

    override suspend fun setup() {
        publicSlashCommand {
            name = "debug"
            description = "debug commands"

            group("extensions") {
                description = "extension manager"

                publicSubCommand {
                    name = "list"
                    description = "list of extensions"

                    action {
                        respond {
                            embed {
                                title = "Debug: Extensions"
                                description = "Currently ${bot.extensions.size} extensions are loaded."
                                field {
                                    name = "Extensions(${bot.extensions.size})"
                                    value = bot.extensions.keys.map { "${it}(Loaded: ${bot.extensions[it]?.loaded})" }.joinToString("\n")
                                }
                            }
                        }
                    }
                }

                publicSubCommand(::ExtensionSubCommandArguments) {
                    name = "load"
                    description = "Load a extension"

                    action {
                        respond {
                            bot.loadExtension(arguments.extensionName)
                            embed {
                                title = "Debug: Extension"
                                description = "Successfully loaded the extension."
                                color = Color(0, 255, 0)
                            }
                        }
                    }
                }

                publicSubCommand(::ExtensionSubCommandArguments) {
                    name = "unload"
                    description = "Unload a extension"

                    action {
                        respond {
                            bot.unloadExtension(arguments.extensionName)
                            embed {
                                title = "Debug: Extension"
                                description = "Successfully unloaded the extension."
                                color = Color(0, 255, 0)
                            }
                        }
                    }
                }
            }
        }
    }
}

class ExtensionSubCommandArguments: Arguments() {
    val extensionName by stringChoice {
        name = "extensionName"
        description = "Name of the extension"
        PickaxeBot.bot.extensions.keys.forEach { choices[it] = it }
    }
}