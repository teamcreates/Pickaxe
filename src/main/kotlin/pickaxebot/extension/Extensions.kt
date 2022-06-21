package pickaxebot.extension

import com.kotlindiscord.kord.extensions.builders.ExtensibleBotBuilder
import pickaxebot.extension.extensions.*

class Extensions {

    private val extensions = listOf(
        ::PingCommand,
        ::InventoryCommand,
        ::TestCommand,
        ::DebugCommand,
        ::RegisterCommand,
        ::QuitCommand,
        ::InfoCommand,
        ::WhatTheHellCommand
    )

    fun registerExtensions(extensionBuilder: ExtensibleBotBuilder.ExtensionsBuilder) {
        extensionBuilder.apply {
            this@Extensions.extensions.forEach {
                add(it)
            }
        }
    }

}