package com.frogobox.sdk.consumable.news.sources

import android.content.Context
import com.frogobox.sdk.consumable.news.model.ArticleResponse
import com.frogobox.sdk.consumable.news.model.SourceResponse
import com.frogobox.sdk.core.FrogoResponseCallback

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * consumable-code-news-api
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.sdk.consumable.news.data.source
 *
 */
interface NewsDataSource {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Get Top Headline
    fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: FrogoResponseCallback<ArticleResponse>
    )

    // Get Everythings
    fun getEverythings(
        apiKey: String,
        q: String?,
        from: String?,
        to: String?,
        qInTitle: String?,
        sources: String?,
        domains: String?,
        excludeDomains: String?,
        language: String?,
        sortBy: String?,
        pageSize: Int?,
        page: Int?,
        callback: FrogoResponseCallback<ArticleResponse>
    )

    // Get Sources
    fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: FrogoResponseCallback<SourceResponse>
    )

}