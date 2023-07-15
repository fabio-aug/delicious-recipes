package com.ifmg.deliciousrecipes;

import com.ifmg.deliciousrecipes.classes.Meal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeApi {
    @GET("random.php")
    Call<Meal> getRandomRecipe();
}
