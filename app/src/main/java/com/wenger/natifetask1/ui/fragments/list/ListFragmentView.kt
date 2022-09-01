package com.wenger.natifetask1.ui.fragments.list

import com.wenger.natifetask1.model.Item

interface ListFragmentView {

    fun showItemList(list: ArrayList<Item>)
}