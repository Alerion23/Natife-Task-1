package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.model.Item

interface GetItemByIdInteractor {

    fun execute(id: Int) : Item?

}