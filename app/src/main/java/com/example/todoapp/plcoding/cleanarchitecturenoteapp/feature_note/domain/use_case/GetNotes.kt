package com.example.todoapp.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.example.todoapp.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.example.todoapp.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.example.todoapp.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder
import com.example.todoapp.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    //ссылка на хранилище узлов
    private val repository: NoteRepository
) {
    //вводим по реализации бизнес логики фильтрация
    operator fun invoke(
        //по дате по умолчанию
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType) {
                //когда возрастающим
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                //когда убывающим
                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}