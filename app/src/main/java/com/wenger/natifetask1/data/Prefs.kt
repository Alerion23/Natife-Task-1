package com.wenger.natifetask1.data

import android.content.Context

class Prefs(private val context: Context) {

    fun setItemId(id: Int) {
        val prefs = context.getSharedPreferences(SHARED_FILE, Context.MODE_PRIVATE).edit()
        prefs.putInt(ITEM_ID, id)
        prefs.apply()
    }

    fun getItemId(): Int {
        val prefs = context.getSharedPreferences(SHARED_FILE, Context.MODE_PRIVATE)
        return prefs.getInt(ITEM_ID, 0)
    }

    companion object {
        private const val SHARED_FILE = "my_prefs"
        private const val ITEM_ID = "item_id"
    }

}