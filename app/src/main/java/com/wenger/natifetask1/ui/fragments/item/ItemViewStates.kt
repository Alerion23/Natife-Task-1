package com.wenger.natifetask1.ui.fragments.item

sealed class ItemViewStates {

    class DisplayedItemDetails(val id: Int, val name: String, val description: String) :
        ItemViewStates()
}
