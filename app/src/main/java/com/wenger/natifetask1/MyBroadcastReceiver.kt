package com.wenger.natifetask1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.wenger.natifetask1.data.Prefs
import com.wenger.natifetask1.ui.MainActivity

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("NOTIFICATION", "OK")
        context?.also {
            val prefs = Prefs(it)
            val id = prefs.getItemId()
            val newIntent = Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                putExtra(LAST_ITEM_ID, id)
            }
            it.startActivity(newIntent)
        }
    }

    companion object {
        const val LAST_ITEM_ID = "last item id"
    }
}