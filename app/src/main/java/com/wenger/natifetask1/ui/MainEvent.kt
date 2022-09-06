package com.wenger.natifetask1.ui

sealed class MainEvent {

    class CheckItemId(val id: Int): MainEvent()
    class ItemIdChecked(val lastId: Int, val isIdExist: Boolean): MainEvent()
    object CreateList : MainEvent()
    object ListCreated: MainEvent()
}