package com.test.shared.network.repository

import com.test.shared.core.base.BaseRepository
import com.test.shared.core.result.Results
import com.test.shared.model.GitIssueResponse
import com.test.shared.network.ApiService
import javax.inject.Inject

class IssueRepository @Inject constructor(
    private val service: ApiService,
    private val baseRepository: BaseRepository
) {

    suspend fun callList(): Results<GitIssueResponse> =
        baseRepository.safeApiCall(
            call = {
                service.callListAsync().await()
            },
            errorMessage = "Error occurred"
        )


}
