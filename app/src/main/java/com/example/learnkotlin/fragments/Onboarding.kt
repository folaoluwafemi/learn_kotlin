package com.example.learnkotlin.fragments
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.learnkotlin.R
import com.example.learnkotlin.adapter.ItemAdapter
import com.example.learnkotlin.data.Datasource
import com.example.learnkotlin.databinding.FragmentOnboardingBinding


class Onboarding : Fragment() {
    lateinit var navCon: NavController
    private lateinit var _binding: FragmentOnboardingBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.viewModel = this
        binding.adapter = ItemAdapter(this.requireContext(), Datasource().load_topics())
        requireActivity().onNavigateUp()
    }
}