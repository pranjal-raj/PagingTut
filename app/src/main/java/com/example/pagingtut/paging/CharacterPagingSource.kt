package com.example.pagingtut.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingtut.api.Api_Instance
import com.example.pagingtut.api.api_interface
import com.example.pagingtut.models.CharacterResponse
import okhttp3.ResponseBody
import java.io.IOException

class CharacterPagingSource(private val service : api_interface) : PagingSource<Int, com.example.pagingtut.models.Character>() {
   override suspend fun load(params: LoadParams<Int>): LoadResult<Int, com.example.pagingtut.models.Character> {

       val pageNumber = params.key?:1

       return try{

           val response = service.getAllCharacters(pageNumber)
           val pagedResponse = response.body()
           val dataMutable = mutableListOf<com.example.pagingtut.models.Character>()
           val data = pagedResponse?.results
           dataMutable.addAll(data.orEmpty())


           LoadResult.Page(
               data = data.orEmpty(),
               prevKey = if (pageNumber == 1) null else -1,
               nextKey = pageNumber.plus(1)
               )
       }catch (e : Exception)
       {
           Log.d("PagingSource", "Exception : ${e.message}")
           return LoadResult.Error(e)
       }
    }

    override fun getRefreshKey(state: PagingState<Int, com.example.pagingtut.models.Character>): Int? = null

}