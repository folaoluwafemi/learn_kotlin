package com.example.learnkotlin.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.learnkotlin.R
import com.example.learnkotlin.data.KotlinTopics
import android.widget.Toast

class ItemAdapter(private val context: Context, private val kotlinTopics: List<KotlinTopics>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    companion object{
        const val URL_1: String = "https://developer.android.com/kotlin/learn#variables"
        const val URL_2: String = "https://developer.android.com/kotlin/learn#conditionals"
        const val URL_3: String = "https://developer.android.com/kotlin/learn#functions"
        const val URL_4: String = "https://developer.android.com/kotlin/learn#classes"
    }
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val topicText: TextView = view.findViewById(R.id.recycler_text)
        val topicImage: ImageView = view.findViewById(R.id.recycler_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val basicLayout = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_topics, parent, false)
        return ItemViewHolder(basicLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.topicText.text = context.resources.getString(kotlinTopics[position].stringResourceId)
        holder.topicImage.setImageResource(kotlinTopics[position].imageResourceId)
        holder.topicText.setOnClickListener{
            when(position){
                0 -> context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(URL_1)))
                1 -> context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(URL_2)))
                2 -> context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(URL_3)))
                3 -> context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(URL_4)))
                else -> Toast.makeText(this.context, "you clicked an invalid text", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = kotlinTopics.size
}