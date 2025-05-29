package kaa.nurlibaydev.coroutineandflowusecases.flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach

suspend fun main(): Unit = coroutineScope{

    flow {
        emit(1)
    }.onEach {
        println("onEach: $it")
    }.catch {
        println("Caught $it") // doesn't catch downstream exceptions
    }.collect { emittedValue ->
        throw Exception("Exception in collect {} ")
    }
}

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}

//fun main1() = runBlocking<Unit> {
//    simple()
//        .catch { e -> println("Caught $e") } // does not catch downstream exceptions
//        .collect { value ->
//            check(value <= 1) { "Collected $value" }
//            println(value)
//        }
//}

//fun main() = runBlocking<Unit> {
//    simple()
//        .onEach { value ->
//            check(value <= 1) { "Collected $value" }
//            println(value)
//        }
//        .catch { e -> println("Caught $e") } // does not catch downstream exceptions
//        .collect()
//}