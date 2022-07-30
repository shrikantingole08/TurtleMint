package com.test.turtlemint.ui.listissue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.test.shared.core.result.Results
import com.test.shared.model.GitIssueResponse
import com.test.shared.model.GitIssueResponseItem
import com.test.shared.network.repository.IssueRepository
import com.test.shared.network.repository.PreferenceStorage
import com.test.turtlemint.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GitListViewModel @Inject constructor(
    private val repository: IssueRepository,
    val preferenceStorage: PreferenceStorage
) :
    BaseViewModel() {


    fun callDetailList() {
        loading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.callList()) {
                is Results.Success -> handleResult(result.data)
                is Results.Error -> handleFailure(result.exception)
                else -> {}
            }
            loading.postValue(false)
        }
    }

    private fun handleFailure(exception: Exception) {
        failure.postValue(exception.message.toString())
    }

    private fun handleResult(response: GitIssueResponse) {
        _listObserver.postValue(response)
    }

    private val _listObserver = MutableLiveData<ArrayList<GitIssueResponseItem>>()
    val listObserver: LiveData<ArrayList<GitIssueResponseItem>> = _listObserver

}
