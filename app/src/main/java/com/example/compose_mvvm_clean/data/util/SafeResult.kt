package com.example.compose_mvvm_clean.data.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import kotlin.coroutines.CoroutineContext

sealed class SafeResult<out T> {
    data class Success<T>(val data: T?): SafeResult<T>()
    data class GenericError(
        val code: Int? = null,
        val errorMessage: String? = "Something went wrong"
    ): SafeResult<Nothing>()
    object NetworkError: SafeResult<Nothing>()
}

suspend fun <T> safeApiCall(
    coroutineContext: CoroutineContext = Dispatchers.IO,
    apiCallFun: suspend () -> Response<T>
) : SafeResult<T> {
    return withContext(coroutineContext) {
        try {
            val response = apiCallFun.invoke()
            if(response.isSuccessful){
                SafeResult.Success(response.body())
            } else {
                SafeResult.GenericError(
                    response.code(),
                    response.message()
                )
            }
        } catch (throwable: Throwable) {
            when(throwable) {
                is HttpException -> {
                    SafeResult.GenericError(
                        throwable.code(),
                        throwable.localizedMessage
                    )
                }
                is IOException -> {
                    SafeResult.NetworkError
                }
                else -> {
                    SafeResult.GenericError(null, "Something went wrong")
                }
            }
        }

    }
}