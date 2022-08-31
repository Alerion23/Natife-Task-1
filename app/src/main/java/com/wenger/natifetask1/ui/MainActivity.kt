package com.wenger.natifetask1.ui

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.wenger.natifetask1.*
import com.wenger.natifetask1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var receiver: MyBroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            ?.let { findNavController(it) }
        ItemList.createList()
        receiver = MyBroadcastReceiver()
        val serviceIntent = Intent(this, ForegroundService::class.java)
        startService(serviceIntent)
        registerBroadcastReceiver()
    }

    private fun registerBroadcastReceiver() {
        val intentFilter = IntentFilter(NOTIFICATION_ACTION)
        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        unregisterReceiver(receiver)
        val serviceIntent = Intent(this, ForegroundService::class.java)
        stopService(serviceIntent)
    }

    companion object {
        const val NOTIFICATION_ACTION = "${BuildConfig.APPLICATION_ID}.CUSTOM_ACTION"
    }

}