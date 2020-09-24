package br.com.planeta.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.planeta.dtos.PlanetaDTO;
import br.com.planeta.entities.Planeta;
import br.com.planeta.repositories.PlanetaRepository;

@RestController
@RequestMapping("api/planetas")
public class PlanetasController {

	@Autowired
	private PlanetaRepository repository;
	private String uri = "https://swapi.dev/api/planets/";
	
	public PlanetasController(PlanetaRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List findAll(){
	  return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Planeta> findById(@PathVariable long id){
	  return repository.findById(id)
	          .map(record -> ResponseEntity.ok().body(record))
	          .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = {"/name/{name}"})
	public ResponseEntity<Planeta> findByName(@PathVariable String name){
	  return repository.findByName(name)
	          .map(record -> ResponseEntity.ok().body(record))
	          .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Planeta create(@RequestBody Planeta planeta){
	    return repository.save(planeta);
	}
	
	@DeleteMapping(path ={"/{id}"})
	  public ResponseEntity<?> delete(@PathVariable("id") long id) {
	    return repository.findById(id)
	        .map(record -> {
	            repository.deleteById(id);
	            return ResponseEntity.ok().build();
	        }).orElse(ResponseEntity.notFound().build());
	  }
	
	@GetMapping("/consume")
	public List<PlanetaDTO> testeJsonRestTemplate() throws JSONException {
		List<PlanetaDTO> planetas = new ArrayList<PlanetaDTO>();
		PlanetaDTO planetaDTO = new PlanetaDTO();
		
		final RestTemplate restTemplate = new RestTemplate();
		final String response = restTemplate.getForObject(uri, String.class);
		JSONObject root = new JSONObject(response);
		JSONArray jsonArray = root.getJSONArray("results");

		for(int i=0; i< jsonArray.length(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			 
			 planetaDTO.setName(object.getString("name"));
			 planetaDTO.setTerrain(object.getString("terrain"));
			 planetaDTO.setClimate(object.getString("climate"));
			 planetas.add(planetaDTO);
		}

		return planetas;
	}
	
	@GetMapping("/consume/{id}")
	public PlanetaDTO testeJsonRestTemplate(@PathVariable("id") String id) throws JSONException {
		PlanetaDTO planetaDTO = new PlanetaDTO();
		
		final RestTemplate restTemplate = new RestTemplate();
		final String response = restTemplate.getForObject(uri+id+"/", String.class);
		JSONObject root = new JSONObject(response);
		JSONArray jsonArray = root.getJSONArray("films");
		planetaDTO.setName(root.getString("name"));
		planetaDTO.setTerrain(root.getString("terrain"));
		planetaDTO.setClimate(root.getString("climate"));
		planetaDTO.setNumeroAparicoes(jsonArray.length());
		
		return planetaDTO;
	}
}
