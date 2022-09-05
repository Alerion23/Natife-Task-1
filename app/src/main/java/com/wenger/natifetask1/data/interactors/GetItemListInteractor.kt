package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.model.Item

interface GetItemListInteractor {

    fun execute(): ArrayList<Item>
}