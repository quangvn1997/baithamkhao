package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min = 7, message = "it nhat 8 ky tu")
    private String name;
    @NotBlank(message = "Null roi")
    private String categoryId;
    private String description;
    private String imgUrl;
    @Min(1)
    private int price;
    private String createdAt;
    private String updatedAt;
    private int status;

    public Dish() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.createdAt = timestamp.toString();
        this.updatedAt = timestamp.toString();
        this.status = 1;
    }

    public Dish(@Size(min = 7, message = "it nhat 8 ky tu") String name, @NotBlank(message = "Null roi") String categoryId, String description, String imgUrl, @Min(1) int price, String createdAt, String updatedAt, int status) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.createdAt = "1";
        this.updatedAt = "1";
        this.status = 1;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
