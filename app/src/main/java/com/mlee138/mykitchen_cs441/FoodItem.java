package com.mlee138.mykitchen_cs441;

import com.mlee138.mykitchen_cs441.NutritionalFacts;

public class FoodItem {

    private String name;
    private String quantity;
    private NutritionalFacts nf;

    public FoodItem(String nameIn, String quantityIn, NutritionalFacts nfIn){

        this.name = nameIn;
        this.quantity = quantityIn;
        this.nf = nfIn;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public NutritionalFacts getNf() {
        return nf;
    }

    public void setNf(NutritionalFacts nf) {
        this.nf = nf;
    }
}
