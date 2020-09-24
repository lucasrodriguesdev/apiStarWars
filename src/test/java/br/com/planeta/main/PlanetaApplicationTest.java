package br.com.planeta.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.planeta.entities.PlanetaTest;
class PlanetaApplicationTest {

	@Test
	public void consumeAPI() {
		RestTemplate template = new RestTemplate();
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("swapi.dev/api")
				.path("planets/1/")
				.build();
		PlanetaTest planeta = new PlanetaTest();
		planeta.setName("Tatooine");
		planeta.setClimate("arid");
		planeta.setTerrain("desert");
		
		ResponseEntity<PlanetaTest> entidade = template.getForEntity(uri.toUriString(), PlanetaTest.class);
		assertEquals(entidade.getStatusCode(), HttpStatus.OK);
		assertEquals(entidade.getBody().getName(), planeta.getName());
		assertEquals(entidade.getBody().getClimate(), planeta.getClimate());
		assertEquals(entidade.getBody().getTerrain(), "desert");
		System.out.println(entidade);
	}
	
	
	@Test
	public void testeJsonRestTemplate() throws JSONException {
		final RestTemplate restTemplate = new RestTemplate();
		final String response = restTemplate.getForObject("https://swapi.dev/api/planets/", String.class);
		JSONObject root = new JSONObject(response);
		JSONArray jsonArray = root.getJSONArray("results");
		String numberPlanets = root.getString("count");
		int count = 0;
		for(int i=0; i< jsonArray.length(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			 String testePlanetName = object.getString("name");
			 System.out.println(testePlanetName);	 
			 count++;
		}
		System.out.println(response);
		System.out.println(numberPlanets);
		System.out.println("Numero de total de planetas por página==>" + count);
	}
}
