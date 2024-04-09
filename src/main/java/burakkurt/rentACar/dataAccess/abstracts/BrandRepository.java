package burakkurt.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakkurt.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
