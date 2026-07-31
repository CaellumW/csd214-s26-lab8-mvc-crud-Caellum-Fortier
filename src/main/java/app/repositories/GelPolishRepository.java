package app.repositories;
import app.entities.GelPolishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GelPolishRepository extends JpaRepository<GelPolishEntity, Long> {
    List<GelPolishEntity> findGelPolishEntitiesByColourShade(String colourShade);

    List<GelPolishEntity> findGelPolishEntitiesByBrandContainingIgnoreCase(String brand);

    List<GelPolishEntity> findGelPolishEntitiesByTextureIgnoreCase(String texture);
}
