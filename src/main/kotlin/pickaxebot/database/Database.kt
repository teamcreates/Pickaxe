package pickaxebot.database

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import io.ktor.util.*
import org.litote.kmongo.KMongo
import org.slf4j.LoggerFactory
import pickaxebot.internals.DatabaseConfig

object Database {

    private val logger = LoggerFactory.getLogger("Database Manager")

    lateinit var client: MongoClient
    lateinit var database: MongoDatabase

    fun initialize(config: DatabaseConfig) {
        try {
            client = KMongo.createClient(config.url)
            database = client.getDatabase(config.name)
        } catch (e: Exception) {
            logger.error(e)
            logger.error("Could not initialize database!")
        }
    }

}