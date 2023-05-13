package com.example.pagingtut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar

import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagingtut.adapters.myAdapter
import com.example.pagingtut.databinding.ActivityMainBinding
import com.example.pagingtut.viewModels.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel : CharacterViewModel by viewModels()
    lateinit var myadapter : myAdapter
    lateinit var mainxml : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        mainxml = ActivityMainBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(mainxml.root)
        setupRecyclerView()
        loadData()
    }

    private fun loadData() {
        viewModel.viewModelScope.launch {
            viewModel.characterFlow.collectLatest {
                myadapter.submitData(it)
            }
        }
    }

    private fun setupRecyclerView() {
        myadapter = myAdapter()
        mainxml.rvChar.apply {
            adapter = myadapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

    }
}