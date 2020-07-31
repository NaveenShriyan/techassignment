package com.evaluation.techassigment.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.evaluation.techassigment.R
import com.evaluation.techassigment.application.Constants
import com.evaluation.techassigment.ui.MainActivity
import com.evaluation.techassigment.ui.base.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            startActivity(Intent(this, MainActivity::class.java))

            // close this activity
            finish()
        }, Constants.SPLASH_TIME)
    }
}