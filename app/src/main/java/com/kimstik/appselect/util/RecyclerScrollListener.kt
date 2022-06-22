package com.kimstik.appselect.util

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerScrollListener(private val linearLayoutManager: LinearLayoutManager): RecyclerView.OnScrollListener() {

    private var countAlreadySend: Int = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val itemCount = linearLayoutManager.itemCount
        val lastVisibleItem = linearLayoutManager.findFirstVisibleItemPosition()

        if(itemCount - lastVisibleItem < loadSize) {
            if(itemCount != countAlreadySend) {
                countAlreadySend = itemCount
                loadMore(itemCount)
            }
        }
    }

    abstract fun loadMore(itemCount: Int)

    companion object {
        const val loadSize: Int = 20
    }
}