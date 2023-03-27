package rentACar.business.abstracts;

import java.util.List;

import rentACar.business.requests.CreateBrandRequest;
import rentACar.business.requests.UpdateBrandRequest;
import rentACar.business.responses.GetAllBrandsResponse;
import rentACar.business.responses.GetByIdBrandResponse;

public interface BrandServise {

	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById (int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}
