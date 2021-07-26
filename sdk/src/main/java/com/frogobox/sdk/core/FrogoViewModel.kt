package com.frogobox.sdk.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.frogobox.sdk.util.SingleLiveEvent

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
abstract class FrogoViewModel(application: Application) : AndroidViewModel(application) {
    var eventShowProgress = SingleLiveEvent<Boolean>()
    var eventEmptyData = SingleLiveEvent<Boolean>()
    var eventFailed = SingleLiveEvent<String>()
}