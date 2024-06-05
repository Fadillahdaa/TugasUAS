package com.kelmobile.tugasuas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdaptor(private val menuList: List<MenuItem>) :
    RecyclerView.Adapter<MenuAdaptor.MenuViewHolder>() {

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageMenu: ImageView = itemView.findViewById(R.id.imageMenu)
        val textMenuName: TextView = itemView.findViewById(R.id.textMenuName)
        val textMenuDescription: TextView = itemView.findViewById(R.id.textMenuDescription)
        val textMenuPrice: TextView = itemView.findViewById(R.id.textMenuPrice)
        val buttonIncrease: ImageButton = itemView.findViewById(R.id.buttonIncrease)
        val buttonDecrease: ImageButton = itemView.findViewById(R.id.buttonDecrease)
        val textQuantity: TextView = itemView.findViewById(R.id.textQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val currentItem = menuList[position]
        holder.textMenuName.text = currentItem.name
        holder.textMenuDescription.text = currentItem.description
        holder.textMenuPrice.text = "Price: $${currentItem.price}"
        holder.textQuantity.text = "0" // Default quantity

        // Set image resource here
        holder.imageMenu.setImageResource(R.drawable.minuman) // Example image

        holder.buttonIncrease.setOnClickListener {
            val quantity = holder.textQuantity.text.toString().toInt() + 1
            holder.textQuantity.text = quantity.toString()
        }

        holder.buttonDecrease.setOnClickListener {
            val quantity = holder.textQuantity.text.toString().toInt()
            if (quantity > 0) {
                holder.textQuantity.text = (quantity - 1).toString()
            }
        }
    }

    override fun getItemCount() = menuList.size
}
