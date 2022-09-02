package com.wenger.natifetask1.ui

import com.wenger.natifetask1.ItemList

class MainActivityPresenterImpl(private val view: MainActivityView) : MainActivityPresenter {

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
        if (ItemList.getList().size != 20) {
            ItemList.createList()
        }
    }

    private fun checkItemId(id: Int) {
        if (id > -1) {
            view.render(MainViewStates.LastItemShowedState(id))
        }
    }
}