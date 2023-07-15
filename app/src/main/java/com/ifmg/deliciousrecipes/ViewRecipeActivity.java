package com.ifmg.deliciousrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ifmg.deliciousrecipes.databinding.ActivityViewRecipeBinding;
import com.squareup.picasso.Picasso;

public class ViewRecipeActivity extends AppCompatActivity {
    public static String INGREDIENTS_LIST = "ViewRecipeActivity_INGREDIENTS_LIST";
    public static String TITLE = "ViewRecipeActivity_TITLE";
    public static String CATEGORY = "ViewRecipeActivity_CATEGORY";
    public static String ORIGIN = "ViewRecipeActivity_ORIGIN";
    public static String TUTORIAL = "ViewRecipeActivity_TUTORIAL";
    public static String IMAGE = "ViewRecipeActivity_IMAGE";
    public static String VIDEO = "ViewRecipeActivity_VIDEO";
    public static String ABOUT = "ViewRecipeActivity_ABOUT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewRecipeBinding binding = ActivityViewRecipeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String ingredients = intent.getStringExtra(INGREDIENTS_LIST);
        binding.recipeIngredients.setText(ingredients);
        String title = intent.getStringExtra(TITLE);
        binding.recipeTitle.setText(title);
        String category = intent.getStringExtra(CATEGORY);
        binding.recipeCategory.setText(category);
        String origin = intent.getStringExtra(ORIGIN);
        binding.recipeOrigin.setText(origin);
        String tutorial = intent.getStringExtra(TUTORIAL);
        binding.recipeTutorial.setText(tutorial);
        String image = intent.getStringExtra(IMAGE);
        Picasso.get().load(image).into(binding.imageRecipe);
        String video = intent.getStringExtra(VIDEO);
        binding.recipeVideo.setText(video);
        String about = intent.getStringExtra(ABOUT);
        binding.recipeAbout.setText(about);
    }
}