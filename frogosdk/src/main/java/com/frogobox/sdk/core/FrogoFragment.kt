package com.frogobox.sdk.core

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.frogobox.admob.core.IFrogoAdmob
import com.google.android.gms.ads.AdView

/*
 * Created by faisalamir on 28/07/21
 * FrogoSDK
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
abstract class FrogoFragment<VB : ViewBinding> : FrogoBaseFragment<VB>(), IFrogoFragment {

    protected lateinit var frogoActivity: FrogoActivity<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        frogoActivity = (activity as FrogoActivity<*>)
    }

    override fun setupShowAdsInterstitial() {
        frogoActivity.setupShowAdsInterstitial()
    }

    override fun setupShowAdsBanner(adView: AdView) {
        frogoActivity.setupShowAdsBanner(adView)
    }

    override fun setupShowAdsRewarded(callback: IFrogoAdmob.UserEarned) {
        frogoActivity.setupShowAdsRewarded(callback)
    }

    override fun setupShowAdsRewardedInterstitial(callback: IFrogoAdmob.UserEarned) {
        frogoActivity.setupShowAdsRewardedInterstitial(callback)
    }

}