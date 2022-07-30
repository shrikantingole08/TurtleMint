package com.test.shared.network

import com.test.shared.model.GitIssueResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

internal interface ApiClient {


    @GET("square/okhttp/issues")
    fun callIssueListAsync(/*@Query("page") page: Int*/): Deferred<Response<GitIssueResponse>>


}