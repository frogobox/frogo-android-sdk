package com.frogobox.sdk.consumable.meal.source

import android.content.Context
import com.frogobox.sdk.consumable.meal.data.model.*
import com.frogobox.sdk.consumable.meal.model.MealResponse
import com.frogobox.sdk.consumable.meal.source.MealConstant.Url.MEALDB_BASE_URL
import com.frogobox.sdk.consumable.meal.model.*
import com.frogobox.sdk.core.FrogoApiCallback
import com.frogobox.sdk.core.FrogoApiClient
import com.frogobox.sdk.core.FrogoResponseCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * consumable-code-the-meal-db-api
 * Copyright (C) 15/03/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogomealsapi.data.source
 *
 */
object MealRemoteDataSource : MealDataSource {

    private var debug = false
    private val mealApiService = FrogoApiClient.create<MealApiService>(MEALDB_BASE_URL, debug)

    override fun usingChuckInterceptor(context: Context) {
        debug = true
    }

    override fun searchMeal(
        apiKey: String,
        mealName: String,
        callback: FrogoResponseCallback<MealResponse<Meal>>
    ) {
        mealApiService
            .searchMeal(apiKey, mealName)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<MealResponse<Meal>>() {
                override fun onSuccess(model: MealResponse<Meal>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                
            })

    }

    override fun listAllMeal(
        apiKey: String,
        firstLetter: String,
        callback: FrogoResponseCallback<MealResponse<Meal>>
    ) {
        mealApiService
            .listAllMeal(apiKey, firstLetter)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<MealResponse<Meal>>() {
                override fun onSuccess(model: MealResponse<Meal>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }


            })
    }

    override fun lookupFullMeal(
        apiKey: String,
        idMeal: String,
        callback: FrogoResponseCallback<MealResponse<Meal>>
    ) {
        mealApiService
            .lookupFullMeal(apiKey, idMeal)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<MealResponse<Meal>>() {
                override fun onSuccess(model: MealResponse<Meal>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                
            })
    }

    override fun lookupRandomMeal(
        apiKey: String,
        callback: FrogoResponseCallback<MealResponse<Meal>>
    ) {
        mealApiService
            .lookupRandomMeal(apiKey)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<MealResponse<Meal>>() {
                override fun onSuccess(model: MealResponse<Meal>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                
            })
    }

    override fun listMealCategories(
        apiKey: String,
        callback: FrogoResponseCallback<CategoryResponse>
    ) {
        mealApiService
            .listMealCategories(apiKey)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<CategoryResponse>() {
                override fun onSuccess(model: CategoryResponse) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                
            })
    }

    override fun listAllCateories(
        apiKey: String,
        callback: FrogoResponseCallback<MealResponse<Category>>
    ) {
        mealApiService
            .listAllCateories(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<MealResponse<Category>>() {
                override fun onSuccess(model: MealResponse<Category>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                
            })
    }

    override fun listAllArea(
        apiKey: String,
        callback: FrogoResponseCallback<MealResponse<Area>>
    ) {
        mealApiService
            .listAllArea(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<MealResponse<Area>>() {
                override fun onSuccess(model: MealResponse<Area>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                
            })
    }

    override fun listAllIngredients(
        apiKey: String,
        callback: FrogoResponseCallback<MealResponse<Ingredient>>
    ) {
        mealApiService
            .listAllIngredients(apiKey, MealConstant.VALUE_LIST)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<MealResponse<Ingredient>>() {
                override fun onSuccess(model: MealResponse<Ingredient>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                
            })
    }

    override fun filterByIngredient(
        apiKey: String,
        ingredient: String,
        callback: FrogoResponseCallback<MealResponse<MealFilter>>
    ) {
        mealApiService
            .filterByIngredient(apiKey, ingredient)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<MealResponse<MealFilter>>() {
                override fun onSuccess(model: MealResponse<MealFilter>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                
            })
    }

    override fun filterByCategory(
        apiKey: String,
        category: String,
        callback: FrogoResponseCallback<MealResponse<MealFilter>>
    ) {
        mealApiService
            .filterByCategory(apiKey, category)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<MealResponse<MealFilter>>() {
                override fun onSuccess(model: MealResponse<MealFilter>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }
            })
    }

    override fun filterByArea(
        apiKey: String,
        area: String,
        callback: FrogoResponseCallback<MealResponse<MealFilter>>
    ) {
        mealApiService
            .filterByArea(apiKey, area)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { callback.onShowProgress() }
            .doOnTerminate { callback.onHideProgress() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : FrogoApiCallback<MealResponse<MealFilter>>() {
                override fun onSuccess(model: MealResponse<MealFilter>) {
                    callback.onSuccess(model)
                }

                override fun onFailure(code: Int, errorMessage: String) {
                    callback.onFailed(code, errorMessage)
                }

                
            })
    }
}