package com.evaluation.techassigment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.evaluation.techassigment.R
import com.evaluation.techassigment.databinding.ActivityMainBinding
import com.evaluation.techassigment.ui.base.BaseActivity
import com.evaluation.techassigment.ui.callbacks.ITitleCallBack
import com.evaluation.techassigment.utils.Logger

/**
 * Class which is an activity extending base activity,
 * Which includes fragment to show about country list
 */
class MainActivity : BaseActivity(), ITitleCallBack {
    private lateinit var host: NavHostFragment
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpToolBar()
        setupHost()
    }

    //Method used to setup custom toolbar
    private fun setUpToolBar() {
        val toolbar = binding?.toolBar
        setSupportActionBar(toolbar)
        // Remove default title text
        supportActionBar?.setDisplayShowTitleEnabled(false);
        binding?.titleText?.text = getString(R.string.about_country_title)
    }

    //Method used to set up Navigation Host, Which is an entry point for navigating to different screens
    private fun setupHost() {
        host = NavHostFragment.create(R.navigation.nav_graph)
        supportFragmentManager.beginTransaction().replace(R.id.container, host)
            .setPrimaryNavigationFragment(host).commit()
    }

    override fun onTittleReceived(title: String?, isFromDetail: Boolean) {
        Logger.d("TITLE", "---- TITTLE----")
        supportActionBar?.setDisplayHomeAsUpEnabled(isFromDetail)
        binding?.titleText?.text = title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}