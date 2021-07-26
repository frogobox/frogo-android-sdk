package com.frogobox.sdk.consumable.meal

import android.content.Context
import com.frogobox.sdk.consumable.meal.data.model.*
import com.frogobox.sdk.consumable.meal.model.MealResponse
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
interface IConsumeTheMealDbApi {

    // Switch For Using Chuck Interceptor
    fun usingChuckInterceptor(context: Context)

    // Search meal by name
    fun searchMeal(mealName: String, callback: FrogoResponseCallback<MealResponse<Meal>>)

    // List all meals by first letter
    fun listAllMeal(firstLetter: String, callback: FrogoResponseCallback<MealResponse<Meal>>)

    // Lookup full meal details by id
    fun lookupFullMeal(idMeal: String, callback: FrogoResponseCallback<MealResponse<Meal>>)

    // Lookup a single random meal
    fun lookupRandomMeal(callback: FrogoResponseCallback<MealResponse<Meal>>)

    // List all meal categories
    fun listMealCategories(callback: FrogoResponseCallback<CategoryResponse>)

    // List all Categories
    fun listAllCateories(callback: FrogoResponseCallback<MealResponse<Category>>)

    // List all Area
    fun listAllArea(callback: FrogoResponseCallback<MealResponse<Area>>)

    // List all Ingredients
    fun listAllIngredients(callback: FrogoResponseCallback<MealResponse<Ingredient>>)

    // Filter by main ingredient
    fun filterByIngredient(ingredient: String, callback: FrogoResponseCallback<MealResponse<MealFilter>>)

    // Filter by Category
    fun filterByCategory(category: String, callback: FrogoResponseCallback<MealResponse<MealFilter>>)

    // Filter by Area
    fun filterByArea(area: String, callback: FrogoResponseCallback<MealResponse<MealFilter>>)

}