package com.frogobox.frogosdk.core

import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import com.google.gson.Gson

/*
 * Created by faisalamir on 26/07/21
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
interface IFrogoBaseActivity {

    fun setupDetailActivity(title: String)

    fun setupChildFragment(frameId: Int, fragment: Fragment)

    fun showToast(message: String)

    fun setupEventEmptyView(view: View, isEmpty: Boolean)

    fun setupEventProgressView(view: View, progress: Boolean)

    fun checkExtra(extraKey: String): Boolean

    fun <Model> baseFragmentNewInstance(
        fragment: FrogoBaseFragment<*>,
        argumentKey: String,
        extraDataResult: Model
    )

    fun verifySignature()

    fun readSignature()

    fun verifyInstallerId()

    fun verifyUnauthorizedApps()

    fun verifyStores()

    fun verifyDebug()

    fun verifyEmulator()

    fun showApkSignatures()

}