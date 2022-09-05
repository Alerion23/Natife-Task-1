package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.ItemList

class CreateItemListImpl: CreateItemListInteractor {

    override fun execute() {
        if (ItemList.getList().size != 20) {
            ItemList.createList()
        }
    }
}