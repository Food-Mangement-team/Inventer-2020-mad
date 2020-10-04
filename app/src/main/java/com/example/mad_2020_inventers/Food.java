package com.example.mad_2020_inventers;

public class Food {

    private String Name;
    private String Image;
    private String Description;
    private String Price;
    private String Discount;
    private String MenyId;

    public Food() {

    }

    public Food(String name, String image, String description, String price, String discount, String menyId) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Discount = discount;
        MenyId = menyId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenyId() {
        return MenyId;
    }

    public void setMenyId(String menyId) {
        MenyId = menyId;
    }
}
