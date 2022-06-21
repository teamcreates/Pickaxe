package pickaxebot.extension.extensions

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalUser
import com.kotlindiscord.kord.extensions.components.components
import com.kotlindiscord.kord.extensions.components.linkButton
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import pickaxebot.PickaxeBot

class InfoCommand: Extension() {

    override val name = "info_command_extension"

    override suspend fun setup() {
        publicSlashCommand {
            name = "info"
            description = "Get info of bot, user, guild"

            publicSubCommand {
                name = "bot"
                description = "Get info of the bot"

                action {
                    respond {
                        embed {
                            title = "Bot Info"
                            field {
                                name = "Source code"
                                value = PickaxeBot.config.gitRepository
                            }
                        }
                        components {
                            if(PickaxeBot.config.gitRepository != "PRIVATE") {
                                linkButton {
                                    url = PickaxeBot.config.gitRepository
                                    label = "Git Repository"
                                }
                            }
                        }
                    }
                }
            }

            publicSubCommand(::UserInfoArgument) {
                name = "user"
                description = "Get info of the user"

                action {
                    val user = arguments.user ?: user.asUser()

                    respond {
                        embed {
                            title = "Info of ${user.tag}"
                            description = "**Nothing.**"
                        }
                    }
                }
            }
        }
    }
}

class UserInfoArgument: Arguments() {

    val user by optionalUser {
        name = "targetUser"
        description = "target user to get information"
    }

}