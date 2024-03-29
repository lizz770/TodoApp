package com.example.todoapp.plcoding.cleanarchitecturenoteapp.feature_note.domain.model
//являеться классом данных
//объект для комнаты
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoapp.plcoding.cleanarchitecturenoteapp.ui.theme.*

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)