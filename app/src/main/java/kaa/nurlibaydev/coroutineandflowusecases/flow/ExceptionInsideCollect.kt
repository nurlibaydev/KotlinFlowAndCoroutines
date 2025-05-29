package kaa.nurlibaydev.coroutineandflowusecases.flow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val myFlow = flow {
        emit(1)
        emit(2)
        throw RuntimeException("Something went wrong!") // Flow cancels here
    }.catch { e ->
        println("Caught exception in flow: ${e.message}")
        emit(999) // Recover by emitting a fallback value
    }

    myFlow.collect { value ->
        println("Collected: $value")
    }
}