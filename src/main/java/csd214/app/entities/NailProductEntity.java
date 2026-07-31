package csd214.app.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class NailProductEntity extends ProductEntity{
    @Column(name = "brand")
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand= brand;
    }

    @Column(name = "stock", nullable = false)
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Column(name = "price", nullable = false)
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public NailProductEntity() {}

    public NailProductEntity(String id, String brand, int stock, double price) {
        super(id);
        this.brand = brand;
        this.stock = stock;
        this.price = price;
    }



}
