package com.project.newsapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.core.abstraction.BaseViewHolder
import com.project.core.abstraction.PagingRecyclerViewAdapter
import com.project.core.model.model.Source
import com.project.newsapp.databinding.ItemSourceBinding

class SourceAdapter : PagingRecyclerViewAdapter<SourceAdapter.ViewHolder, Source>() {

    private var onClick: ((Source) -> Unit)? = null

    override val holderInflater: (LayoutInflater, ViewGroup, Boolean) -> ViewHolder
        get() = { inflater, viewGroup, boolean ->
            ViewHolder(ItemSourceBinding.inflate(inflater, viewGroup, boolean))
        }

    inner class ViewHolder(itemView: ItemSourceBinding) :
        BaseViewHolder<Source, ItemSourceBinding>(itemView) {
        override fun bind(data: Source) {
            with(binding) {
                tvSource.text = data.name
                tvDesc.text = data.description

                root.setOnClickListener {
                    onClick?.invoke(data)
                }
            }

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    fun setOnClickData(onClick: (data: Source) -> Unit) {
        this.onClick = onClick
    }
}