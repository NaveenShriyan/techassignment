package com.evaluation.techassigment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.evaluation.techassigment.R
import com.evaluation.techassigment.databinding.ActivityMainBinding
import com.evaluation.techassigment.ui.base.BaseActivity

/**
 * Class which is an activity extending base activity,
 * Which includes fragment to show about country list
 */
class MainActivity : BaseActivity() {
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
        val host = NavHostFragment.create(R.navigation.nav_graph)
        supportFragmentManager.beginTransaction().replace(R.id.container, host)
            .setPrimaryNavigationFragment(host).commit()
    }
}