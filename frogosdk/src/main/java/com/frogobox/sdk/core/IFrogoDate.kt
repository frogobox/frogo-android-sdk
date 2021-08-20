package com.frogobox.sdk.core

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
interface IFrogoDate {

    fun getTimeStamp(): String

    fun getTimeNow(): String

    fun getCurrentDate(format: String): String

    fun dateTimeToTimeStamp(date: String?): Long

    fun getCurrentUTC(): String

    fun timetoHour(date: String?): String

    fun dateTimeTZtoHour(date: String?): String

    fun DateTimeMonth(date: String?): String

    fun dateTimeSet(date: String?): String

    fun dateTimeProblem(date: String?): String

    fun getTimeAgo(time: Long): String?

    fun compareDate(newDate: String): String?

    fun messageDate(newDate: String): String?

    fun getDataChat(time: Long): String?

    fun convertClassificationDate(string: String?): String

    fun convertDateNewFormat(string: String?): String

    fun convertLongDateNewFormat(string: String?): String

    fun revertFromLongDateNewFormat(string: String?): String

    fun convertTargetDate(string: String?): String

    fun diffTime(timeStart: String, timeEnd: String): Long

}