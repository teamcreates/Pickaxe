package pickaxebot.extension.extensions

import com.kotlindiscord.kord.extensions.components.components
import com.kotlindiscord.kord.extensions.components.publicButton
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.edit
import com.kotlindiscord.kord.extensions.types.respond
import kotlinx.coroutines.*

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
                            id = "confirmButton"
                            label = "Confirm: DELETE ALL YOUR DATA AND QUIT (5)"
                            disabled = true
                            action {
                                respond {
                                    content = "Confirmed."
                                    edit {
                                        publicButton {
                                            id = "confirmButton"
                                            label = "Confirmed"
                                            disabled = true
                                        }
                                    }
                                }
                            }
                        }
                    }
                    coroutineScope {
                        runBlocking {
                            withContext(Dispatchers.Default) {
                                delay(5000)
                                edit {
                                    components {
                                        publicButton {
                                            id = "confirmButton"
                                            label = "Confirm: DELETE ALL YOUR DATA AND QUIT"
                                            disabled = false
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}