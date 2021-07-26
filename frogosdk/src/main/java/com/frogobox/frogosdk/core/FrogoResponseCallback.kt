package com.frogobox.frogosdk.core

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

interface FrogoResponseCallback<T> {

    fun onSuccess(data: T)

    fun onFailed(statusCode: Int, errorMessage: String? = "")

    fun onShowProgress()

    fun onHideProgress()

}