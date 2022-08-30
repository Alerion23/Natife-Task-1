package com.wenger.natifetask1.data

import android.content.Context
import androidx.core.content.edit

class Prefs(context: Context) {

    private val prefs = context.getSharedPreferences(SHARED_FILE, Context.MODE_PRIVATE)

    fun setItemId(id: Int) {
        prefs.edit {
            putInt(ITEM_ID, id)
        }
    }

    fun getItemId(): Int {
        return prefs.getInt(ITEM_ID, 0)
    }

    companion object {
        private const val SHARED_FILE = "my_prefs"
        private const val ITEM_ID = "item_id"
    }

}