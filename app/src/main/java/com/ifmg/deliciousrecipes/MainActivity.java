package com.ifmg.deliciousrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ifmg.deliciousrecipes.classes.Meal;
import com.ifmg.deliciousrecipes.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    public void fetchData() {
        RecipeApplication app = (RecipeApplication) getApplication();

        app.executor.execute(() -> {
            try {
                Meal a = app.getRecipeRepo().getRandomRecipe();
                Log.d("RECIPES-PRINT", a.meals[0].toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        binding.searchRecipe.setOnClickListener((v) -> fetchData());
    }
}