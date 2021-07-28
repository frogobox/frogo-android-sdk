package com.frogobox.frogosdk.core

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
abstract class FrogoAdmobFragment<VB : ViewBinding> : FrogoBaseFragment<VB>(), IFrogoAdmobFragment {

    protected lateinit var frogoAdmobActivity: FrogoAdmobActivity<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        frogoAdmobActivity = (activity as FrogoAdmobActivity<*>)
    }

    override fun setupShowAdsInterstitial() {
        frogoAdmobActivity.setupShowAdsInterstitial()
    }

    override fun setupShowAdsBanner(adView: AdView) {
        frogoAdmobActivity.setupShowAdsBanner(adView)
    }

    override fun setupShowAdsRewarded(callback: IFrogoAdmob.UserEarned) {
        frogoAdmobActivity.setupShowAdsRewarded(callback)
    }

    override fun setupShowAdsRewardedInterstitial(callback: IFrogoAdmob.UserEarned) {
        frogoAdmobActivity.setupShowAdsRewardedInterstitial(callback)
    }

}