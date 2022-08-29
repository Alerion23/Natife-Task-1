package com.wenger.natifetask1

import com.wenger.natifetask1.model.Item

object ItemList {

    private val itemList = arrayListOf<Item>()
    private var item: Item? = null

    fun createList() {
        for (i in 0..19) {
            val name: String = getRandomString(7)
            val description: String = getRandomString(20)
            val item = Item(i, name, description)
            itemList.add(item)
        }
    }

    fun getList(): ArrayList<Item> {
        return itemList
    }

    fun getItemById(id: Int): Item? {
        for (i in 0 until itemList.size) {
            if (id == i) {
                item = itemList[i]
            }
        }
        return item
    }

    private fun getRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}