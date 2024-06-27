package com.example.cookapp.presentation.ui.shopList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.cookapp.databinding.FragmentShoplistBinding

class ShopListFragment : Fragment() {

    private var _binding: FragmentShoplistBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ShopListAdapter
    private lateinit var viewModel: ShopListViewModel
    private lateinit var shopListAdapter: ShopListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this).get(ShopListViewModel::class.java)

        _binding = FragmentShoplistBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.shopList.observe(viewLifecycleOwner) {
            shopListAdapter.submitList(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        with(binding.rvShopList) {
            shopListAdapter = ShopListAdapter()
            adapter = shopListAdapter
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.VIEW_TYPE_NOT_BOUGHT,
                ShopListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.VIEW_TYPE_BOUGHT,
                ShopListAdapter.MAX_POOL_SIZE
            )
        }
        setupSwipeListener(binding.rvShopList)
        setupClickListener()
    }

    private fun setupSwipeListener(rvShopList: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = shopListAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteShopItem(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvShopList)
    }

    private fun setupClickListener() {
        shopListAdapter.onShopItemClickListener = {
            val action = ShopListFragmentDirections.actionNavigationShoplistToShopItemFragment()
            findNavController().navigate(action)
        }
    }
}