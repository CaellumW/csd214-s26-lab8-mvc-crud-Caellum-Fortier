package csd214.app.repositories;
import csd214.app.entities.NailAccessoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NailAccessoryEntityRepository extends JpaRepository<NailAccessoryEntity, Long> {
    List<NailAccessoryEntity> findNailAccessoryEntitiesByAccessoryTypeIgnoreCase(String accessoryType);
}
