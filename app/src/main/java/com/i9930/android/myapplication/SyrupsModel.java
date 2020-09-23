package com.i9930.android.myapplication;

public class SyrupsModel {

    public SyrupsModel() {
    }

    public SyrupsModel(String name, String image, String brand, String price, String description) {
        this.name = name;
        this.image = image;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private  String name,image,brand,price,description;

}
