package com.frogobox.frogosdk.core

import android.os.Environment

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
object FrogoConstant {

    const val OPTION_GET = "OPTION_GET"
    const val OPTION_DELETE = "OPTION_DELETE"

    const val DEFAULT_NULL = "null"
    const val DEFAULT_ERROR_MESSAGE = "Failed"
    const val FRAGMENT_DIALOG = "dialog"

    const val SPLASH_INTERVAL = 1000

    object Value {
        const val VALUE_SENSOR_ORIENTATION_DEFAULT_DEGREES = 90
        const val VALUE_SENSOR_ORIENTATION_INVERSE_DEGREES = 270
    }

    object Tag {
        const val TAG_ACTIVITY_EDIT = 300
        const val TAG_ACTIVITY_CREATE = 301
        const val TAG_ACTIVITY_DETAIL = 302

        const val TAG_FROM_ACTIVITY = 801
        const val TAG_FROM_FRAGMENT = 800

        const val TAG_CAMERA_VIDEO = "Camera2VideoFragment"
    }

    object Ext {
        const val MP4 = ".mp4"
        const val PNG = ".png"
        const val CSV = ".csv"
    }

    object Dir {
        private const val BASE_FILE_NAME = "SPEECH_"
        private const val BASE_DIR_NAME = "BaseMusicPlayer"

        val DIR_NAME = "${Environment.DIRECTORY_PICTURES}/$BASE_DIR_NAME"
        val VIDEO_FILE_NAME = "$BASE_FILE_NAME${System.currentTimeMillis()}${Ext.MP4}"
    }

}