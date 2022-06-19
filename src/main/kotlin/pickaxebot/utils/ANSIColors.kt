package pickaxebot.utils

enum class ANSIForegroundColor(val code: String) {

    DEFAULT("39"),
    BLACK("30"),
    RED("31"),
    GREEN("32"),
    YELLOW("33"),
    BLUE("34"),
    PURPLE("35"),
    CYAN("36"),
    WHITE("37");

}

enum class ANSIBackgroundColor(val code: String) {

    DEFAULT("49"),
    BLACK("40"),
    RED("41"),
    GREEN("42"),
    YELLOW("43"),
    BLUE("44"),
    PURPLE("45"),
    CYAN("46"),
    WHITE("47");

}

enum class ANSIStyle(val code: String) {

    BOLD("1"),
    ITALIC("3"),
    UNDERLINE("4"),
    STRIKETHROUGH("9")

}

object ANSIColors {

    const val escape = "\u001B"

    fun create(foreground: ANSIForegroundColor, background: ANSIBackgroundColor, vararg styles: ANSIStyle): String {
        return "${escape}[${foreground.code};${background.code}${if(styles.isNotEmpty()) ";" + styles.joinToString(";") { it.code } else ""}m"
    }

}