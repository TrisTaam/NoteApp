package com.tristaam.noteapp.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.tristaam.noteapp.R
import com.tristaam.noteapp.databinding.FragmentHomeBinding
import com.tristaam.noteapp.presentation.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBehavior()
    }

    private fun initBehavior() {
        initRecyclerViewNotes()
        binding.buttonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteDialogFragment)
        }
    }

    private fun initRecyclerViewNotes() {
        val noteAdapter = NoteAdapter {
            val bundle = bundleOf(Constant.NOTE_ID to it)
            findNavController().navigate(
                R.id.action_homeFragment_to_noteDetailDialogFragment,
                bundle
            )
        }
        binding.recyclerViewNotes.adapter = noteAdapter
        viewLifecycleOwner.lifecycleScope.launch {
            homeViewModel.allNotes.collect {
                noteAdapter.setNotes(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}