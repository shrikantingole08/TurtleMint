package com.test.shared.network

import com.test.turtlemint.BuildConfig
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class ApiService @Inject constructor(
    builder: Retrofit.Builder
) {


    private val apiClient =
        builder.baseUrl(BuildConfig.baseUrl)
            .build().create(ApiClient::class.java)


    suspend fun callListAsync() =
        apiClient.callIssueList()

}
