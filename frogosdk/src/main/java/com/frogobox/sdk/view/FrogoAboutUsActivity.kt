package com.frogobox.sdk.view

import android.os.Bundle
import com.frogobox.sdk.R
import com.frogobox.sdk.core.FrogoActivity
import com.frogobox.sdk.databinding.ActivityFrogoAboutUsBinding
import java.util.*

class FrogoAboutUsActivity : FrogoActivity<ActivityFrogoAboutUsBinding>() {

    override fun setupViewBinding(): ActivityFrogoAboutUsBinding {
        return ActivityFrogoAboutUsBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("About Frogobox")

        binding.apply {
            val textCopyright = "${getString(R.string.about_all_right_reserved)} ${getString(R.string.about_copyright)} ${Calendar.getInstance().get(Calendar.YEAR)}"
            tvCopyright.text = textCopyright
        }
    }

}