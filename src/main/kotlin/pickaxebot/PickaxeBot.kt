package pickaxebot

import com.kotlindiscord.kord.extensions.ExtensibleBot
import pickaxebot.extension.Extensions
import pickaxebot.database.Database
import pickaxebot.internals.Config

object PickaxeBot {

    lateinit var config: Config

    lateinit var extensions: Extensions
    lateinit var bot: ExtensibleBot

    suspend fun initialize() {
        config = Config.load("./config.json")

        Database.initialize(config.databaseConfig)

        extensions = Extensions()

        bot = ExtensibleBot(config.token) {
            extensions {
                help {
                    enableBundledExtension = false
                }
                this@PickaxeBot.extensions.registerExtensions(this)
            }
        }

        bot.start()
    }

}

suspend fun main(args: Array<String>) {
    PickaxeBot.initialize()
}