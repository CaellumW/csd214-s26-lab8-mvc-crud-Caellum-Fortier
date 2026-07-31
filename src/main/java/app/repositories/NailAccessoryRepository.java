package app.repositories;
import app.entities.NailAccessoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NailAccessoryRepository extends JpaRepository<NailAccessoryEntity, Long> {
    List<NailAccessoryEntity> findNailAccessoryEntitiesByAccessoryTypeIgnoreCase(String accessoryType);
}
