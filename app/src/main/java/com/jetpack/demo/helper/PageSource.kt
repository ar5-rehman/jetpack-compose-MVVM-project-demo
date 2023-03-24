package com.jetpack.demo.helper

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlin.math.max

class PageSource<T : Any>(private val loader: suspend (Int) -> PageData<T>) : PagingSource<Int, T>() {
    companion object {
        private const val MIN_PAGE = 0
    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val nextPage = params.key ?: MIN_PAGE
            val pageData = loader(nextPage)

            LoadResult.Page(
                data = pageData.data,
                prevKey = if (nextPage == MIN_PAGE) null else max(MIN_PAGE, nextPage - 1),
                nextKey = if (pageData.isEnd) null else nextPage + 1
            )
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }

    override val keyReuseSupported: Boolean
        get() = true
}