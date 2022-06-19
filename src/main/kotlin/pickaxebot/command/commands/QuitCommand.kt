package pickaxebot.command.commands

import com.kotlindiscord.kord.extensions.components.components
import com.kotlindiscord.kord.extensions.components.publicButton
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class QuitCommand: Extension() {

    override val name = "quit_command_extension"

    override suspend fun setup() {
        publicSlashCommand {
            name = "quit"
            description = "Delete all your data and quit."

            action {
                respond {
                    components {
                        publicButton {
                            label = "Confirm: DELETE ALL YOUR DATA AND QUIT"
                            disabled = true
                            withContext(Dispatchers.IO) {
                                TimeUnit.SECONDS.sleep(5)
                            }
                            action {
                                respond {
                                    content = "Confirmed."
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}