package com.wenger.natifetask1.data.interactors

import android.util.Log
import com.wenger.natifetask1.base.UnitInteractor
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.ui.fragments.item.ItemEvent
import com.wenger.natifetask1.ui.fragments.item.ItemFragment
import com.wenger.natifetask1.ui.fragments.item.ItemViewStates

class GetItemIdImpl(
    private val prefs: Prefs
): UnitInteractor<ItemViewStates, ItemEvent> {

    override fun invoke(state: ItemViewStates, event: ItemEvent) {
        val prefsId = prefs.getItemId()
        Log.d(ItemFragment.TAG, "$prefsId")
    }
}