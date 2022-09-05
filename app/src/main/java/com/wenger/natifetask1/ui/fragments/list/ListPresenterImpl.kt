package com.wenger.natifetask1.ui.fragments.list

import com.wenger.natifetask1.data.interactors.GetItemListInteractor
import com.wenger.natifetask1.data.interactors.SaveItemIdInteractor

class ListPresenterImpl(
    private val view: ListFragmentView,
    private val saveItemIdInteractor: SaveItemIdInteractor,
    private val getItemListInteractor: GetItemListInteractor
) : ListPresenter {

    override fun obtainEvent(event: ListEvent) {
        when (event) {
            is ListEvent.GetList -> {
                getNewList()
            }
            is ListEvent.SaveItemId -> {
                saveItemId(event.id)
            }
        }
    }

    private fun getNewList() {
        reducer(ListViewStates.DisplayedItemList(list = getItemListInteractor.execute()))
    }

    private fun saveItemId(id: Int) {
        saveItemIdInteractor.execute(id)
    }

    private fun reducer(handler: ListViewStates) {
        view.render(handler)
    }

}