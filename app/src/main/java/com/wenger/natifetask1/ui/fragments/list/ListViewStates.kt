package com.wenger.natifetask1.ui.fragments.list

import com.wenger.natifetask1.model.Item

sealed class ListViewStates() {

    class DisplayedItemList(val list: ArrayList<Item>) : ListViewStates()
}
