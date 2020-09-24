package br.com.planeta.dtos;

public class PlanetaDTO {

//	private Long id;
	private String name;
	private String climate;
	private String terrain;
	private int numeroAparicoes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public int getNumeroAparicoes() {
		return numeroAparicoes;
	}
	public void setNumeroAparicoes(int numeroAparicoes) {
		this.numeroAparicoes = numeroAparicoes;
	}

	
}
