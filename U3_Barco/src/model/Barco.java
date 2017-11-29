package model;

import java.io.Serializable;

public class Barco implements Serializable{
	private Long id;
	private String pais;
	private String capitan;
	private int capacidad;
	
	public Barco(Long id, String pais, String capitan, int capacidad) {
		super();
		this.id = id;
		this.pais = pais;
		this.capitan = capitan;
		this.capacidad = capacidad;
	}

	public Barco() {
		this(0L,"","",0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCapitan() {
		return capitan;
	}

	public void setCapitan(String capitan) {
		this.capitan = capitan;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Barco [id=" + id + ", pais=" + pais + ", capitan=" + capitan + ", capacidad=" + capacidad + "]";
	}
	
	
	
	
}
