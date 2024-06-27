package com.example.cookapp.presentation.ui.recipes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cookapp.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RecipesViewModel
    private lateinit var recipesAdapter: RecipesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this).get(RecipesViewModel::class.java)

        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.recipes.observe(viewLifecycleOwner) {
            recipesAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        with(binding.rvRecipes) {
            recipesAdapter = RecipesAdapter(IngredientsAdapter())
            adapter = recipesAdapter
        }
    }
}