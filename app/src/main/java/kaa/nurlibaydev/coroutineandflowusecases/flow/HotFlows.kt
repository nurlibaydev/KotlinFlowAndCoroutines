package kaa.nurlibaydev.coroutineandflowusecases.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {

    val sharedFlow = MutableSharedFlow<Int>(replay = 0)

    val job1 = launch {
        sharedFlow.collect {
            println("Collector 1: $it")
        }
    }

    val job2 = launch {
        sharedFlow.collect {
            println("Collector 2: $it")
        }
    }

    delay(100) // Let collectors start

    sharedFlow.emit(42)
}