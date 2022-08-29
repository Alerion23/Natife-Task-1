package com.wenger.natifetask1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.wenger.natifetask1.ItemList
import com.wenger.natifetask1.R
import com.wenger.natifetask1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            ?.let { findNavController(it) }
        ItemList.createList()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}