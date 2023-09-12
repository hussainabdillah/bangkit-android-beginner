package com.dicoding.valorantapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListAgentAdapter(private val listAgent: ArrayList<Agent>) : RecyclerView.Adapter<ListAgentAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_agent, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listAgent[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_agent_name", listAgent[holder.adapterPosition].name)
            intentDetail.putExtra("key_agent_description", listAgent[holder.adapterPosition].description)
            intentDetail.putExtra("key_agent_image_id", listAgent[holder.adapterPosition].photo)
            intentDetail.putExtra("key_agent_image_detail", listAgent[holder.adapterPosition].photoDetail)
            intentDetail.putExtra("key_agent_role", listAgent[holder.adapterPosition].role)
            intentDetail.putExtra("key_agent_origin", listAgent[holder.adapterPosition].origin)
            intentDetail.putExtra("key_agent_gender", listAgent[holder.adapterPosition].gender)
            intentDetail.putExtra("key_agent_biography", listAgent[holder.adapterPosition].biography)
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listAgent.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById((R.id.tv_item_description))
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Agent)

    }
}


