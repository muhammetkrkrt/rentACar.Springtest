package rentACar.business.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import rentACar.core.utilies.exceptions.BusinessException;
import rentACar.dataAccess.abstracts.BrandRepository;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	private BrandRepository brandRepository;

	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name already exists");
		}
	}
	
}
