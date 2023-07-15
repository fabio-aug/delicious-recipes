package com.ifmg.deliciousrecipes.classes;

public class Recipe {
    public String strMeal; // Name
    public String strCategory; // Category
    public String strArea; // Origen
    public String strInstructions; // Instructions
    public String strMealThumb; // Image
    public String strYoutube; // Video
    public String strSource; // About
    public String strIngredient1;
    public String strIngredient2;
    public String strIngredient3;
    public String strIngredient4;
    public String strIngredient5;
    public String strIngredient6;
    public String strIngredient7;
    public String strIngredient8;
    public String strIngredient9;
    public String strIngredient10;
    public String strIngredient11;
    public String strIngredient12;
    public String strIngredient13;
    public String strIngredient14;
    public String strIngredient15;
    public String strIngredient16;
    public String strIngredient17;
    public String strIngredient18;
    public String strIngredient19;
    public String strIngredient20;
    public String strMeasure1;
    public String strMeasure2;
    public String strMeasure3;
    public String strMeasure4;
    public String strMeasure5;
    public String strMeasure6;
    public String strMeasure7;
    public String strMeasure8;
    public String strMeasure9;
    public String strMeasure10;
    public String strMeasure11;
    public String strMeasure12;
    public String strMeasure13;
    public String strMeasure14;
    public String strMeasure15;
    public String strMeasure16;
    public String strMeasure17;
    public String strMeasure18;
    public String strMeasure19;
    public String strMeasure20;

    private String getProperty(int id) {
        if (id == 1) return this.strIngredient1 + "@" + this.strMeasure1;
        if (id == 2) return this.strIngredient2 + "@" + this.strMeasure2;
        if (id == 3) return this.strIngredient3 + "@" + this.strMeasure3;
        if (id == 4) return this.strIngredient4 + "@" + this.strMeasure4;
        if (id == 5) return this.strIngredient5 + "@" + this.strMeasure5;
        if (id == 6) return this.strIngredient6 + "@" + this.strMeasure6;
        if (id == 7) return this.strIngredient7 + "@" + this.strMeasure7;
        if (id == 8) return this.strIngredient8 + "@" + this.strMeasure8;
        if (id == 9) return this.strIngredient9 + "@" + this.strMeasure9;
        if (id == 10) return this.strIngredient10 + "@" + this.strMeasure10;
        if (id == 11) return this.strIngredient11 + "@" + this.strMeasure11;
        if (id == 12) return this.strIngredient12 + "@" + this.strMeasure12;
        if (id == 13) return this.strIngredient13 + "@" + this.strMeasure13;
        if (id == 14) return this.strIngredient14 + "@" + this.strMeasure14;
        if (id == 15) return this.strIngredient15 + "@" + this.strMeasure15;
        if (id == 16) return this.strIngredient16 + "@" + this.strMeasure16;
        if (id == 17) return this.strIngredient17 + "@" + this.strMeasure17;
        if (id == 18) return this.strIngredient18 + "@" + this.strMeasure18;
        if (id == 19) return this.strIngredient19 + "@" + this.strMeasure19;
        if (id == 20) return this.strIngredient20 + "@" + this.strMeasure20;
        return "";
    }

    public String formatIngredients() {
        StringBuilder ingredients = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            String[] values = getProperty(i + 1).split("@");

            if (values.length >= 1) {
                String ingredient = values[0];
                String quantity = values[1];

                if (!ingredient.equals("") && !quantity.equals("")) {
                    ingredients.append(ingredient).append(" - ").append(quantity).append("\n");
                } else if (!ingredient.equals("")) {
                    ingredients.append(ingredient).append("\n");
                }
            }
        }

        String str = ingredients.toString();

        return str.substring(0, str.length() - 2);
    }
}
