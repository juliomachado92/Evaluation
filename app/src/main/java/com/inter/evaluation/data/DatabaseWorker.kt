package com.inter.evaluation.data

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.inter.evaluation.util.USER_DATA_FILENAME
import kotlinx.coroutines.coroutineScope

class DatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open(USER_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->

                    val userType = object : TypeToken<List<User>>() {}.type
                    val userList: List<User> = Gson().fromJson(jsonReader, userType)

                    val database = AppDatabase.getInstance(applicationContext)
                    database.userDao().insertAll(userList)

                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "DatabaseWorker"
    }
}