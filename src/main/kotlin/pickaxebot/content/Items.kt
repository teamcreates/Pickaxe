package pickaxebot.content

object Items {
    val items = mutableListOf<Item>()

    init {

    }
}

data class ItemStack(
    val displayedName: String,
    val type: Item,
    val amount: Int
)

class Item(val key: String, val category: ItemCategory, val rarity: ItemRarity) {



}

enum class ItemCategory(val key: String) {

    ORE("item.categories.ore"),
    WEAPON("item.categories.weapon"),
    TOOL("item.categories.tool"),
    ARMOR("item.categories.armor"),
    MISCELLANEOUS("item.categories.miscellaneous")

}

enum class ItemRarity(val key: String) {

    COMMON("item.rarity.common"),
    UNCOMMON("item.rarity.uncommon"),
    RARE("item.rarity.rare"),
    EPIC("item.rarity.epic"),
    LEGENDARY("item.rarity.legendary"),
    SPECIAL("item.rarity.special"),
    UNABLE_TO_EVALUATE("item.rarity.unable_to_evaluate")

}