package com.wenger.natifetask1.ui.fragments.list

import com.wenger.natifetask1.base.Interactor

class ListPresenterImpl(
    private val view: ListFragmentView,
    private val saveItemIdInteractor: Interactor<ListViewState, ListEvent>,
    private val getItemListInteractor: Interactor<ListViewState, ListEvent>,
    private val reducer: ListReducer
) : ListPresenter {

    private val initState = reducer.initState
    private var stateValue = initState

    private fun obtainEvent(event: ListEvent) {
        stateValue = reducer.reduce(stateValue, event)
        when (event) {
            is ListEvent.LoadList -> {
                val result = getItemListInteractor.invoke(stateValue, event)
                view.render(stateValue)
                obtainEvent(result)
            }
            is ListEvent.SaveItemId -> {
                saveItemIdInteractor.invoke(stateValue, event)
                view.render(stateValue)
            }
            is ListEvent.ListLoaded -> {
                view.render(stateValue)
            }
            is ListEvent.Error -> {
                view.render(stateValue)
            }
            is ListEvent.ItemIdSaved -> {
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