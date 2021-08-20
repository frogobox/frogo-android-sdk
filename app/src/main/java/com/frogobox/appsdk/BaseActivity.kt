package com.frogobox.appsdk

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.frogobox.sdk.core.FrogoActivity

/*
 * Created by faisalamir on 02/08/21
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
abstract class BaseActivity<VB : ViewBinding> : FrogoActivity<VB>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}