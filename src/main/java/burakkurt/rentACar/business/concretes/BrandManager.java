package burakkurt.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import burakkurt.rentACar.business.abstracts.BrandService;
import burakkurt.rentACar.business.requests.CreateBrandRequest;
import burakkurt.rentACar.business.requests.UpdateBrandRequest;
import burakkurt.rentACar.business.responses.GetAllBrandResponse;
import burakkurt.rentACar.business.responses.GetByIdBrandResponse;
import burakkurt.rentACar.core.utilities.mappers.ModelMapperService;
import burakkurt.rentACar.dataAccess.abstracts.BrandRepository;
import burakkurt.rentACar.entities.concretes.Brand;
import burakkurt.rentACar.core.utilities.mappers.*;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();        

        List<GetAllBrandResponse>  brandsResponse = brands.stream()
            .map(brand->this.modelMapperService.forResponse()
            .map(brand,GetAllBrandResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest request) {
        Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest request) {
        Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse()
        .map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

}
