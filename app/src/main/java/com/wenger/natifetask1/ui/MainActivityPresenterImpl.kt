package com.wenger.natifetask1.ui

import com.wenger.natifetask1.base.UnitInteractor

class MainActivityPresenterImpl(
    private val view: MainActivityView,
    private val reducer: MainReducer,
    private val creationList: UnitInteractor<MainViewStates, MainEvent>
) : MainActivityPresenter {

    private val initState = reducer.initState

    private fun obtainEvent(event: MainEvent) {
        val stateValue = reducer.reduce(initState, event)
        when (event) {
            is MainEvent.CheckItemId -> {
                if (event.id > -1) {
                    val result = MainEvent.ItemIdChecked(event.id)
                    obtainEvent(result)
                }
            }
            is MainEvent.CreateList -> {
                creationList.invoke(initState, event)
            }
            is MainEvent.ItemIdChecked -> {
                view.render(stateValue)
            }
        }
    }

    override fun createList() {
        obtainEvent(MainEvent.CreateList)
    }

    override fun checkItemId(id: Int) {
        obtainEvent(MainEvent.CheckItemId(id))
    }
}