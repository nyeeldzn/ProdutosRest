package com.sunonrails.productscrud.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NonNull
    Long barcode;
    @NonNull
    String description;
    @NonNull
    Double price;
    @NonNull
    Long stock;
    @NonNull
    @DateTimeFormat
    Date created_date;

    public Product(){

    }

    public Product(Long id, Long barcode, @NonNull String description, Double price, Long stock) {
        this.id = id;
        this.barcode = barcode;
        this.description = description.toUpperCase(Locale.ROOT).trim();
        this.price = price;
        this.stock = stock;
        this.created_date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
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
        return Objects.equals(id, product.id) && barcode.equals(product.barcode) && description.equals(product.description) && price.equals(product.price) && stock.equals(product.stock) && created_date.equals(product.created_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, barcode, description, price, stock, created_date);
    }
}
