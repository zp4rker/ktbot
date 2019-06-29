package com.zp4rker.ktbot

import com.zp4rker.core.discord.command.Command
import com.zp4rker.core.discord.command.CommandHandler
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.hooks.AnnotatedEventManager

fun main(args: Array<String>) {

    val handler = CommandHandler()
    handler.registerCommands(Ping, Arg, MinArg, MentionedMembers, MentionedRoles, MentionedChannels, Permission, PermissionRole)

    JDABuilder(AccountType.BOT).setToken(args[0]).setEventManager(AnnotatedEventManager()).addEventListeners(handler).build()

}

object Ping: Command(aliases = arrayOf("ping"), autoDelete = true) {
    override fun handle(message: Message, channel: TextChannel, guild: Guild, args: List<String>) {
        channel.sendMessage("pong").queue()
    }
}

object Arg: Command(aliases = arrayOf("arg"), args = 2) {
    override fun handle(message: Message, channel: TextChannel, guild: Guild, args: List<String>) {
        channel.sendMessage("argument 1 = ${args[0]}, argument 2 = ${args[1]}").queue()
    }
}

object MinArg: Command(aliases = arrayOf("minarg"), minArgs = 3) {
    override fun handle(message: Message, channel: TextChannel, guild: Guild, args: List<String>) {
        channel.sendMessage(args.joinToString { "argument ${args.indexOf(it) + 1} = $it" }).queue()
    }
}

object MentionedMembers: Command(aliases = arrayOf("mentionedmembers"), mentionedMembers = 1) {
    override fun handle(message: Message, channel: TextChannel, guild: Guild, args: List<String>) {
        channel.sendMessage("you mentioned ${message.mentionedMembers[0]}").queue()
    }
}

object MentionedRoles: Command(aliases = arrayOf("mentionedroles"), mentionedRoles = 1) {
    override fun handle(message: Message, channel: TextChannel, guild: Guild, args: List<String>) {
        channel.sendMessage("you mentioned ${message.mentionedRoles[0]}").queue()
    }
}

object MentionedChannels: Command(aliases = arrayOf("mentionedchannels"), mentionedChannels = 1) {
    override fun handle(message: Message, channel: TextChannel, guild: Guild, args: List<String>) {
        channel.sendMessage("you mentioned ${message.mentionedChannels[0]}").queue()
    }
}

object Permission: Command(aliases = arrayOf("permission"), permission = Permission.MESSAGE_MANAGE) {
    override fun handle(message: Message, channel: TextChannel, guild: Guild, args: List<String>) {
        channel.sendMessage("you had permission").queue()
    }
}

object PermissionRole: Command(aliases = arrayOf("permissionrole"), role = 577827716456513536) {
    override fun handle(message: Message, channel: TextChannel, guild: Guild, args: List<String>) {
        channel.sendMessage("you had permission").queue()
    }
}