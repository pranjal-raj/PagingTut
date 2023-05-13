package com.example.pagingtut.Repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pagingtut.api.api_interface
import com.example.pagingtut.models.Character
import com.example.pagingtut.paging.CharacterPagingSource
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CharacterRepository @Inject constructor(val api : api_interface) {

     fun getAllCharacters() : Flow<PagingData<Character>> {
        return Pager(PagingConfig(pageSize = 20)) {
            CharacterPagingSource(api)
        }.flow
     }
}