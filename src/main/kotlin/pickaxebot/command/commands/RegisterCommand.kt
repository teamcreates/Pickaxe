package pickaxebot.command.commands

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.rest.builder.message.create.embed
import pickaxebot.database.dao.UserManager
import pickaxebot.entity.UserData

class RegisterCommand: Extension() {

    override val name = "register_command_extension"

    override suspend fun setup() {
        publicSlashCommand {
            name = "register"
            description = "Register to database"

            action {
                respond {
                    if(UserManager.userExists(user.id)) {
                        embed {
                            title = "User registration"
                            description = "User registration failed."
                            color = Color(255, 0, 0)
                            field {
                                name = "Reason"
                                value = "User already registered."
                            }
                        }
                    } else {
                        UserManager.registerUserData(UserData.fromUser(user.asUser()))
                        embed {
                            title = "User registration"
                            description = "User registration success."
                            color = Color(0, 255, 0)
                        }
                    }
                }
            }
        }
    }

}