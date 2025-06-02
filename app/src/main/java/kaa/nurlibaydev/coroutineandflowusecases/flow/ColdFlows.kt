package kaa.nurlibaydev.coroutineandflowusecases.flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow

suspend fun main() = coroutineScope {

    val coldFlow = flow<Int> {
        repeat(5) {
            emit(it)
            println("Emitted $it")
        }
    }
}