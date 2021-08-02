package com.frogobox.frogosdk.core

import androidx.viewbinding.ViewBinding
import com.frogobox.admob.core.FrogoAdmob
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
abstract class FrogoActivity<VB : ViewBinding> : FrogoBaseActivity<VB>(), IFrogoActivity {

    protected val arrayFrogoAdmobData = mutableListOf<Any>()

    override fun setupAdsPublisher(mPublisherId: String) {
        FrogoAdmob.setupPublisherID(mPublisherId)
        FrogoAdmob.Publisher.setupPublisher(this)
    }

    override fun setupAdsBanner(mAdUnitId: String) {
        FrogoAdmob.setupBannerAdUnitID(mAdUnitId)
    }

    override fun setupAdsInterstitial(mAdUnitId: String) {
        FrogoAdmob.setupInterstialAdUnitID(mAdUnitId)
        FrogoAdmob.Interstitial.setupInterstitial(this)
    }

    override fun setupAdsRewarded(mAdUnitId: String) {
        FrogoAdmob.setupRewardedAdUnitID(mAdUnitId)
        FrogoAdmob.Rewarded.setupRewarded(this)
    }

    override fun setupAdsRewardedInterstitial(mAdUnitId: String) {
        FrogoAdmob.setupRewardedInterstitialAdUnitID(mAdUnitId)
        FrogoAdmob.RewardedInterstitial.setupRewardedInterstitial(this)
    }

    override fun setupShowAdsBanner(mAdView: AdView) {
        FrogoAdmob.Banner.setupBanner(mAdView)
        FrogoAdmob.Banner.showBanner(mAdView)
    }

    override fun setupShowAdsInterstitial() {
        FrogoAdmob.Interstitial.showInterstitial(this)
    }

    override fun setupShowAdsRewarded(callback: IFrogoAdmob.UserEarned) {
        FrogoAdmob.Rewarded.showRewarded(this, callback)
    }

    override fun setupShowAdsRewardedInterstitial(callback: IFrogoAdmob.UserEarned) {
        FrogoAdmob.RewardedInterstitial.showRewardedInterstitial(this, callback)
    }

    override fun onResume() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.resume()
            }
        }
        super.onResume()
    }

    override fun onPause() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.pause()
            }
        }
        super.onPause()
    }

    override fun onDestroy() {
        for (item in arrayFrogoAdmobData) {
            if (item is AdView) {
                item.destroy()
            }
        }
        super.onDestroy()
    }

}