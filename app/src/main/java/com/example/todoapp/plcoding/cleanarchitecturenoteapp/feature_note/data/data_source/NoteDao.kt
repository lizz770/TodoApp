package com.example.todoapp.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source
//Crud система
import androidx.room.*
import com.example.todoapp.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {
    //все записи
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    //по id
    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    //добавление
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)
    //удаление
    @Delete
    suspend fun deleteNote(note: Note)
}