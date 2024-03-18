package com.TechSell.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="img_url")
    private String img_url;

    @Column(name="price")
    private double price;

    @Column(name="color")
    private String color;

    @Column(name="description")
    private String description;

    @Column(name="category")
    private String category;

    public Products() {
    }

    public Products(int id, String name, String img_url, double price, String description, String category) {
        this.id = id;
        this.name = name;
        this.img_url = img_url;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img_url='" + img_url + '\'' +
                ", price=" + price +
                ", color=" + color +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
