package com.zp4rker.bots.ktbot

import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.AnnotatedEventManager
import net.dv8tion.jda.api.hooks.SubscribeEvent

fun main(args: Array<String>) {

    JDABuilder(AccountType.BOT).setToken(args[0]).setEventManager(AnnotatedEventManager()).addEventListeners(PingCommand()).build()

}

class PingCommand {
    @SubscribeEvent
    fun onMessage(e: GuildMessageReceivedEvent) {
        if (e.message.contentRaw != "/ping") return
        e.channel.sendMessage("Pong!").queue()
    }
}