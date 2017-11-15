package net.cuongmai.onlineshop.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    @NotBlank(message = "Product name must not be empty!")
    private String name;

    @Column(name = "brand")
    @NotBlank(message = "Brand name must not be empty!")
    private String brand;

    @Column(name = "description")
    @NotBlank(message = "Description must not be empty!")
    private String description;

    @Column(name = "unit_price")
    @Min(value = 1, message = "Please enter a valid unit price!")
    private double unitPrice;

    @Column(name = "quantity")
    @Min(value = 0, message = "Quantity must not be negative!")
    private int quantity;

    @Column(name = "active")
    private boolean active;

    @Column(name = "category_id")
    @Min(value = 1, message = "Please select a category!")
    private int categoryId;

    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "purchases")
    private int purchases;

    @Column(name = "views")
    private int views;

    @Transient
    private MultipartFile thumbnailImage;

    public Product() {
        setCode();
        setActive(true);
        setPurchases(0);
        setViews(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode() {
        this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public MultipartFile getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(MultipartFile thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }
}
