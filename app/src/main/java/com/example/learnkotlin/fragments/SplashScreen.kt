package com.example.learnkotlin.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.learnkotlin.R
import com.example.learnkotlin.databinding.FragmentSplashScreenBinding
import com.example.learnkotlin.model.LearnerViewModel


class SplashScreen : Fragment() {
    private lateinit var navCon: NavController
    private lateinit var _binding: FragmentSplashScreenBinding
    private val binding get()= _binding
    private val sharedViewModel: LearnerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       binding.viewModel = this
    }

    fun navigateToNextFragment(){
        if(sharedViewModel.hasAccount())
            navCon.navigate(R.id.action_splashScreen_to_signIn)
        else
            navCon.navigate(R.id.action_splashScreen_to_signUp)
    }
}