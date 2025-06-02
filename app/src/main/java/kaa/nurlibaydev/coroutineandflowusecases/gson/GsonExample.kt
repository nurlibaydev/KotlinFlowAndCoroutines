package kaa.nurlibaydev.coroutineandflowusecases.gson

import com.google.gson.Gson

data class User(val id: Int, val name: String)

fun main() {

    val user1 = User(1, "John Doe")
    val jsonUser1 = Gson().toJson(user1)
    // println(jsonUser1)

    val user2 = Gson().fromJson(jsonUser1, User::class.java)
    //println(user2)

    val jsonUser2 = """
        {
            "id": "Nurlibay",
            "name": "Jane Smith"
        }
    """.trimIndent()
    val user3 = Gson().fromJson(jsonUser2, User::class.java)
    println(user3)
}