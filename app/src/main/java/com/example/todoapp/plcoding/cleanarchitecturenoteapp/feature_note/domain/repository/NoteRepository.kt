package com.example.todoapp.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository

import com.example.todoapp.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    //возвращает поток списков типов узлов
    fun getNotes(): Flow<List<Note>>
    //приостановка получения узла по айди
    suspend fun getNoteById(id: Int): Note?

    //для вставки
    suspend fun insertNote(note: Note)
    //для удаления
    suspend fun deleteNote(note: Note)
}
