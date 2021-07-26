package com.frogobox.sdk.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Environment
import com.frogobox.sdk.R
import com.frogobox.sdk.util.SingleConstant.Dir.DIR_NAME
import com.frogobox.sdk.util.SingleConstant.Dir.VIDEO_FILE_NAME
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayList

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
object SingleFunc {

    fun <T : Any> fetchData(mContext: Context, sourceRaw: Int): ArrayList<T> {
        val dataArrayList = ArrayList<T>()
        val rawDict = mContext.resources.openRawResource(sourceRaw)
        val reader = BufferedReader(InputStreamReader(rawDict))
        try {
            var column: T
            while (reader.readLine().also { column = it as T } != null) {
                dataArrayList.add(column)
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        dataArrayList.shuffle()
        return dataArrayList
    }

    fun createFolderPictureVideo() {
        val videoFolder = Environment.getExternalStoragePublicDirectory(DIR_NAME)
        if (!videoFolder.exists()) {
            videoFolder.mkdirs()
        }
    }

    fun getVideoFilePath(): String {
        val dir = Environment.getExternalStoragePublicDirectory(DIR_NAME)
        return if (dir == null) {
            VIDEO_FILE_NAME
        } else {
            "${dir.absoluteFile}/$VIDEO_FILE_NAME"
        }
    }

    fun createDialogDefault(
        context: Context,
        title: String,
        message: String,
        listenerYes: () -> Unit,
        listenerNo: () -> Unit
    ) {
        val dialogBuilder = AlertDialog.Builder(context)
        // set message of alert dialog
        dialogBuilder.setMessage(message)
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton(
                context.getText(R.string.dialog_button_yes),
                DialogInterface.OnClickListener { dialog, id ->
                    listenerYes()
                })
            // negative button text and action
            .setNegativeButton(
                context.getText(R.string.dialog_button_no),
                DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                    listenerNo()
                })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle(title)
        // show alert dialog
        alert.show()
    }

    fun noAction(): Boolean {
        return true
    }

    fun isNetworkAvailable(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected) isConnected = true
        return isConnected
    }

}