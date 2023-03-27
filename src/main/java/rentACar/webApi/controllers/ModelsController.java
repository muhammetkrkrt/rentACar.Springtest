package rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import rentACar.business.abstracts.ModelServise;
import rentACar.business.requests.CreateModelRequest;
import rentACar.business.responses.GetAllModelsResponse;

@RestController  // annotation
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
	private ModelServise modelServise;
	
	@GetMapping()
	public List<GetAllModelsResponse> getAll(){
		return modelServise.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
		this.modelServise.add(createModelRequest);
	}

	
}
