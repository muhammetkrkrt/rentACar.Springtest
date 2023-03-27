package rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import rentACar.business.abstracts.ModelServise;
import rentACar.business.requests.CreateModelRequest;
import rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import rentACar.core.utilies.mappers.ModelMapperService;
import rentACar.dataAccess.abstracts.ModelRepository;
import rentACar.entities.concretes.Model;


@Service
@AllArgsConstructor
public class ModelManager implements ModelServise {

	private ModelRepository modelRepository ;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		
       List<Model> models = modelRepository.findAll();
       
	   List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model -> this.modelMapperService.forResponse()
				.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		
		return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		
          Model model =this.modelMapperService.forRequest()
             .map(createModelRequest, Model.class);
		
		this.modelRepository.save(model);
		
	}

}
