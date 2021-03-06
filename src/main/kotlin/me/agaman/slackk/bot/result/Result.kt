package me.agaman.slackk.bot.result

import me.agaman.slackk.bot.exception.SlackkResultError

data class Result<T>(
        private val result: T?,
        private val error: String?
) {
    companion object {
        fun <T> success(result: T) = Result(error = null, result = result)
        fun <T> error(error: String) = Result<T>(error = error, result = null)
    }

    fun isSuccess() = result != null
    fun get() : T = result ?: throw createThrowable()
    fun getOrNull() : T? = result
    fun throwIfError() { get() }

    fun success(job: (T) -> Unit) : Result<T> {
        result?.let { job(it) }
        return this
    }
    fun error(job: (SlackkResultError) -> Unit) : Result<T> {
        error?.let { job(createThrowable()) }
        return this
    }

    private fun createThrowable() = SlackkResultError(error ?: "")
}
