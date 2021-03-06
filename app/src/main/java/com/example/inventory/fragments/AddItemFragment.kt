package com.example.inventory.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.inventory.R
import com.example.inventory.repositories.InventoryRepository

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AddItemFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val inventoryViewModel : InventoryViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameItemEditTextView :EditText = view.findViewById(R.id.name_edittext)
        val priceItemEditTextView :EditText = view.findViewById(R.id.price_edittext)
        val inStockItemCheckBox :CheckBox = view.findViewById(R.id.instock_checkBox)
        val saveButtonView :Button = view.findViewById(R.id.save_button)


        saveButtonView.setOnClickListener(){
            var nameItem = nameItemEditTextView.text.toString()
            var priceItem = priceItemEditTextView.text.toString().toDouble()
            var inStock = inStockItemCheckBox.isChecked

            inventoryViewModel.addItem(nameItem,priceItem,inStock)

            findNavController().popBackStack()
        }
    }
}