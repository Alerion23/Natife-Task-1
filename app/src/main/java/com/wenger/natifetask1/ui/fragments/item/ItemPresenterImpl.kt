package com.wenger.natifetask1.ui.fragments.item

import com.wenger.natifetask1.base.Interactor
import com.wenger.natifetask1.base.UnitInteractor

class ItemPresenterImpl(
    private val view: ItemView,
    private val getItemId: UnitInteractor<ItemViewStates, ItemEvent>,
    private val getItemById: Interactor<ItemViewStates, ItemEvent>,
    private val reducer: ItemReducer
) : ItemPresenter {

    private val initState = reducer.initState

    override fun getItemDetails(itemId: Int) {
        obtainEvent(ItemEvent.GetItemDetails(itemId))
    }

    override fun getIdAndLog() {
        obtainEvent(ItemEvent.GetItemIdAndLog)
    }

    private fun obtainEvent(event: ItemEvent) {
        val stateValue = reducer.reduce(initState, event)
        when (event) {
            is ItemEvent.GetItemDetails -> {
                val result = getItemById.invoke(initState, event)
                obtainEvent(result)
            }
            is ItemEvent.GetItemIdAndLog -> {
                getItemId.invoke(initState, event)
            }
            is ItemEvent.ItemDetailsReceived -> {
                    view.render(stateValue)
            }
            is ItemEvent.Error -> {
                view.render(stateValue)
            }
        }
    }
}