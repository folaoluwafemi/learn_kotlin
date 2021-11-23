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
import com.example.learnkotlin.databinding.FragmentSignUpBinding
import com.example.learnkotlin.model.LearnerViewModel


class SignUp : Fragment() {
    lateinit var navCon: NavController
    private lateinit var _binding: FragmentSignUpBinding
    private val sharedViewModel: LearnerViewModel by activityViewModels()
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = this
    }

    fun signUp(){
        sharedViewModel.setName(binding.signupName.text.toString())
        sharedViewModel.setUserName(binding.signupUsername.text.toString())
        sharedViewModel.setEmail(binding.signupEmail.text.toString())
            if (binding.signupPassword.text.toString() == binding.confirmPassword.text.toString()) {
                sharedViewModel.setPassword(binding.signupPassword.text.toString())
                if(!sharedViewModel.hasAccount())
                    Toast.makeText(this.context, "you haven't completed this form!!", Toast.LENGTH_SHORT).show()
                else
                    navCon.navigate(R.id.action_signUp_to_onboarding)
            }
            else Toast.makeText(this.requireContext(), "the passwords don't match", Toast.LENGTH_SHORT).show()
    }
}