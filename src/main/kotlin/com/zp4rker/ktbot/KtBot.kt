package com.zp4rker.ktbot

import com.zp4rker.core.discord.command.Command
import com.zp4rker.core.discord.command.CommandHandler
import com.zp4rker.core.discord.util.sendRawString
import emoji4j.EmojiUtils
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.MessageChannel
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.hooks.AnnotatedEventManager
import net.dv8tion.jda.api.requests.restaction.MessageAction

fun main() {

    val handler = CommandHandler()
    handler.registerCommands(Test)

    JDABuilder(AccountType.BOT).setToken("INSERT TOKEN HERE").setEventManager(AnnotatedEventManager()).addEventListeners(handler).build()

}

object Test : Command(aliases = arrayOf("test")) {
    override fun handle(message: Message, channel: TextChannel, guild: Guild, args: List<String>) {
        EmbedBuilder().setImage("https://mcapi.us/server/image?ip=play.hivemc.com").build().also { channel.sendMessage(it).queue() }
    }
}