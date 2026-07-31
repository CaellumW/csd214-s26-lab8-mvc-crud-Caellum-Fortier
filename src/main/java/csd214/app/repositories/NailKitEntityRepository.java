package csd214.app.repositories;
import csd214.app.entities.NailKitEntity;
import csd214.app.entities.NailProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface NailKitEntityRepository extends JpaRepository<NailKitEntity, Long> {
    List<NailKitEntity> findNailKitEntitiesByBrandIgnoreCase(String brand);

    List<NailKitEntity> findNailKitEntitiesByKitTypeIgnoreCase(String kitType);

    List<NailKitEntity> findNailKitEntitiesByKitLevelIgnoreCase(String kitLevel);
}
