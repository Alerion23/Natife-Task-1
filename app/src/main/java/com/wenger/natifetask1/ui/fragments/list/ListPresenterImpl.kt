package com.wenger.natifetask1.ui.fragments.list

import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.data.Prefs

class ListPresenterImpl(
    private val view: ListFragmentView,
    private val prefs: Prefs
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
        val list = ItemList.getList()
        view.render(ListViewStates.DisplayedItemList(list))
    }

    private fun saveItemId(id: Int) {
        prefs.setItemId(id)
    }

}