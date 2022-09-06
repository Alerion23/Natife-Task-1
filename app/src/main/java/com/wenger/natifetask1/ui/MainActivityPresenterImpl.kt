package com.wenger.natifetask1.ui

import com.wenger.natifetask1.base.Interactor

class MainActivityPresenterImpl(
    private val view: MainActivityView,
    private val reducer: MainReducer,
    private val creationList: Interactor<MainViewState, MainEvent>
) : MainActivityPresenter {

    private val initState = reducer.initState
    private var stateValue = initState

    private fun obtainEvent(event: MainEvent) {
        stateValue = reducer.reduce(stateValue, event)
        view.render(stateValue)
        when (event) {
            is MainEvent.CheckItemId -> {
                if (event.id > -1) {
                    val result = MainEvent.ItemIdChecked(event.id, true)
                    obtainEvent(result)
                }
            }
            is MainEvent.CreateList -> {
                creationList.invoke(initState, event)
            }
            is MainEvent.ItemIdChecked -> {
            }
            is MainEvent.ListCreated -> {
            }
        }
    }

    override fun createList() {
        obtainEvent(MainEvent.CreateList)
    }

    override fun checkItemId() {
        obtainEvent(MainEvent.CheckItemId(initState.lastItemId))
    }
}