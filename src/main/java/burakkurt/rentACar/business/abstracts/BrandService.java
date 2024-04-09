package burakkurt.rentACar.business.abstracts;

import java.util.List;

import burakkurt.rentACar.business.requests.CreateBrandRequest;
import burakkurt.rentACar.business.requests.UpdateBrandRequest;
import burakkurt.rentACar.business.responses.GetAllBrandResponse;
import burakkurt.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {
    List<GetAllBrandResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest request);
    void update(UpdateBrandRequest request);
    void delete(int id);
}
