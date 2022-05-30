package com.example.appfortest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.appfortest.R
import com.example.appfortest.databinding.FragmentSuperHeroesListBinding
import com.example.appfortest.view.recyclertools.SuperHeroesListAdapter
import com.example.appfortest.viewmodel.SuperHeroesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSuperHeroesList : Fragment(R.layout.fragment_super_heroes_list) {

    private val superHeroListViewModel: SuperHeroesListViewModel by viewModels()

    private lateinit var binding: FragmentSuperHeroesListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSuperHeroesListBinding.bind(view)

        superHeroListViewModel.onGetAllHeroes()

        superHeroListViewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }

        superHeroListViewModel.listOfAllHeroes.observe(viewLifecycleOwner) {
            binding.rvForAllHeroes.adapter = SuperHeroesListAdapter(it!!)

        }

        superHeroListViewModel.showError.observe(viewLifecycleOwner) {
            binding.tvForError.isVisible = it
        }
    }
}
