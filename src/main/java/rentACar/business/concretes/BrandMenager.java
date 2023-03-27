package rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import rentACar.business.abstracts.BrandServise;
import rentACar.business.requests.CreateBrandRequest;
import rentACar.business.requests.UpdateBrandRequest;
import rentACar.business.responses.GetAllBrandsResponse;
import rentACar.business.responses.GetByIdBrandResponse;
import rentACar.business.rules.BrandBusinessRules;
import lombok.AllArgsConstructor;
import rentACar.core.utilies.mappers.ModelMapperService;
import rentACar.dataAccess.abstracts.BrandRepository;
import rentACar.entities.concretes.Brand;

@Service   // Bu sinif bir business nesnesidir
@AllArgsConstructor
public class BrandMenager  implements BrandServise{
       private BrandRepository brandRepository;
       private ModelMapperService modelMapperService;
       private BrandBusinessRules brandBusinessRules;
       
       
	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
	
		
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse()
				.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		
	
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand=this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
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
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		
		this.brandRepository.deleteById(id);
		
	}
 
}
