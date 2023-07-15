package com.ifmg.deliciousrecipes;

import android.app.Application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeApplication extends Application {
    public Executor executor = Executors.newFixedThreadPool(1);
    private RecipeRepo recipeRepo;

    public RecipeRepo getRecipeRepo() {
        if (this.recipeRepo != null) return this.recipeRepo;

        RecipeApi api = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RecipeApi.class);

        this.recipeRepo = new RecipeRepo(api);

        return this.recipeRepo;
    }
}
