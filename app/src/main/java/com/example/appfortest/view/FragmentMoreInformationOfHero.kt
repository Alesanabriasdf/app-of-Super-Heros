package com.example.appfortest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.appfortest.R
import com.example.appfortest.databinding.FragmentMoreInformationOfSuperHeroBinding

class FragmentMoreInformationOfHero : Fragment(R.layout.fragment_more_information_of_super_hero) {

    private lateinit var binding: FragmentMoreInformationOfSuperHeroBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val charid= setOf(arguments?.getString("descriptionOfSuperHero"))

        binding = FragmentMoreInformationOfSuperHeroBinding.bind(view)

        if (arguments?.getString("descriptionOfSuperHero") == "") {

            binding.labelDescription.isVisible = false
            binding.invitationToMoreUse.isVisible = false
            binding.tvIfThereIsNoDescription.isVisible = true
            binding.sorry.isVisible = true
            binding.arrowToBtn.isVisible = false

            binding.sorry.text = getString(R.string.sorry)
            binding.tvIfThereIsNoDescription.text =
                getString(R.string.there_is_no_description_string)

        } else {
            binding.tvForDescriptionOfHero.text = arguments?.getString("descriptionOfSuperHero")
        }
        binding.btnBackToList.setOnClickListener {
            it.findNavController().navigate(
                FragmentMoreInformationOfHeroDirections
                    .actionFragmentMoreInformationOfHeroToFragmentSuperHeroesList()
            )
        }
    }
}