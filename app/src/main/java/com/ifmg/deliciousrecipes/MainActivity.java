package com.ifmg.deliciousrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ifmg.deliciousrecipes.classes.Meal;
import com.ifmg.deliciousrecipes.classes.Recipe;
import com.ifmg.deliciousrecipes.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public void openViewRecipe(Recipe recipe) {
        Intent intent = new Intent(this, ViewRecipeActivity.class);
        intent.putExtra(ViewRecipeActivity.INGREDIENTS_LIST, recipe.formatIngredients());
        intent.putExtra(ViewRecipeActivity.TITLE, recipe.strMeal);
        intent.putExtra(ViewRecipeActivity.CATEGORY, recipe.strCategory);
        intent.putExtra(ViewRecipeActivity.ORIGIN, recipe.strArea);
        intent.putExtra(ViewRecipeActivity.TUTORIAL, recipe.strInstructions);
        intent.putExtra(ViewRecipeActivity.IMAGE, recipe.strMealThumb);
        intent.putExtra(ViewRecipeActivity.VIDEO, recipe.strYoutube);
        intent.putExtra(ViewRecipeActivity.ABOUT, recipe.strSource);
        startActivity(intent);
    }

    public void fetchData() {
        RecipeApplication app = (RecipeApplication) getApplication();

        app.executor.execute(() -> {
            try {
                Meal meal = app.getRecipeRepo().getRandomRecipe();
                Recipe recipe = meal.meals[0];
                openViewRecipe(recipe);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.searchRecipe.setOnClickListener((v) -> fetchData());
    }
}