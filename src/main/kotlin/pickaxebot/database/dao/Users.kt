package pickaxebot.database.dao

import dev.kord.common.entity.Snowflake
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import pickaxebot.database.Database
import pickaxebot.entity.UserData

object UserManager {

    private val collection
        get() = Database.database.getCollection<UserData>()

    fun registerUserData(userData: UserData) {
        collection.insertOne(userData)
    }

    fun updateUserData(userData: UserData) {
        collection.replaceOne(UserData::id eq userData.id, userData)
    }

    fun findUserData(id: Snowflake): UserData? {
        return collection.findOne(UserData::id eq id.value.toLong())
    }

    fun deleteUserData(id: Snowflake) {
        collection.deleteOne(UserData::id eq id.value.toLong())
    }

    fun userExists(id: Snowflake): Boolean {
        return findUserData(id) != null
    }
}