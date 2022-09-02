package com.wenger.natifetask1.ui

sealed class MainEvent {

    class CheckItemId(val id: Int): MainEvent()
    object CreateList : MainEvent()
}