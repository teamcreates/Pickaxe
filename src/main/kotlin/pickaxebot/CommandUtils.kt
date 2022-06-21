package pickaxebot

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.PublicSlashCommandContext
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.Color
import dev.kord.rest.builder.message.create.embed
import pickaxebot.database.dao.UserManager
import pickaxebot.entity.UserData

suspend fun PublicSlashCommandContext<Arguments>.checkUserRegistered(): UserData? {
    val user = UserManager.findUserData(user.id)
    if(user != null) return user
    respond {
        embed {
            title = "Command execution failed"
            color = Color(255, 0, 0)
            field {
                name = "Reason"
                value = "You have to register to execute this command!"
            }
        }
    }
    return null
}