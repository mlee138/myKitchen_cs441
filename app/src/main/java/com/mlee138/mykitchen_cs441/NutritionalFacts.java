package com.mlee138.mykitchen_cs441;

public class NutritionalFacts {

    private String calories, carbs, fat, protein, sodium, sugar;

    public NutritionalFacts(String caloriesIn, String carbsIn
                            , String fatIn, String proteinIn
                            , String sodiumIn, String sugarIn){
        this.calories = caloriesIn;
        this.carbs = carbsIn;
        this.fat = fatIn;
        this.protein = proteinIn;
        this.sodium = sodiumIn;
        this.sugar = sugarIn;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }
}
