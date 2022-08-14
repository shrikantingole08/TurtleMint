package com.test.shared.network

import com.test.shared.model.GitIssueResponse
import com.test.shared.model.comments.CommentRes
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

internal interface ApiClient {


    @GET("square/okhttp/issues")
    fun callIssueListAsync(/*@Query("page") page: Int*/): Deferred<Response<GitIssueResponse>>


    @GET
    fun callListComments(@Url url: String): Deferred<Response<CommentRes>>


}