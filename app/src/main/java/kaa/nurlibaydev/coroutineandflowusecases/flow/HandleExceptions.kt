package kaa.nurlibaydev.coroutineandflowusecases.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun main(): Unit = coroutineScope {
    flow {
        emit(1)
    }
        .onEach { emittedValue ->
            throw Exception("Exception in collect {} ") // ❌ Still throws, needs handling separately
        }
        .catch { e -> println("Caught exception in flow: ${e.message}") } // ✅ Correct way to handle flow exceptions
        .launchIn(this)
}
