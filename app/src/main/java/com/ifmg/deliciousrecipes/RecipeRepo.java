package com.ifmg.deliciousrecipes;

import com.ifmg.deliciousrecipes.classes.Meal;

import java.io.IOException;

public class RecipeRepo {
    private RecipeApi api;

    public RecipeRepo(RecipeApi api) {
        this.api = api;
    }

    public Meal getRandomRecipe() throws IOException {
        return api.getRandomRecipe().execute().body();
    }
}
