package com.frogobox.sdk.consumable.meal

import android.content.Context
import com.frogobox.sdk.consumable.meal.data.model.*
import com.frogobox.sdk.consumable.meal.model.MealResponse
import com.frogobox.sdk.consumable.meal.source.MealRemoteDataSource
import com.frogobox.sdk.consumable.meal.model.*
import com.frogobox.sdk.core.FrogoResponseCallback

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
 * com.frogobox.frogomealsapi
 *
 */
class ConsumeTheMealDbApi(private val apiKey: String) : IConsumeTheMealDbApi {

    private val repository = MealRemoteDataSource

    override fun usingChuckInterceptor(context: Context) {
        repository.usingChuckInterceptor(context)
    }

    override fun searchMeal(mealName: String, callback: FrogoResponseCallback<MealResponse<Meal>>) {
        repository.searchMeal(apiKey, mealName, callback)
    }

    override fun listAllMeal(
        firstLetter: String,
        callback: FrogoResponseCallback<MealResponse<Meal>>
    ) {
        repository.listAllMeal(apiKey, firstLetter, callback)
    }

    override fun lookupFullMeal(
        idMeal: String,
        callback: FrogoResponseCallback<MealResponse<Meal>>
    ) {
        repository.lookupFullMeal(apiKey, idMeal, callback)
    }

    override fun lookupRandomMeal(callback: FrogoResponseCallback<MealResponse<Meal>>) {
        repository.lookupRandomMeal(apiKey, callback)
    }

    override fun listMealCategories(callback: FrogoResponseCallback<CategoryResponse>) {
        repository.listMealCategories(apiKey, callback)
    }

    override fun listAllCateories(callback: FrogoResponseCallback<MealResponse<Category>>) {
        repository.listAllCateories(apiKey, callback)
    }

    override fun listAllArea(callback: FrogoResponseCallback<MealResponse<Area>>) {
        repository.listAllArea(apiKey, callback)
    }

    override fun listAllIngredients(callback: FrogoResponseCallback<MealResponse<Ingredient>>) {
        repository.listAllIngredients(apiKey, callback)
    }

    override fun filterByIngredient(
        ingredient: String,
        callback: FrogoResponseCallback<MealResponse<MealFilter>>
    ) {
        repository.filterByIngredient(apiKey, ingredient, callback)
    }

    override fun filterByCategory(
        category: String,
        callback: FrogoResponseCallback<MealResponse<MealFilter>>
    ) {
        repository.filterByCategory(apiKey, category, callback)
    }

    override fun filterByArea(
        area: String,
        callback: FrogoResponseCallback<MealResponse<MealFilter>>
    ) {
        repository.filterByArea(apiKey, area, callback)
    }
}