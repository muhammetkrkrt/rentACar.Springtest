package rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import rentACar.business.abstracts.BrandServise;
import rentACar.business.requests.CreateBrandRequest;
import rentACar.business.requests.UpdateBrandRequest;
import rentACar.business.responses.GetAllBrandsResponse;
import rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

@RestController  // annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandServise brandServise ;

	
	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		
		
		return brandServise.getAll();
		
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id){
		
		return brandServise.getById(id);
		
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
		this.brandServise.add(createBrandRequest);
	}

	@PutMapping
	public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		
		this.brandServise.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable int id) {
		this.brandServise.delete(id);
	}
	
	
}
