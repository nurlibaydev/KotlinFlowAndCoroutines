package kaa.nurlibaydev.coroutineandflowusecases.flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    launch {
        stocksFlow()
            .onCompletion { cause ->
                if(cause == null) {
                    println("Stocks flow completed successfully")
                } else {
                    println("Stocks flow completed with error: ${cause.message}")
                }
            }
            .onEach { value ->
                // throw Exception("Error occurred")
                println("Received value: $value")
            }
            .catch {
                println("Error occurred: ${it.message}")
            }.launchIn(this@coroutineScope)
    }
}

private fun stocksFlow(): Flow<String> = flow {
    emit("Apple")
    emit("Microsoft")
    throw Exception("Network request failed!")
}