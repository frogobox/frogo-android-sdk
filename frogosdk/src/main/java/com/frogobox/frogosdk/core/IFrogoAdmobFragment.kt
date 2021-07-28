package com.frogobox.frogosdk.core

import android.view.View
import androidx.fragment.app.Fragment
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
interface IFrogoAdmobFragment {

    fun setupShowAdsInterstitial()

    fun setupShowAdsBanner(adView: AdView)

    fun setupShowAdsRewarded(callback: IFrogoAdmob.UserEarned)

    fun setupShowAdsRewardedInterstitial(callback: IFrogoAdmob.UserEarned)

}