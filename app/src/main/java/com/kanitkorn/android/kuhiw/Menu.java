package com.kanitkorn.android.kuhiw;

/**
 * Created by Lukyth on 10/19/2015 AD.
 */
public class Menu {
    public String name;
    public Integer minPrice;
    public Integer maxPrice;

    public Menu(String name, Integer minPrice, Integer maxPrice) {
        this.name = name;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }
}