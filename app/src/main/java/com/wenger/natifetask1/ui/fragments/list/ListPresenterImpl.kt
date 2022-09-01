package com.wenger.natifetask1.ui.fragments.list

import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.data.Prefs

class ListPresenterImpl(
    private val view: ListFragmentView,
    private val prefs: Prefs
) : ListPresenter {

    override fun getNewList() {
        val list = ItemList.getList()
        view.showItemList(list)
    }

    override fun saveItemId(id: Int) {
        prefs.setItemId(id)
    }

}