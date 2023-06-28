package com.example.todoapp.plcoding.cleanarchitecturenoteapp.feature_note.domain.util


sealed class OrderType {
    //по возрастанию
    object Ascending: OrderType()
    //по убыванию
    object Descending: OrderType()
}