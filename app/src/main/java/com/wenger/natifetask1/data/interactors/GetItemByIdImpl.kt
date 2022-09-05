package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.model.Item

class GetItemByIdImpl : GetItemByIdInteractor {

    override fun execute(id: Int): Item? = ItemList.getItemById(id)

}