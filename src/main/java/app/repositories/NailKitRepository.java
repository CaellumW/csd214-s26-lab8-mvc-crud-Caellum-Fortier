package app.repositories;
import app.entities.NailKitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NailKitRepository extends JpaRepository<NailKitEntity, Long> {
    List<NailKitEntity> findNailKitEntitiesByBrandIgnoreCase(String brand);

    List<NailKitEntity> findNailKitEntitiesByKitTypeIgnoreCase(String kitType);

    List<NailKitEntity> findNailKitEntitiesByKitLevelIgnoreCase(String kitLevel);
}
