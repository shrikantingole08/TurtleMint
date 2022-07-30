package com.test.shared.core.base

import com.test.shared.core.result.Results
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class BaseRepository @Inject constructor() {
    suspend fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>,
        errorMessage: String
    ): Results<T> = try {
        val response = call.invoke()
        if (response.isSuccessful && response.code() == 200 || response.code() == 201) {
            Results.Success(response.body()!!)
        } else if (response.code() == 500) {
            Results.Error(IOException("Internal Server Error"))
        } else if (response.errorBody() != null) {
            Results.Error(IOException(response.errorBody()?.toString()))
        } else {
            Results.Error(IOException("Something error..."))
        }
    } catch (e: Exception) {
        Results.Error(IOException(errorMessage, e))
    }

    val <T> T.exhaustive: T get() = this
}