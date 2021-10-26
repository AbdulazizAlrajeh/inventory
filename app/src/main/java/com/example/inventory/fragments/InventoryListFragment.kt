package com.example.inventory.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.R
import com.example.inventory.database.models.ItemModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class InventoryListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val inventoryItems = mutableListOf<ItemModel>()
    private val inventoryViewModel : InventoryViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventory_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inventoryRecycleView:RecyclerView = view.findViewById(R.id.recyclerView)
        val addFloatingActionButton: FloatingActionButton = view.findViewById(R.id.floatingActionButton)





        val inventoryAdapter = InventoryAdapter(inventoryItems,inventoryViewModel)
        inventoryRecycleView.adapter = inventoryAdapter

        inventoryViewModel.inventoryItem.observe(viewLifecycleOwner, Observer {
            it?.let {items ->
                inventoryItems.clear()
                inventoryItems.addAll(items)
                inventoryAdapter.notifyDataSetChanged()

            }
        })

        addFloatingActionButton.setOnClickListener(){
            findNavController().navigate(R.id.action_inventoryListFragment_to_addItemFragment)
            /*requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
                AddItemFragment()

            ).commit()*/
            //  findNavController().popBackStack()
        }




    }
}