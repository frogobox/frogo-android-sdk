package com.frogobox.sdk

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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
abstract class FrogoApplication : Application() {

    companion object {
        lateinit var instance: FrogoApplication
        fun getContext(): Context = instance.applicationContext
    }

    abstract fun setupKoinModule(koinApplication: KoinApplication)

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@FrogoApplication)
            androidLogger(Level.NONE)
            setupKoinModule(this)
        }
    }

}