package pickaxebot.command.commands

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.string
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import pickaxebot.utils.Markdown

class TestCommand: Extension() {

    override val name = "test_command_extension"

    override suspend fun setup() {
        publicSlashCommand {
            name = "test"
            description = "Test command"
            publicSubCommand(::ANSISubCommandArguments) {
                name = "ansi"
                description = "generate ansi colored text"
                action {
                    respond {
                        embed {
                            title = "Test: ANSI Color Generator"
                            field {
                                name = "Displayed"
                                value = "```ansi\n${Markdown.translate(arguments.text)}\n```"
                            }
                            field {
                                name = "Raw"
                                value = "```\n${Markdown.translate(arguments.text)}\n```"
                            }
                        }
                    }
                }
            }
        }
    }

}

class ANSISubCommandArguments: Arguments() {

    val text by string {
        name = "text"
        description = "text."
    }

}