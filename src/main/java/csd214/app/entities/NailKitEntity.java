package csd214.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.Objects;

@Entity
public class NailKitEntity extends NailProductEntity {
    @Column(name = "kit_type")
    private String kitType;

    public String getKitType() {
        return kitType;
    }

    public void setKitType(String kitType) {
        this.kitType = kitType;
    }

    @Column(name = "kit_level")
    private String kitLevel;

    public String getKitLevel() {
        return kitLevel;
    }

    public void setKitLevel(String kitLevel) {
        this.kitLevel = kitLevel;
    }

    @Column(name = "items")
    private ArrayList<NailProductEntity> items;

    public ArrayList<NailProductEntity> getItems() {
        return items;
    }
    public void setItems(ArrayList<NailProductEntity> items) {
        this.items = items;
    }

    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //    no param constructor
    public NailKitEntity() {
    }

    //    param constructor
    public NailKitEntity(String kitType, String kitLevel, ArrayList<NailProductEntity> items) {
        this.kitType = kitType;
        this.kitLevel = kitLevel;
        this.items = items;
    }

//    constructor just for ease of testing tbh
public NailKitEntity(String kitType, String kitLevel) {
    this.kitType = kitType;
    this.kitLevel = kitLevel;
}

    //    super constructor
    public NailKitEntity(String id, String brand, int stock, double price, String kitType, String kitLevel, ArrayList<NailProductEntity> items) {
        super(id, brand, stock, price);
        this.kitType = kitType;
        this.kitLevel = kitLevel;
        this.items = items;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NailKitEntity that = (NailKitEntity) o;
        return Objects.equals(kitType, that.kitType) && Objects.equals(kitLevel, that.kitLevel) && Objects.equals(items, that.items) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kitType, kitLevel, items, id);
    }

    @Override
    public String toString() {
        return "NailKitEntity{" +
                "kitType='" + kitType + '\'' +
                ", kitLevel='" + kitLevel + '\'' +
                ", items=" + items +
                ", id=" + id +
                "} " + super.toString();
    }
}
