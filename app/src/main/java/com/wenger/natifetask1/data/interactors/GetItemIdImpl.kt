package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.model.Item

class GetItemIdImpl(
    private val prefs: Prefs
): GetItemIdInteractor {

    override fun execute(): Int = prefs.getItemId()
}