package com.wenger.natifetask1.ui.fragments.list

import com.wenger.natifetask1.base.Interactor
import com.wenger.natifetask1.base.UnitInteractor

class ListPresenterImpl(
    private val view: ListFragmentView,
    private val saveItemIdInteractor: UnitInteractor<ListViewStates, ListEvent>,
    private val getItemListInteractor: Interactor<ListViewStates, ListEvent>,
    private val reducer: ListReducer
) : ListPresenter {

    private val state = reducer.initState

    private fun obtainEvent(event: ListEvent) {
        val stateValue = reducer.reduce(state, event)
        when (event) {
            is ListEvent.LoadList -> {
                val result = getItemListInteractor.invoke(state, event)
                obtainEvent(result)
            }
            is ListEvent.SaveItemId -> {
                saveItemIdInteractor.invoke(state, event)
            }
            is ListEvent.ListLoaded -> {
                view.render(stateValue)
            }
            is ListEvent.Error -> {
                view.render(stateValue)
            }
        }
    }

    override fun getNewList() {
        obtainEvent(ListEvent.LoadList)
    }

    override fun saveItemId(id: Int) {
        obtainEvent(ListEvent.SaveItemId(id))
    }
}