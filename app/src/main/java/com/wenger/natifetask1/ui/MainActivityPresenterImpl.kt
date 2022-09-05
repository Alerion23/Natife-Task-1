package com.wenger.natifetask1.ui

import com.wenger.natifetask1.data.interactors.CreateItemListInteractor

class MainActivityPresenterImpl(
    private val view: MainActivityView,
private val creationList: CreateItemListInteractor) : MainActivityPresenter {

    override fun obtainEvent(event: MainEvent) {
        when (event) {
            is MainEvent.CheckItemId -> {
                checkItemId(event.id)
            }

            is MainEvent.CreateList -> {
                createList()
            }
        }
    }

    private fun createList() {
        creationList.execute()
    }

    private fun checkItemId(id: Int) {
        if (id > -1) {
            reduce(MainViewStates.LastItemShowedState(id))
        }
    }

    private fun reduce(state: MainViewStates) {
        view.render(state)
    }
}