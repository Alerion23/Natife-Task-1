package com.wenger.natifetask1.ui

import com.wenger.natifetask1.ItemList

class MainActivityPresenterImpl(_view: MainActivityView) : MainActivityPresenter {

    private val view: MainActivityView = _view

    override fun createList() {
        if (ItemList.getList().size != 20) {
            ItemList.createList()
        }
    }
}