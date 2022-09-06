package com.wenger.natifetask1.data.interactors

import android.util.Log
import com.wenger.natifetask1.base.Interactor
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.ui.fragments.item.ItemEvent
import com.wenger.natifetask1.ui.fragments.item.ItemFragment
import com.wenger.natifetask1.ui.fragments.item.ItemViewState

class GetItemIdImpl(
    private val prefs: Prefs
): Interactor<ItemViewState, ItemEvent> {

    override fun invoke(state: ItemViewState, event: ItemEvent) : ItemEvent {
        val prefsId = prefs.getItemId()
        Log.d(ItemFragment.TAG, "$prefsId")
        return ItemEvent.ItemIdLogged
    }
}