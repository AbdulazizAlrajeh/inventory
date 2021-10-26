package com.example.inventory.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.R
import com.example.inventory.database.models.ItemModel

class InventoryAdapter(val listItem:List<ItemModel>,val viewModel :InventoryViewModel)
    : RecyclerView.Adapter<InventoryAdapter.ViewHoldItem>() {

    class ViewHoldItem(view: View):RecyclerView.ViewHolder(view){
        var nameItemTextView :TextView = view.findViewById(R.id.item_textview)
        var priceItemTextView :TextView = view.findViewById(R.id.price_textView)
        var inStock : CheckBox = view.findViewById(R.id.instock_checkbox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InventoryAdapter.ViewHoldItem {
        return ViewHoldItem(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHoldItem, position: Int) {
        val item = listItem[position]
        holder.nameItemTextView.text = item.name
        holder.priceItemTextView.text = item.price.toString()
        holder.inStock.isChecked = item.inStock

        holder.itemView.setOnClickListener(){
            // it is view
            // for send item to fragment details
            viewModel.selectedItemMutableLiveData.postValue(item)
            it.findNavController().navigate(R.id.action_inventoryListFragment_to_detielsFragment)
        }
        // b is result change
        holder.inStock.setOnClickListener{
            item.inStock = holder.inStock.isChecked
            viewModel.updateItem(item)
        }



    }

    override fun getItemCount(): Int = listItem.size
}