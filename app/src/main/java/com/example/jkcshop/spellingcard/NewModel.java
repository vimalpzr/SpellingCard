package com.example.jkcshop.spellingcard;

/**
 * Created by jkcshop on 8/30/2018.
 */

public  class NewModel {


    private String cat_name;
    private int cat_img;

    public NewModel( String cat_name,int cat_img) {
        this.cat_img = cat_img;
        this.cat_name = cat_name;
    }

    public int getCat_img() {
        return cat_img;
    }

    public String getCat_name() {
        return cat_name;
    }
}
