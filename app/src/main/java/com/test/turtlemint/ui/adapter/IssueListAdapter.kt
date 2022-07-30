package com.test.turtlemint.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.shared.model.GitIssueResponseItem
import com.test.turtlemint.databinding.ItemIssueListBinding


class IssueListAdapter(private val listener: OnCardClickListener?) :
    RecyclerView.Adapter<IssueListAdapter.ViewHolder>() {
    private var list: List<GitIssueResponseItem>? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder { //inflate the layout file
        return ViewHolder(ItemIssueListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    fun setItemList(itemList: List<GitIssueResponseItem>) {
        list = itemList
        notifyItemRangeChanged(0, itemList.size)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list?.get(position)?.let { holder.setData(it) }
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    interface OnCardClickListener {
        fun onCLick(item: GitIssueResponseItem)
    }

    inner class ViewHolder(var binding: ItemIssueListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(item: GitIssueResponseItem) {
            binding.tvTitle.text = item.title
            binding.tvDesc.text = item.body?.take(200)

        }

    }

}