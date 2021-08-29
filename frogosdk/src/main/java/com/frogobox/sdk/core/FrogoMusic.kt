package com.frogobox.sdk.core

import android.content.Context
import android.media.MediaPlayer

/*
 * Created by faisalamir on 29/08/21
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
object FrogoMusic {

    lateinit var mediaPlayer: MediaPlayer

    fun playSong(context: Context, songMusic: Int) {
        mediaPlayer = MediaPlayer.create(context, songMusic)
        mediaPlayer.start()
        mediaPlayer.isLooping = true
    }

    fun stopSong() {
        mediaPlayer.stop()
        mediaPlayer.release()
    }

    fun pauseSong() {
        mediaPlayer.pause()
    }

}