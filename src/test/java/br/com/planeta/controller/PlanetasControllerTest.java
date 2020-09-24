package br.com.planeta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
public class PlanetasControllerTest {

	@GetMapping(value = "/teste")
	public String getMethodName() {
		return "teste";
	}

}
