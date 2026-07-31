package csd214.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class GelPolishEntity extends NailProductEntity{
    @Column(name = "colour_Shade")
    private String colourShade;

    public String getColourShade() {
        return colourShade;
    }

    public void setColourShade(String colourShade) {
        this.colourShade = colourShade;
    }

    @Column(name = "texture")
    private String texture;

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    @Column(name = "id")
    private Long id;

    public Long getId() {
        return super.getId();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GelPolishEntity() {
    }

    public GelPolishEntity(String colourShade) {
        this.colourShade = colourShade;
    }

    public GelPolishEntity(String id, String brand, int stock, double price, String colourShade, String texture) {
        super(id, brand, stock, price);
        this.colourShade = colourShade;
        this.texture = texture;
    }

    @Override
    public String toString() {
        return "GelPolishEntity{" +
                "colourShade='" + colourShade + '\'' +
                ", texture='" + texture + '\'' +
                ", ID='" + id + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GelPolishEntity that = (GelPolishEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
