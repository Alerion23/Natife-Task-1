package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.data.Prefs

class SaveItemIdImpl(
    private val prefs: Prefs
): SaveItemIdInteractor {

    override fun execute(id: Int) {
        prefs.setItemId(id)
    }
}