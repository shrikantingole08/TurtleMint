package com.test.shared.network

import com.test.shared.domain.model.ResponseModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

internal interface ApiClient {


    @GET("square/okhttp/issues")
    suspend fun callIssueList(/*@Query("page") page: Int*/): Deferred<Response<ResponseModel>>


}