package Vehiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Auto extends Vehiculos {

	private final Integer CANTIDAD_MAXIMA_DE_PASAJEROS = 3;
	private Double CantidadDeKilometrosRecorridos;
	private Chofer choferActual;
	private List<Pasajero> pasajeros;
	private List<Chofer> choferes;
	private Integer cantidadDePasajeros;
	private Integer CANTIDAD_MAXIMA_DE_CHOFERES;

	public Auto(Double cantidadDeKilometrosRecorridos) {
		this.choferActual = null;
		this.pasajeros = new ArrayList<Pasajero>();
		this.choferes = new ArrayList<Chofer>();
		this.CantidadDeKilometrosRecorridos = cantidadDeKilometrosRecorridos;
		this.cantidadDePasajeros = 0;
		this.CANTIDAD_MAXIMA_DE_CHOFERES = 1;
	}

	public Boolean comprobarSiExisteChofer(Persona chofer2) {
		Boolean existe = false;
		for (Chofer chofer : choferes) {
			if (chofer2.equals(chofer)) {
				existe = true;
			}
		}
		return existe;
	}

	public Boolean comprobarSiExistePasajero(Pasajero pasajero2) {
		Boolean existe = false;
		for (Pasajero pasajero : pasajeros) {
			if (pasajero2.equals(pasajero)) {
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public Boolean agregarPasajeros(Pasajero nuevoPasajero) {
		if (pasajeros.size() < CANTIDAD_MAXIMA_DE_PASAJEROS && !comprobarSiExistePasajero(nuevoPasajero)) {
			pasajeros.add(nuevoPasajero);
			this.cantidadDePasajeros++;
			return true;
		}
		return false;
	}

	@Override
	public Boolean asignarChofer(Chofer chofer) {
		if (!comprobarSiExisteChofer(chofer) && choferes.size() < CANTIDAD_MAXIMA_DE_CHOFERES) {
			choferes.add(chofer);
			return true;
		}
		return false;
	}

	@Override
	public Boolean cambiarChofer(Chofer chofer) {
		Boolean sePudoCambiar = false;
		for (Pasajero pasajero : pasajeros) {
			if (pasajero != null) {
				sePudoCambiar = false;
			} else {
				this.choferActual = chofer;
				sePudoCambiar = true;
			}
		}
		return sePudoCambiar;
	}

	public Double getCantidadDeKilometrosRecorridos() {
		return CantidadDeKilometrosRecorridos;
	}

	public Integer saberCantidadDePasajeros() {
		return cantidadDePasajeros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(choferes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		return Objects.equals(choferes, other.choferes);
	}

	public String getNombre() {
		return choferActual.getNombre();
	}
}
