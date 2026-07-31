package csd214.app.repositories;

import csd214.app.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // Derived Query Methods: Spring generates database queries automatically based on method names [7]
    List<ProductEntity> findByNameContainingIgnoreCase(String name);
    List<ProductEntity> findByAuthorContainingIgnoreCase(String author);
}
