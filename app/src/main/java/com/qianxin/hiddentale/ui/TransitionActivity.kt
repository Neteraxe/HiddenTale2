package com.qianxin.hiddentale.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.qianxin.hiddentale.MainActivity
import com.qianxin.hiddentale.R

class TransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 后台返回时可能启动这个页面 http://blog.csdn.net/jianiuqi/article/details/54091181
        if (intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT !== 0) {
            finish()
            return
        }
        Handler().postDelayed({
            startActivity(Intent(this@TransitionActivity, MainActivity::class.java))
            overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out)
            finish()
        }, 100)
    }
}
