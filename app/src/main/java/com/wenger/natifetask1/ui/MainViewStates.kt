package com.wenger.natifetask1.ui

sealed class MainViewStates  {

    class  LastItemShowedState(val lastItemId: Int): MainViewStates()
}