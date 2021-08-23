package com.frogobox.appsdk

import android.os.Bundle
import com.frogobox.appsdk.databinding.ActivityMainBinding
import com.frogobox.sdk.view.FrogoAboutUsActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        binding.apply {
            tv.text = "Frogo Android SDK"
            tv.setOnClickListener {
                baseStartActivity<FrogoAboutUsActivity>()
            }
        }
    }
}