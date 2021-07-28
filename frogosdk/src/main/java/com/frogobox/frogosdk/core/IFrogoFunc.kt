package com.frogobox.frogosdk.core

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Environment
import com.frogobox.frogosdk.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayList

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
interface IFrogoFunc {

    fun <T : Any> fetchData(mContext: Context, sourceRaw: Int): ArrayList<T>

    fun createFolderPictureVideo()

    fun getVideoFilePath(): String

    fun createDialogDefault(
        context: Context,
        title: String,
        message: String,
        listenerYes: () -> Unit,
        listenerNo: () -> Unit
    )

    fun noAction(): Boolean

    fun isNetworkAvailable(context: Context): Boolean?

}