package pickaxebot.command.commands

import com.kotlindiscord.kord.extensions.components.components
import dev.kord.rest.builder.message.create.embed
import com.kotlindiscord.kord.extensions.components.publicButton
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pickaxebot.database.dao.UserManager
import java.util.concurrent.TimeUnit

class QuitCommand: Extension() {

    override val name = "quit_command_extension"

    override suspend fun setup() {
        publicSlashCommand {
            name = "quit"
            description = "Delete all your data and quit."

            action {
                respond {
                    if(UserManager.userExists(user.id)){
                        components {

                            publicButton {
                                label = "Confirm: DELETE ALL YOUR DATA AND QUIT"
                                disabled = true
                                withContext(Dispatchers.IO) {
                                    TimeUnit.SECONDS.sleep(5)
                                }
                                action {
                                    UserManager.deleteUserData(user.id)
                                    respond {
                                        content = "Confirmed."
                                    }
                                }
                            }
                        }
                    }   else {
                        embed {
                            title = "Unable to quit"
                            description = "user quitting failed"
                            color = Color(255, 0, 0)
                            field {
                                name = "Reason"
                                value = "User isn't registered"
                            }

                        }
                    }

                }
            }
        }
    }

}