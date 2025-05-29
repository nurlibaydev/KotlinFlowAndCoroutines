package kaa.nurlibaydev.coroutineandflowusecases.threads

import android.os.Handler
import android.os.Looper
import android.util.Log

var apiThread: Thread? = null

fun makeApiCall() {
    apiThread = Thread {
        try {
            // Simulate API call (e.g., w
            // ith Retrofit or HttpURLConnection)
            val result = ApiService.getData() // This is blocking
            Log.d("API_RESULT", result.toString())

            // If you need to update UI:
            Handler(Looper.getMainLooper()).post {
                // Update UI here
            }

        } catch (e: InterruptedException) {
            Log.d("THREAD", "Thread was interrupted")
        }
    }
    apiThread?.start()
}

fun cancelApiCall() {
    apiThread?.interrupt()
}


object ApiService {
    fun getData() { }
}