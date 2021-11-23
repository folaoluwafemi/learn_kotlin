package com.example.learnkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.learnkotlin.R
import com.example.learnkotlin.databinding.FragmentSignInBinding
import com.example.learnkotlin.model.LearnerViewModel


class SignIn : Fragment() {
    lateinit var navCon: NavController
    private lateinit var _binding: FragmentSignInBinding
    private val sharedViewModel: LearnerViewModel by activityViewModels()
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = this
    }

    fun signIn() {
        if(binding.signinEmail.text.toString() == sharedViewModel.email.value && binding.signinPassword.text.toString() == sharedViewModel.password.value)
            navCon.navigate(R.id.action_signIn_to_onboarding)
        else if(binding.signinPassword.text.toString() != sharedViewModel.password.value)
            Toast.makeText(this.requireContext(), "wrong password, try again", Toast.LENGTH_SHORT).show()
        else if(binding.signinEmail.text.toString() != sharedViewModel.email.value)
            Toast.makeText(this.requireContext(), "check your email, and try again", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this.requireContext(), "wrong details, check and try again", Toast.LENGTH_SHORT).show()
    }
}