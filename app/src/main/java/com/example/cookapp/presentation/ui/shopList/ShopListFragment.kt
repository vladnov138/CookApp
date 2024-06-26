package com.example.cookapp.presentation.ui.shopList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cookapp.R
import com.example.cookapp.databinding.FragmentShoplistBinding
import com.example.cookapp.presentation.ShopListAdapter

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
    }
}