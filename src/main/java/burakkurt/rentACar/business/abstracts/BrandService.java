package burakkurt.rentACar.business.abstracts;

import java.util.List;

import burakkurt.rentACar.entities.concretes.Brand;

public interface BrandService {
    List<Brand> getAll();
}
