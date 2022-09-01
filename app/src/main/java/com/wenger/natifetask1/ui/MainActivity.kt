package com.wenger.natifetask1.ui

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.wenger.natifetask1.*
import com.wenger.natifetask1.databinding.ActivityMainBinding
import com.wenger.natifetask1.ui.fragments.list.ListFragmentDirections
import com.wenger.natifetask1.utils.ViewState

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var receiver: MyBroadcastReceiver? = null
    private val viewModel: MainActivityViewModel by viewModels {
        MainActivityViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            ?.let { findNavController(it) }
        viewModel.createItemList()
        receiver = MyBroadcastReceiver()
        val serviceIntent = Intent(this, ForegroundService::class.java)
        startService(serviceIntent)
        registerBroadcastReceiver()
        getLastItem()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.itemIdState.observe(this) {
            when (it) {
                is ViewState.Success -> {
                    showLastItem(it.data)
                }
                else -> {
                    //do nothing
                }
            }
        }
    }

    private fun getLastItem() {
        val lastItemId = intent.getIntExtra(MyBroadcastReceiver.LAST_ITEM_ID, -1)
        viewModel.checkLastItemId(lastItemId)
    }

    private fun registerBroadcastReceiver() {
        val intentFilter = IntentFilter(NOTIFICATION_ACTION)
        registerReceiver(receiver, intentFilter)
    }

    private fun showLastItem(lastItemId: Int) {
        val fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val directions = ListFragmentDirections.goToItemFragment(lastItemId)
        if (fragment != null) {
            findNavController(fragment).navigate(directions)
        }
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