package com.test.turtlemint.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.shared.model.comments.CommentResItem
import com.test.turtlemint.databinding.ItemCommentBinding
import com.test.turtlemint.utils.formatDate


class CommentsListAdapter(private val listener: OnCardClickListener?) :
    RecyclerView.Adapter<CommentsListAdapter.ViewHolder>() {
    private var list: List<CommentResItem>? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder { //inflate the layout file
        return ViewHolder(ItemCommentBinding.inflate(LayoutInflater.from(parent.context)))
    }

    fun setItemList(itemList: List<CommentResItem>) {
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
        fun onCLick(item: CommentResItem)
    }

    inner class ViewHolder(var binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(item: CommentResItem) {
            binding.tvAuthor.text = item.authorAssociation
            binding.tvDesc.text = item.body
            binding.tvDate.text = item.createdAt?.formatDate() ?: ""

        }

    }

}