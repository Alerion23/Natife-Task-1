package com.wenger.natifetask1.data.interactors

import com.wenger.natifetask1.base.UnitInteractor
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.ui.fragments.list.ListEvent
import com.wenger.natifetask1.ui.fragments.list.ListViewStates

class SaveItemIdImpl(
    private val prefs: Prefs
) : UnitInteractor<ListViewStates, ListEvent> {

    override fun invoke(state: ListViewStates, event: ListEvent) {
        if (event is ListEvent.SaveItemId) {
            prefs.setItemId(event.id)
        }
    }
}