package com.example.offzmi.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.offzmi.R
import com.example.offzmi.repository.backend.models.PublicationItemDto

//class PublishesAdapter(
//    private val context: Context,
//    private val dataset: List<PublicationItemDto>,
//
//) : RecyclerView.Adapter<PublishesAdapter.ItemViewHolder>() {
//
//    class ItemViewHolder(view: View) :
//        RecyclerView.ViewHolder(view) {
//        val userName: TextView = view.findViewById(R.id.userName)
//        val date: TextView = view.findViewById(R.id.date)
//        val description: TextView = view.findViewById(R.id.description)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        val adapterlayout = LayoutInflater.from(parent.context)
//            .inflate(R.layout.list_item, parent, false)
//        return ItemViewHolder(adapterlayout)
//    }
//
//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        holder.description.text = context.resources.getString()
//
//    }
//}