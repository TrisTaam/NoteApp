package com.tristaam.noteapp.presentation.ui.notedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tristaam.noteapp.databinding.FragmentNoteDetailDialogBinding
import com.tristaam.noteapp.presentation.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteDetailDialogFragment : DialogFragment() {
    private var _binding: FragmentNoteDetailDialogBinding? = null
    private val binding get() = _binding!!
    private val noteDetailViewModel: NoteDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteDetailDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBehavior()
    }

    private fun initBehavior() {
        receiveNote()
        binding.buttonSave.setOnClickListener {
            saveNote(binding.editTextContent.text.toString())
        }
        binding.buttonDelete.setOnClickListener {
            deleteNote()
        }
    }

    private fun receiveNote() {
        noteDetailViewModel.setNote(arguments?.getInt(Constant.NOTE_ID)!!)
        viewLifecycleOwner.lifecycleScope.launch {
            noteDetailViewModel.note.collect { note ->
                binding.editTextContent.setText(note?.content)
            }
        }
    }

    private fun saveNote(content: String) {
        if (content.isEmpty()) return
        noteDetailViewModel.saveNote(content)
        dismiss()
    }

    private fun deleteNote() {
        noteDetailViewModel.deleteNote()
        dismiss()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}