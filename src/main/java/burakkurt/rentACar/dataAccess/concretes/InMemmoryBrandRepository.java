package burakkurt.rentACar.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import burakkurt.rentACar.dataAccess.abstracts.BrandRepository;
import burakkurt.rentACar.entities.concretes.Brand;

@Repository
public class InMemmoryBrandRepository implements BrandRepository {
    List<Brand> brands;
    
    public InMemmoryBrandRepository() {
        brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"BMW"));
        brands.add(new Brand(2,"MERCEDES"));
        brands.add(new Brand(3,"AUDI"));
        brands.add(new Brand(4,"FIAT"));
    }


    @Override
    public List<Brand> getAll() {
        return brands;
    }
   
}
