package me.agaman.slackk.bot.event

import me.agaman.slackk.bot.data.User

@EventType("user_change")
data class UserChangeEvent(
        val user: User
) : Event()