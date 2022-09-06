package com.wenger.natifetask1.ui

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.wenger.natifetask1.*
import com.wenger.natifetask1.data.interactors.CreateItemListImpl
import com.wenger.natifetask1.databinding.ActivityMainBinding
import com.wenger.natifetask1.ui.fragments.list.ListFragmentDirections


class MainActivity : AppCompatActivity(), MainActivityView {

    private var binding: ActivityMainBinding? = null
    private var receiver: MyBroadcastReceiver? = null
    private val presenter: MainActivityPresenter by lazy {
        val creationList = CreateItemListImpl()
        val lastItemId = intent.getIntExtra(MyBroadcastReceiver.LAST_ITEM_ID, -1)
        val reducer = MainReducer(lastItemId)
        MainActivityPresenterImpl(this, reducer, creationList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            ?.let { findNavController(it) }
        presenter.createList()
        receiver = MyBroadcastReceiver()
        val serviceIntent = Intent(this, ForegroundService::class.java)
        startService(serviceIntent)
        registerBroadcastReceiver()
        getLastItem()
    }

    override fun render(state: MainViewState) {
        if (state.isIdExist) {
            val fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            val directions = ListFragmentDirections.goToItemFragment(state.lastItemId)
            if (fragment != null) {
                findNavController(fragment).navigate(directions)
            }
        }
    }

    private fun getLastItem() {
        presenter.checkItemId()
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