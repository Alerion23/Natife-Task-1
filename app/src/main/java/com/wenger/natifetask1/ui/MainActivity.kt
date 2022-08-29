package com.wenger.natifetask1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.wenger.natifetask1.R
import com.wenger.natifetask1.base.BaseActivity
import com.wenger.natifetask1.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private var binding: ActivityMainBinding? = null

    override fun getNavFragment(): Fragment? =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}