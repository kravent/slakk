package me.agaman.slackk.bot.result

data class ApiTestResult(
        val ok: Boolean,
        val error: String? = null,
        val args: Map<String, Any> = emptyMap()
)
