package pickaxebot.utils

object Markdown {

    val map = mapOf(
        "bgDefault" to ANSIBackgroundColor.DEFAULT.code,
        "bgBlack" to ANSIBackgroundColor.BLACK.code,
        "bgGreen" to ANSIBackgroundColor.GREEN.code,
        "bgRed" to ANSIBackgroundColor.RED.code,
        "bgBlue" to ANSIBackgroundColor.BLUE.code,
        "bgYellow" to ANSIBackgroundColor.YELLOW.code,
        "bgCyan" to ANSIBackgroundColor.CYAN.code,
        "bgPurple" to ANSIBackgroundColor.PURPLE.code,
        "bgWhite" to ANSIBackgroundColor.WHITE.code,
        "fgDefault" to ANSIBackgroundColor.DEFAULT.code,
        "fgBlack" to ANSIBackgroundColor.BLACK.code,
        "fgGreen" to ANSIBackgroundColor.GREEN.code,
        "fgRed" to ANSIBackgroundColor.RED.code,
        "fgBlue" to ANSIBackgroundColor.BLUE.code,
        "fgYellow" to ANSIBackgroundColor.YELLOW.code,
        "fgCyan" to ANSIBackgroundColor.CYAN.code,
        "fgPurple" to ANSIBackgroundColor.PURPLE.code,
        "fgWhite" to ANSIBackgroundColor.WHITE.code,
        "stBold" to ANSIStyle.BOLD.code,
        "stItalic" to ANSIStyle.ITALIC.code,
        "stUnderline" to ANSIStyle.UNDERLINE.code,
        "stStrike" to ANSIStyle.STRIKETHROUGH.code,
    )

    val regex = Regex("(\\[).+?(\\])")

    fun translateCode(text: String): String {
        val translated = text.removeSurrounding("[", "]").split(";").map { map[it] }.joinToString(";")
        return "${ANSIColors.escape}[${translated}m"
    }

    fun translate(text: String): String {
        return regex.replace(text) {
            return@replace translateCode(it.value)
        }
    }

}

fun main() {
    println(Markdown.translate("[bgWhite;fgBlack;stBold]SampleText"))
}