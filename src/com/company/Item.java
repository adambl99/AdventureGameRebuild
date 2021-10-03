package com.company;

public class Item {
    private String itemName;
    private String itemLongName;

    public Item(String itemName, String itemLongName){
        this.itemName = itemName;
        this.itemLongName = itemLongName;
    }
    public Item(String itemName){
        this.itemName = itemName;
        itemLongName = null;
    }

    public String getItemName(){
        return itemName;
    }
    public  String getItemLongName(){
        return itemLongName;
    }

    @Override
    public String toString(){
        return "Item: " + itemLongName + " (" + itemName + ")";
    }

}

