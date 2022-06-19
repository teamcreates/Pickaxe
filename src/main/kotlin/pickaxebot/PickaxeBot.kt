package pickaxebot

import com.kotlindiscord.kord.extensions.ExtensibleBot
import pickaxebot.command.Commands
import pickaxebot.database.Database
import pickaxebot.internals.Config

object PickaxeBot {

    lateinit var config: Config

    lateinit var commands: Commands
    lateinit var bot: ExtensibleBot

    suspend fun initialize() {
        config = Config.load("./config.json")

        Database.initialize(config.databaseConfig)

        commands = Commands()
        bot = ExtensibleBot(config.token) {
            extensions {
                help {
                    enableBundledExtension = false
                }
                commands.registerCommands(this)
            }
        }

        bot.start()
    }

}

suspend fun main(args: Array<String>) {
    PickaxeBot.initialize()
}