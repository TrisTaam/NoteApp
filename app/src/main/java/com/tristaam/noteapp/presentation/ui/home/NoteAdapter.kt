package com.tristaam.noteapp.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tristaam.noteapp.databinding.ItemNoteBinding
import com.tristaam.noteapp.domain.model.Note
import com.tristaam.noteapp.presentation.util.AdapterAutoUpdatable

class NoteAdapter(
    private val onItemClick: (Int) -> Unit
) : Adapter<NoteAdapter.NoteViewHolder>(), AdapterAutoUpdatable {
    private val notes = mutableListOf<Note>()

    inner class NoteViewHolder(private val binding: ItemNoteBinding) : ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.textViewTitle.text = note.content
            binding.root.setOnClickListener {
                onItemClick(note.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    fun setNotes(notes: List<Note>) {
        autoNotify(
            oldList = this.notes,
            newList = notes,
            compare = { old, new -> old.id == new.id }
        )
        this.notes.clear()
        this.notes.addAll(notes)
    }
}