package com.example.pagingtut.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.example.pagingtut.R
import com.example.pagingtut.databinding.RecyclerItemBinding
import com.example.pagingtut.models.Character
import kotlinx.coroutines.withContext
import javax.inject.Inject

class myAdapter :
    PagingDataAdapter<Character, myAdapter.myViewHolder>(diffCallback) {



    inner class myViewHolder(val recyclerxml : RecyclerItemBinding) : ViewHolder(recyclerxml.root)

    companion object
    {

        val diffCallback = object :  DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       val view = RecyclerItemBinding.inflate(
           LayoutInflater.from(parent.context),parent,false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val character = getItem(position)
        holder.recyclerxml.apply {
            holder.itemView.apply {
                characterXmlData = character
            }
        }

    }




}

