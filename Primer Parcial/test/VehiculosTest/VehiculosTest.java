package VehiculosTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import Vehiculos.Auto;
import Vehiculos.Autobus;
import Vehiculos.Chofer;
import Vehiculos.Moto;
import Vehiculos.Pasajero;
import Vehiculos.Persona;
import Vehiculos.Vehiculos;

public class VehiculosTest {

	@Test
	public void queExistaAutobusYMoto() {
		Vehiculos autobus = new Autobus(20.0);
		Vehiculos moto = new Moto(20.0);

		assertNotNull(autobus);
		assertNotNull(moto);
	}

	@Test
	public void queExistaChofer() {
		Chofer joaquin = new Chofer("Joaquin");

		assertNotNull(joaquin);
	}

	@Test
	public void queSePuedaAsignarUnChoferAUnVehiculo() {
		Chofer chofer = new Chofer("Joaquin");
		Autobus nuevo = new Autobus(20.0);

		Boolean valorObtenido = nuevo.asignarChofer(chofer);

		assertTrue(valorObtenido);

		Chofer chofer2 = new Chofer("Joaquin");
		Moto nuevo2 = new Moto(20.0);

		Boolean valorObtenido2 = nuevo2.asignarChofer(chofer2);

		assertTrue(valorObtenido2);

		Chofer chofer3 = new Chofer("Hector");
		Auto nuevo3 = new Auto(20.0);

		Boolean valorObtenido3 = nuevo3.asignarChofer(chofer3);

		assertTrue(valorObtenido3);
	}

	@Test
	public void queNoPuedaHaberDosChoferesIguales() {
		Chofer chofer = new Chofer("Joaquin");
		Autobus nuevo = new Autobus(20.0);

		nuevo.asignarChofer(chofer);
		Boolean valorObtenido = nuevo.asignarChofer(chofer);

		assertFalse(valorObtenido);
	}

	@Test
	public void queSePuedaAgregarPasajero() {
		Pasajero nuevo = new Pasajero("Hector");

		Autobus autobus = new Autobus(20.0);

		Boolean valorObtenido = autobus.agregarPasajeros(nuevo);

		assertTrue(valorObtenido);
	}

	@Test
	public void saberLosKilometrosRecorridosDelAutobus() {
		Autobus autobus = new Autobus(20.0);

		Double valorObtenido = autobus.getCantidadDeKilometrosRecorridos();

		Assert.assertEquals(valorObtenido, 20.0, 0.01);
	}

	@Test
	public void saberLosKilometrosRecorridosDeLaMoto() {
		Moto moto = new Moto(20.0);

		Double valorObtenido = moto.getCantidadDeKilometrosRecorridos();

		Assert.assertEquals(valorObtenido, 20.0, 0.01);
	}

	@Test
	public void queSeSepaLaCantidadDePasajeros() {
		Pasajero nuevo = new Pasajero("Hector");
		Pasajero nuevo2 = new Pasajero("Juan");
		Pasajero nuevo3 = new Pasajero("Hernan");

		Autobus autobus = new Autobus(20.0);

		autobus.agregarPasajeros(nuevo);
		autobus.agregarPasajeros(nuevo2);
		autobus.agregarPasajeros(nuevo3);

		Integer valorEsperado = 3;
		Integer valorObtenido = autobus.saberCantidadDePasajeros();

		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queNoSePuedaCambiarDeChoferSiHayPasajeros() {
		Chofer chofer = new Chofer("Joaquin");
		Autobus nuevo = new Autobus(20.0);
		Pasajero pasajero = new Pasajero("Hector");

		nuevo.agregarPasajeros(pasajero);

		Boolean valorObtenido = nuevo.cambiarChofer(chofer);

		assertFalse(valorObtenido);
	}

	@Test
	public void queNoPuedaHaberMasDeTresPasajerosEnUnAuto() {
		Auto auto = new Auto(20.0);
		Pasajero nuevo = new Pasajero("Hector");
		Pasajero nuevo2 = new Pasajero("Juan");
		Pasajero nuevo3 = new Pasajero("Hernan");
		Pasajero nuevo4 = new Pasajero("Hernan");
		Pasajero nuevo5 = new Pasajero("Hernan");
		Pasajero nuevo6 = new Pasajero("Hernan");

		auto.agregarPasajeros(nuevo);
		auto.agregarPasajeros(nuevo2);
		auto.agregarPasajeros(nuevo3);
		auto.agregarPasajeros(nuevo4);
		auto.agregarPasajeros(nuevo5);
		auto.agregarPasajeros(nuevo6);

		Integer valorObtenido = auto.saberCantidadDePasajeros();
		Integer valorEsperado = 3;

		Assert.assertEquals(valorObtenido, valorEsperado);
	}

	@Test
	public void queSePuedaCambiarDeChofer() {
		Chofer chofer = new Chofer("Joaquin");
		Chofer chofer2 = new Chofer("Leo");
		

		Autobus autobus = new Autobus(20.0);

		autobus.asignarChofer(chofer);
		autobus.cambiarChofer(chofer2);
	}

	
	@Test
	public void queNoPuedaHaberMasDeDosChoferes() {
		Chofer chofer = new Chofer("Joaquin");
		Chofer chofer2 = new Chofer("Leo");
		
		Autobus autobus = new Autobus(20.0);
		
		autobus.asignarChofer(chofer);
		Boolean valorObtenido = autobus.asignarChofer(chofer2);
		
		assertFalse(valorObtenido);
		
	}
}