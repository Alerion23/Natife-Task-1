package com.wenger.natifetask1.ui

import com.wenger.natifetask1.ItemList

class MainActivityPresenterImpl(private val view: MainActivityView) : MainActivityPresenter {

    override fun createList() {
        if (ItemList.getList().size != 20) {
            ItemList.createList()
        }
    }

    override fun checkItemId(id: Int) {
        if (id > -1) {
            view.showLastItem(id)
        }
    }
}