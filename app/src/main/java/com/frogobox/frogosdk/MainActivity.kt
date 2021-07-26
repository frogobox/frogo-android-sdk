package com.frogobox.frogosdk

import android.os.Bundle
import com.frogobox.frogosdk.core.FrogoActivity
import com.frogobox.frogosdk.databinding.ActivityMainBinding

class MainActivity : FrogoActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {

    }
}