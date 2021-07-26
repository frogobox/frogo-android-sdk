package com.frogobox.sdk.consumable.meal.source

import android.content.Context
import com.frogobox.sdk.consumable.meal.data.model.*
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
 * com.frogobox.frogomealsapi.data.source
 *
 */
interface MealDataSource {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Search meal by name
    fun searchMeal(apiKey: String, mealName: String, callback: FrogoResponseCallback<MealResponse<Meal>>)

    // List all meals by first letter
    fun listAllMeal(apiKey: String, firstLetter: String, callback: FrogoResponseCallback<MealResponse<Meal>>)

    // Lookup full meal details by id
    fun lookupFullMeal(apiKey: String, idMeal: String, callback: FrogoResponseCallback<MealResponse<Meal>>)

    // Lookup a single random meal
    fun lookupRandomMeal(apiKey: String, callback: FrogoResponseCallback<MealResponse<Meal>>)

    // List all meal categories
    fun listMealCategories(apiKey: String, callback: FrogoResponseCallback<CategoryResponse>)

    // List all Categories
    fun listAllCateories(apiKey: String, callback: FrogoResponseCallback<MealResponse<Category>>)

    // List all Area
    fun listAllArea(apiKey: String, callback: FrogoResponseCallback<MealResponse<Area>>)

    // List all Ingredients
    fun listAllIngredients(apiKey: String, callback: FrogoResponseCallback<MealResponse<Ingredient>>)

    // Filter by main ingredient
    fun filterByIngredient(apiKey: String, ingredient: String, callback: FrogoResponseCallback<MealResponse<MealFilter>>)

    // Filter by Category
    fun filterByCategory(apiKey: String, category: String, callback: FrogoResponseCallback<MealResponse<MealFilter>>)

    // Filter by Area
    fun filterByArea(apiKey: String, area: String, callback: FrogoResponseCallback<MealResponse<MealFilter>>)


}