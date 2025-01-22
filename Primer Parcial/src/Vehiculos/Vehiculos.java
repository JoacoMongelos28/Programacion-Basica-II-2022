package Vehiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Vehiculos {

	public Vehiculos() {
	}

	public abstract Boolean asignarChofer(Chofer nuevoChofer);

	public abstract Boolean cambiarChofer(Chofer chofer);

	public abstract Boolean agregarPasajeros(Pasajero nuevoPasajero);
}
