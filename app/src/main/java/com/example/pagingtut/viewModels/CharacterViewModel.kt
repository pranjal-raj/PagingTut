package com.example.pagingtut.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.pagingtut.Repository.CharacterRepository
import com.example.pagingtut.api.Api_Instance
import com.example.pagingtut.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(val characterRepository: CharacterRepository) : ViewModel() {

    lateinit var characterFlow: Flow<PagingData<Character>>
    init
    {
        getCharacterFlow()
    }


    private fun getCharacterFlow() {
        characterFlow = characterRepository.getAllCharacters()
        }
}

