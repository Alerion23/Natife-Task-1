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
        view.render(stateValue)
        when (event) {
            is ItemEvent.GetItemDetails -> {
                val result = getItemById.invoke(initState, event)
                obtainEvent(result)
            }
            is ItemEvent.GetItemIdAndLog -> {
                getItemId.invoke(initState, event)
            }
            is ItemEvent.ItemDetailsReceived -> {
            }
            is ItemEvent.Error -> {
            }
            is ItemEvent.ItemIdLogged -> {
            }
        }
    }
}