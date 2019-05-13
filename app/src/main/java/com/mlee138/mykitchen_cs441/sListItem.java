package com.mlee138.mykitchen_cs441;

public class sListItem {
    private String name;
    private int quantity;

    public sListItem (String _name, int _quantity){
        this.name = _name;
        this.quantity = _quantity;
    }

    public String getName(){
        return this.name;
    }

    public int getQuantity(){
        return this.quantity;
    }
}
