package com.kimstik.appselect.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.kimstik.appselect.R
import com.kimstik.appselect.data.network.model.Results

class RecyclerAdapter: RecyclerView.Adapter<RecyclerViewHolder>() {

    private val list: MutableList<Results> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder =
        RecyclerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, null, false))

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.apply {
            tvName.text = list[position].display_title.toString()
            tvDescription.text = list[position].summary_short.toString()
        }
        Glide.with(holder.itemView)
                .load(list[position].multimedia?.src)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .error(R.drawable.ic_warning)
                .into(holder.iv)


    }

    override fun getItemCount(): Int = list.size

    fun updateData(extraList: List<Results>){
        val listSize: Int = list.size
        val extraListSize: Int = extraList.size
        list.addAll(listSize, extraList)
        notifyItemRangeInserted(listSize, extraListSize)
    }
}