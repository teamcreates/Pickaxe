package pickaxebot.extension.extensions

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.rest.builder.message.create.embed
import pickaxebot.checkUserRegistered

class InventoryCommand : Extension() {

    override val name = "_command_extension"

    override suspend fun setup() {
        publicSlashCommand {
            name = "inventory"
            description = "Check your inventory."
            action {
                val userData = checkUserRegistered() ?: return@action
                respond {
                    embed {
                        title = "Inventory"
                        description = "User: ${user.mention}"
                        color = Color(255, 0, 0)
                    }
                }
            }
        }
    }

}
