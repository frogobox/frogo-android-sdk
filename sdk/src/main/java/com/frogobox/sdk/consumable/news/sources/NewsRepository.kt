package com.frogobox.sdk.consumable.news.sources

import android.content.Context
import com.frogobox.frogolog.FLog
import com.frogobox.sdk.consumable.news.model.ArticleResponse
import com.frogobox.sdk.consumable.news.model.SourceResponse
import com.frogobox.sdk.consumable.news.sources.NewsConstant.Url.BASE_URL
import com.frogobox.sdk.core.FrogoApiCallback
import com.frogobox.sdk.core.FrogoApiClient
import com.frogobox.sdk.core.FrogoResponseCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
object NewsRepository : NewsDataSource {

    private var debug = false
    private val newsApiService = FrogoApiClient.create<NewsApiService>(BASE_URL, debug)

    override fun usingChuckInterceptor(context: Context) {
        debug = true
        FLog.d("Using Chuck Interceptor")
    }

    override fun getTopHeadline(
        apiKey: String,
        q: String?,
        sources: String?,
        category: String?,
        country: String?,
        pageSize: Int?,
        page: Int?,
        callback: FrogoResponseCallback<ArticleResponse>
    ) {
        newsApiService.getTopHeadline(apiKey, q, sources, category, country, pageSize, page)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<ArticleResponse>() {
                override fun onSuccess(model: ArticleResponse) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

            })
    }

    override fun getEverythings(
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
    ) {
        newsApiService.getEverythings(
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
                page
            )
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<ArticleResponse>() {
                override fun onSuccess(model: ArticleResponse) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

            })
    }

    override fun getSources(
        apiKey: String,
        language: String,
        country: String,
        category: String,
        callback: FrogoResponseCallback<SourceResponse>
    ) {
        newsApiService.getSources(apiKey, language, country, category)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<SourceResponse>() {
                override fun onSuccess(model: SourceResponse) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }
}