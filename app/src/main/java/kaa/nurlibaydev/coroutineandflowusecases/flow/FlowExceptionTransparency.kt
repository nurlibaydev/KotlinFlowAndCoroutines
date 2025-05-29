package kaa.nurlibaydev.coroutineandflowusecases.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val myFlow = flow {
        emit(1)
        emit(2)
        throw RuntimeException("Something went wrong!") // Cancels the flow
        emit(3) // Never gets executed
    }

    try {
        myFlow.collect { value ->
            println("Collected: $value")
        }
    } catch (e: Exception) {
        println("Caught exception: ${e.message}")
    }
}
