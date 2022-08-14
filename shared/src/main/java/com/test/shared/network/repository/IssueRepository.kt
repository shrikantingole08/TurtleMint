package com.test.shared.network.repository

import com.test.shared.core.base.BaseRepository
import com.test.shared.core.result.Results
import com.test.shared.model.GitIssueResponse
import com.test.shared.model.comments.CommentRes
import com.test.shared.model.room.GitListItem
import com.test.shared.network.ApiService
import com.test.shared.room.GitListDao
import javax.inject.Inject

class IssueRepository @Inject constructor(
    private val service: ApiService,
    private val baseRepository: BaseRepository,
    private val dao: GitListDao
) {

    suspend fun callList(): Results<List<GitListItem>> =
        baseRepository.safeApiCall(
            call = {
                service.callListAsync().await()
            },
            errorMessage = "Error occurred"
        ).run {
            (this as? Results.Success) ?: this
            (this as? Results.Success)?.data?.let {
                dao.insert(convert(it))
            }
            Results.Success(dao.list() ?: arrayListOf())
        }

    private fun convert(list: GitIssueResponse): ArrayList<GitListItem> {
        return arrayListOf<GitListItem>().apply {
            list.forEach {
                add(
                    GitListItem(
                        it.id,
                        it.title,
                        it.body?.take(200),
                        it.user?.login,
                        it.user?.avatarUrl,
                        it.createdAt,
                        it.commentsUrl
                    )
                )
            }
        }
    }


    suspend fun loadComments(commentUrl: String): Results<CommentRes> =
        baseRepository.safeApiCall(
            call = {
                service.loadComments(commentUrl).await()
            },
            errorMessage = "Error occurred"
        )

}
