package kaa.nurlibaydev.coroutineandflowusecases.flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

suspend fun main(): Unit = coroutineScope {

    runCatching {
        flow {
            emit(1)
        }
            .catch { e -> println("Caught exception in flow: ${e.message}") } // Handles flow exceptions
            .collect { emittedValue ->
                throw Exception("Exception in collect {} ") // Now handled by runCatching
            }

    }.onFailure { e -> println("Caught exception after collect: ${e.message}") }
}