package rentACar.business.abstracts;

import java.util.List;

import rentACar.business.requests.CreateModelRequest;
import rentACar.business.responses.GetAllModelsResponse;

public interface ModelServise {

	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
