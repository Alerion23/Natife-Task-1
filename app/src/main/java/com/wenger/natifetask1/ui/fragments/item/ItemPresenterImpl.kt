package com.wenger.natifetask1.ui.fragments.item

import com.wenger.natifetask1.base.Interactor

class ItemPresenterImpl(
    private val view: ItemView,
    private val getItemId: Interactor<ItemViewState, ItemEvent>,
    private val getItemById: Interactor<ItemViewState, ItemEvent>,
    private val reducer: ItemReducer
) : ItemPresenter {

    private val initState = reducer.initState
    private var stateValue = initState

    override fun getItemDetails() {
        obtainEvent(ItemEvent.GetItemDetails(initState.id))
    }

    override fun getIdAndLog() {
        obtainEvent(ItemEvent.GetItemIdAndLog)
    }

    private fun obtainEvent(event: ItemEvent) {
        stateValue = reducer.reduce(stateValue, event)
        when (event) {
            is ItemEvent.GetItemDetails -> {
                val result = getItemById.invoke(initState, event)
                view.render(stateValue)
                obtainEvent(result)
            }
            is ItemEvent.GetItemIdAndLog -> {
                getItemId.invoke(initState, event)
                view.render(stateValue)
            }
            is ItemEvent.ItemDetailsReceived -> {
                view.render(stateValue)
            }
            is ItemEvent.Error -> {
                view.render(stateValue)
            }
            is ItemEvent.ItemIdLogged -> {
                view.render(stateValue)
            }
        }
    }
}