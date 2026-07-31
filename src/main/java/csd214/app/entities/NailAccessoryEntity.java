package csd214.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class NailAccessoryEntity extends NailProductEntity{
    @Column (name = "Accessory_type")
    private String accessoryType;

    public String getAccessoryType() {
        return accessoryType;
    }

    public void setAccessoryType(String accessoryType) {
        this.accessoryType = accessoryType;
    }

    @Column(name = "id")
    private Long id;

    public Long getId() {
        return super.getId();
    }
    public void setId(Long id) {
        this.id = id;
    }

    public NailAccessoryEntity() {
    }

    public NailAccessoryEntity(String id, String brand, int stock, double price) {
        super(id, brand, stock, price);
    }

    public NailAccessoryEntity(String accessoryType) {
        this.accessoryType = accessoryType;
    }

    public NailAccessoryEntity(String id, String brand, int stock, double price, String accessoryType) {
        super(id, brand, stock, price);
        this.accessoryType = accessoryType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NailAccessoryEntity that = (NailAccessoryEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
