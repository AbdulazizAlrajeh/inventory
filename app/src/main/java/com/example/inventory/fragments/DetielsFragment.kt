package com.example.inventory.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.inventory.R
import com.example.inventory.database.models.ItemModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetielsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val inventoryViewModel : InventoryViewModel by activityViewModels()
    private lateinit var selectItemModel :ItemModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detiels, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameItemTextView :TextView = view.findViewById(R.id.nameitem_textview)
        val priceItemTextView :TextView = view.findViewById(R.id.itemprice_textview)
        val inStockTextView :TextView = view.findViewById(R.id.instock_textview)
        val deleteButtonView :Button = view.findViewById(R.id.delete_button)

        inventoryViewModel.selectedItemMutableLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                nameItemTextView.text = it.name
                priceItemTextView.text = "${ it.price} SAR"
                inStockTextView.text = "In Stock ${ it.inStock }"
                selectItemModel = it
            }
        })

        deleteButtonView.setOnClickListener(){

            inventoryViewModel.deleteItem(selectItemModel)
            findNavController().popBackStack()
        }
    }
}