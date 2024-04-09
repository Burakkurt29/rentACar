package burakkurt.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import burakkurt.rentACar.business.abstracts.BrandService;
import burakkurt.rentACar.business.requests.CreateBrandRequest;
import burakkurt.rentACar.business.requests.UpdateBrandRequest;
import burakkurt.rentACar.business.responses.GetAllBrandResponse;
import burakkurt.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandResponse> getAll(){
        return brandService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody() CreateBrandRequest request) {
        this.brandService.add(request);
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable() int id){
        return this.brandService.getById(id);
    }

    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest request) {
        this.brandService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable() int id){
        this.brandService.delete(id);

    }
}
