package burakkurt.rentACar.dataAccess.abstracts;

import java.util.List;

import burakkurt.rentACar.entities.concretes.Brand;

public interface BrandRepository {
    List<Brand> getAll();

}
