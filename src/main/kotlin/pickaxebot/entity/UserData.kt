package pickaxebot.entity

import dev.kord.core.entity.User

data class UserData(
    val id: Long,
    val inventory: Inventory
) {
    companion object {
        fun fromUser(discordUser: User): UserData {
            return UserData(
                id = discordUser.id.value.toLong(),
                inventory = Inventory()
            )
        }
    }
}