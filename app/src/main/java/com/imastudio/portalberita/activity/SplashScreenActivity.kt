package com.imastudio.portalberita.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.imastudio.portalberita.MainActivity
import com.imastudio.portalberita.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        lottie1.setAnimation("AndroidWave.json")
        lottie1.loop(true)
        lottie1.playAnimation()

        //untuk melakukan penundaan ke suatu aksi / activity
        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 3000)

    }
}
