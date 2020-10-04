package com.example.mad_2020_inventers;

public class OrderItemListClass {
    String ItemName;
    int Quantity;
    String paymentMethod;

    public OrderItemListClass(String ItemName,int Quantity,String paymentMethod) {
        this.ItemName=ItemName;
        this.Quantity=Quantity;
        this.paymentMethod=paymentMethod;
    }

    public OrderItemListClass() {

    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}



