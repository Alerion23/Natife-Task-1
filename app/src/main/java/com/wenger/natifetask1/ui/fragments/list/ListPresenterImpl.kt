package com.wenger.natifetask1.ui.fragments.list

import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.data.Prefs

class ListPresenterImpl(_view: ListFragmentView, prefs: Prefs) : ListPresenter {

    private val prefs: Prefs = prefs
    private val view: ListFragmentView = _view

    override fun getNewList() {
        val list = ItemList.getList()
        view.showItemList(list)
    }

    override fun saveItemId(id: Int) {
        prefs.setItemId(id)
    }


}