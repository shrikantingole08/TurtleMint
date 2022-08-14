package com.test.turtlemint.ui.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.test.shared.model.comments.CommentResItem
import com.test.shared.model.room.GitListItem
import com.test.turtlemint.base.BaseFragment
import com.test.turtlemint.base.viewModelProvider
import com.test.turtlemint.databinding.FragmentIssueListBinding
import com.test.turtlemint.ui.adapter.CommentsListAdapter
import javax.inject.Inject

class CommentsFragment : BaseFragment(), CommentsListAdapter.OnCardClickListener {

    private var listAdapter: CommentsListAdapter? = null
    private var _binding: FragmentIssueListBinding? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CommentsViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = viewModelProvider(viewModelFactory)

        _binding = FragmentIssueListBinding.inflate(inflater, container, false)
        viewModel.item = arguments?.getParcelable<GitListItem>("data")
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        setObserver()
        binding.progressBar.isVisible = true
        viewModel.loadComments()
    }

    private fun setObserver() {
        viewModel.listObserver.observe(viewLifecycleOwner) {
            listAdapter?.setItemList(it)
            binding.progressBar.isVisible = false

        }
        viewModel.failure.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
            binding.progressBar.isVisible = false

        }
        viewModel.loadComments()
    }

    private fun initUI() {
        listAdapter = CommentsListAdapter(this)
        binding.rvList.apply {
            this.adapter = listAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onCLick(item: CommentResItem) {
    }
}