package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.model.Item

class GetItemListImpl: GetItemListInteractor {

    override fun execute(): ArrayList<Item> = ItemList.getList()

}