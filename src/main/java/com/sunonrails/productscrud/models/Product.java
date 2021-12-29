package com.sunonrails.productscrud.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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
    @NonNull
    int stock;
    @NonNull
    @DateTimeFormat
    Date created_date;

    public Product(){

    }

    public Product(float id, int barcode, @NonNull String description, float price, int stock) {
        this.id = id;
        this.barcode = barcode;
        this.description = description;
        this.price = price;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @NonNull
    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(@NonNull Date created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id + '\'' +
                ", barcode=" + barcode +'\''+
                ", description='" + description + '\'' +
                ", price=" + price +'\''+
                ", stock=" + stock +'\''+
                ", created_date=" + created_date +'\''+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.id, id) == 0 && barcode == product.barcode && Float.compare(product.price, price) == 0 && stock == product.stock && description.equals(product.description) && created_date.equals(product.created_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, barcode, description, price, stock, created_date);
    }
}
