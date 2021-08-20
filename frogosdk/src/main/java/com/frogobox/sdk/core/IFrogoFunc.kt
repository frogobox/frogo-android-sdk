package com.frogobox.sdk.core

import android.content.Context
import java.io.IOException
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

    fun getJsonFromAssets(context: Context, filename: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(filename).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getDrawableString(context: Context, nameResource: String): Int

    fun getRawString(context: Context, nameResource: String): Int

    fun randomNumber(start: Int, end: Int): Int

}