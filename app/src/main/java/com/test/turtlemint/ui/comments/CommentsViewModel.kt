package com.test.turtlemint.ui.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.test.shared.core.result.Results
import com.test.shared.model.comments.CommentRes
import com.test.shared.model.room.GitListItem
import com.test.shared.network.repository.IssueRepository
import com.test.shared.network.repository.PreferenceStorage
import com.test.turtlemint.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CommentsViewModel @Inject constructor(
    private val repository: IssueRepository,
    val preferenceStorage: PreferenceStorage
) :
    BaseViewModel() {

    private fun handleFailure(exception: Exception) {
        failure.postValue(exception.message.toString())
    }

    private fun handleResult(response: CommentRes) {
        _listObserver.postValue(response)
    }

    fun loadComments() {
        item?.commentUrl ?: return
        loading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.loadComments(item?.commentUrl!!)) {
                is Results.Success -> handleResult(result.data)
                is Results.Error -> handleFailure(result.exception)
                else -> {}
            }
            loading.postValue(false)
        }
    }

    var item: GitListItem? = null
    private val _listObserver = MutableLiveData<CommentRes>()
    val listObserver: LiveData<CommentRes> = _listObserver

}
