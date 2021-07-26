package com.frogobox.sdk.consumable.news

import android.content.Context
import com.frogobox.sdk.consumable.news.model.ArticleResponse
import com.frogobox.sdk.consumable.news.model.SourceResponse
import com.frogobox.sdk.consumable.news.sources.NewsRepository
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
 * com.frogobox.sdk.consumable.news
 *
 */
class NewsConsumeApi(private val apiKey: String) : INewsConsumeApi {

    private val newsRepository = NewsRepository

    override fun usingChuckInterceptor(context: Context) {
        newsRepository.usingChuckInterceptor(context)
    }

    override fun getTopHeadline(
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: FrogoResponseCallback<ArticleResponse>
    ) {
        newsRepository.getTopHeadline(
            apiKey,
            q,
            sources,
            category,
            country,
            pageSize,
            page,
            callback
        )
    }

    override fun getEverythings(
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
    ) {
        newsRepository.getEverythings(
            apiKey,
            q,
            from,
            to,
            qInTitle,
            sources,
            domains,
            excludeDomains,
            language,
            sortBy,
            pageSize,
            page,
            callback
        )
    }

    override fun getSources(
        language: String,
        country: String,
        category: String,
        callback: FrogoResponseCallback<SourceResponse>
    ) {
        newsRepository.getSources(
            apiKey,
            language,
            country,
            category,
            callback
        )
    }
}