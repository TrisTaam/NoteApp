package com.tristaam.noteapp.presentation.ui.addnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.tristaam.noteapp.databinding.FragmentAddNoteDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteDialogFragment : DialogFragment() {
    private var _binding: FragmentAddNoteDialogBinding? = null
    private val binding get() = _binding!!
    private val addNoteViewModel: AddNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNoteDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBehavior()
    }

    private fun initBehavior() {
        binding.buttonAdd.setOnClickListener {
            addNote(binding.editTextContent.text.toString())
        }
    }

    private fun addNote(content: String) {
        if (content.isEmpty()) return
        addNoteViewModel.addNote(content)
        dismiss()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}