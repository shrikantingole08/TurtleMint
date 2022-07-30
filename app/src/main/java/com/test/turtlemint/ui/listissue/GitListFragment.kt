package com.test.turtlemint.ui.listissue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.test.shared.model.GitIssueResponseItem
import com.test.turtlemint.base.BaseFragment
import com.test.turtlemint.base.viewModelProvider
import com.test.turtlemint.databinding.FragmentIssueListBinding
import com.test.turtlemint.ui.adapter.IssueListAdapter
import javax.inject.Inject

class GitListFragment : BaseFragment(), IssueListAdapter.OnCardClickListener {

    private var listAdapter: IssueListAdapter? = null
    private var _binding: FragmentIssueListBinding? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: GitListViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = viewModelProvider(viewModelFactory)

        _binding = FragmentIssueListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        setObserver()
        binding.progressBar.isVisible = true
    }

    private fun setObserver() {
        viewModel.listObserver.observe(viewLifecycleOwner) {
            listAdapter?.setItemList(it)
            binding.progressBar.isVisible = false

        }
        viewModel.callDetailList()
    }

    private fun initUI() {
        listAdapter = IssueListAdapter(this)
        binding.rvList.apply {
            this.adapter = listAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCLick(item: GitIssueResponseItem) {

    }
}