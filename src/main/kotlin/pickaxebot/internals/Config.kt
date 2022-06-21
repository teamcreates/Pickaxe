package pickaxebot.internals

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Config(
    val token: String = "your bot token here",
    val gitRepository: String = "https://github.com/devlaq/Pickaxe",
    val databaseConfig: DatabaseConfig = DatabaseConfig()
) {
    companion object {
        fun load(path: String, createDefault: Boolean = true): Config {
            createDefault(path)
            val file = File(path)
            val text = file.readText()
            val jsonBuilder = Json {
                encodeDefaults = true
            }
            return jsonBuilder.decodeFromString(text)
        }

        fun createDefault(path: String) {
            Config().save(path, false)
        }
    }

    fun save(path: String, overwrite: Boolean = true) {
        val file = File(path)
        val jsonBuilder = Json {
            encodeDefaults = true
            prettyPrint = true
        }
        if(file.exists() && overwrite) {
            file.writeText(jsonBuilder.encodeToString(this))
        } else if(!file.exists()) {
            file.createNewFile()
            file.writeText(jsonBuilder.encodeToString(this))
        }
    }
}

@Serializable
data class DatabaseConfig(
    val url: String = "your mongodb url here",
    val name: String = "your mongodb database name here"
)