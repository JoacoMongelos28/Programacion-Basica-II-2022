package Evaluacion;

import java.util.Objects;

public class Persona implements Comparable <Persona> {

	private String nombre;
	private Integer numeroDeMovil;

	public Persona(String nombre, Integer numeroDeMovil) {
		this.nombre = nombre;
		this.numeroDeMovil = numeroDeMovil;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNumeroDeMovil() {
		return numeroDeMovil;
	}

	@Override
	public int compareTo(Persona otraPersona) {
		return this.nombre.compareTo(otraPersona.getNombre());
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroDeMovil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(numeroDeMovil, other.numeroDeMovil);
	}
	
}
