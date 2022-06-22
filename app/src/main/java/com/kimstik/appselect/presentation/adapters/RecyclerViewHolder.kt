package com.kimstik.appselect.presentation.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kimstik.appselect.R

class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val tvName: TextView = itemView.findViewById(R.id.tvName)
    val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    val iv: ImageView = itemView.findViewById(R.id.iv)
}