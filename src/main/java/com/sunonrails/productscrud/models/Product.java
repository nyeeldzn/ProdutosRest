package com.sunonrails.productscrud.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    float id;
    @NonNull
    int barcode;
    @NonNull
    String description;
    @NonNull
    float price;
    //estoque loja
    @NonNull
    @DateTimeFormat
    Date created_date;

    public Product(){

    }

    public Product(float id, int barcode, @NonNull String description, float price) {
        this.id = id;
        this.barcode = barcode;
        this.description = description;
        this.price = price;
        this.created_date = new Date();
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @NonNull
    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(@NonNull Date created_date) {
        this.created_date = created_date;
    }
}
