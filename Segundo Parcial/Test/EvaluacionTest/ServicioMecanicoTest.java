package EvaluacionTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import Evaluacion.Cliente;
import Evaluacion.NoHayClientesParaAtender;
import Evaluacion.ServicioMecanico;

public class ServicioMecanicoTest {
	
	/*NO USE LA CLASE CALENDAR PORQUE NO SABIA COMO UTILIZARLO*/
	
	@Test
	public void queSePuedaCrearUnServicioMecanicoYUnClienteConNombreYNumeroDeCelular() {
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234);
		
		assertNotNull(actual);
		assertNotNull(cliente);
	}
	
	@Test
	public void queUnClientefechaYHoraDeLlegadaYFechaYHoraDeAtenciónLuegoDeSerAtendido() {
		Integer fechaDeLlegada = 12;
		Double horaDeLlegada = 15.0;
		Integer fechaDeAtencion = 16;
		Double horaDeAtencion = 20.0;
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234, fechaDeLlegada, horaDeLlegada, fechaDeAtencion, horaDeAtencion);
		
		actual.agregarClientes(cliente);
		
		//Antes de ser atendido
		Assert.assertEquals(fechaDeLlegada, cliente.getFechaDeLlegada());
		Assert.assertEquals(horaDeLlegada, cliente.getHoraDeLlegada());
		
		//Se atiende al cliente
		Cliente atendido = null;
		try {
			atendido = actual.atenderCliente(cliente);
		} catch (NoHayClientesParaAtender excepcion) {
			excepcion.printStackTrace();
		}
		
		assertTrue(atendido.getEstaAtendido());
		
		//Despues de ser atendido
		Assert.assertEquals(fechaDeAtencion, cliente.getFechaDeAtencion());
		Assert.assertEquals(horaDeAtencion, cliente.getHoraDeAtencion());
		
	}
	
	@Test
	public void queSePuedaAgregarUnClienteAlServicioMecanico() {
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234);
		
		assertTrue(actual.agregarClientes(cliente));
	}
	
	@Test
	public void queSePuedaAtenderAUnCliente() {
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234, false);
		
		actual.agregarClientes(cliente);
		
		Cliente clienteEsperado = cliente;
		Cliente clienteObtenido = null;
		try {
			clienteObtenido = actual.atenderCliente(cliente);
		} catch (NoHayClientesParaAtender excepcion) {
			excepcion.printStackTrace();
		}
		
		assertTrue(cliente.getEstaAtendido()); //Se atendió al cliente
		Assert.assertEquals(clienteEsperado, clienteObtenido);
	}

	@Test (expected = NoHayClientesParaAtender.class)
	public void queMeDeExcepcionSiNoHayClientesParaAtender() throws NoHayClientesParaAtender {
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234, true);
		
		actual.agregarClientes(cliente);
		
		Cliente clienteEsperado = cliente;
		Cliente clienteObtenido = actual.atenderCliente(cliente);
		
		Assert.assertEquals(clienteEsperado, clienteObtenido);
	}
	
	@Test
	public void obtenerElTiempoMedioDeEsperaDeLosClientesNoAtendidos() {
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234, true, 50.0);
		Cliente cliente1 = new Cliente("Daniel", 12345, false, 40.0); //Solo me agarran los false que no estan atendidos
		Cliente cliente2 = new Cliente("Gianella", 12346, true, 30.0);
		Cliente cliente3 = new Cliente("Juan", 12347, true, 90.0);
		Cliente cliente4 = new Cliente("Eduardo", 12348, false, 40.0); //Solo me agarran los false que no estan atendidos
		Cliente cliente5 = new Cliente("Noemi", 12349, true, 20.0);
		Cliente cliente6 = new Cliente("Roman", 123410, false, 10.0); //Solo me agarran los false que no estan atendidos
		
		actual.agregarClientes(cliente);
		actual.agregarClientes(cliente1);
		actual.agregarClientes(cliente2);
		actual.agregarClientes(cliente3);
		actual.agregarClientes(cliente4);
		actual.agregarClientes(cliente5);
		actual.agregarClientes(cliente6);
		
		Double valorEsperado = 12.85;
		Double valorObtenido = actual.obtenerElTiempoMedioDeEsperaDeLosClientesNoAtendidos();
		
		Assert.assertEquals(valorEsperado, valorObtenido, 0.01);
	}
	
	@Test
	public void obtenerElTiempoMedioDeEsperaDeLosClientesYaAtendidos() {
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234, true, 50.0); //Solo me agarran los true que estan atendidos
		Cliente cliente1 = new Cliente("Daniel", 12345, false, 40.0);
		Cliente cliente2 = new Cliente("Gianella", 123456, true, 30.0); //Solo me agarran los true que estan atendidos
		Cliente cliente3 = new Cliente("Juan", 1234567, true, 90.0); //Solo me agarran los true que estan atendidos
		Cliente cliente4 = new Cliente("Eduardo", 12345678, false, 40.0);
		Cliente cliente5 = new Cliente("Noemi", 123456789, true, 20.0); //Solo me agarran los true que estan atendidos
		Cliente cliente6 = new Cliente("Roman", 1234567891, false, 10.0);
		
		actual.agregarClientes(cliente);
		actual.agregarClientes(cliente1);
		actual.agregarClientes(cliente2);
		actual.agregarClientes(cliente3);
		actual.agregarClientes(cliente4);
		actual.agregarClientes(cliente5);
		actual.agregarClientes(cliente6);
		
		Double valorEsperado = 27.14;
		Double valorObtenido = actual.obtenerElTiempoMedioDeEsperaDeLosClientesYaAtendidos();
		
		Assert.assertEquals(valorEsperado, valorObtenido, 0.01);
	}
	
	@Test
	public void queSeSepanCuantosClientesEstanEnEspera() {
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234, false);
		Cliente cliente1 = new Cliente("Daniel", 12345, false);
		Cliente cliente2 = new Cliente("Gianella", 12346, false);
		Cliente cliente3 = new Cliente("Juan", 12347, false);
		Cliente cliente4 = new Cliente("Eduardo", 12348, false);
		Cliente cliente5 = new Cliente("Noemi", 12349, true);
		Cliente cliente6 = new Cliente("Roman", 123410, true);
		
		actual.agregarClientes(cliente);
		actual.agregarClientes(cliente1);
		actual.agregarClientes(cliente2);
		actual.agregarClientes(cliente3);
		actual.agregarClientes(cliente4);
		actual.agregarClientes(cliente5);
		actual.agregarClientes(cliente6);
		
		Integer clientesEnLaEsperaEsperados = 5;
		Integer clientesEnLaEsperaObtenidos = actual.obtenerClientesEnLaEspera().size();
		
		Assert.assertEquals(clientesEnLaEsperaEsperados, clientesEnLaEsperaObtenidos);
	}
	
	@Test
	public void queSeSepanCuantosClientesEstanAtendidos() {
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234, true);
		Cliente cliente1 = new Cliente("Daniel", 12345, false);
		Cliente cliente2 = new Cliente("Gianella", 12346, true);
		Cliente cliente3 = new Cliente("Juan", 12347, true);
		Cliente cliente4 = new Cliente("Eduardo", 12348, false);
		Cliente cliente5 = new Cliente("Noemi", 12349, true);
		Cliente cliente6 = new Cliente("Roman", 123410, false);
		
		actual.agregarClientes(cliente);
		actual.agregarClientes(cliente1);
		actual.agregarClientes(cliente2);
		actual.agregarClientes(cliente3);
		actual.agregarClientes(cliente4);
		actual.agregarClientes(cliente5);
		actual.agregarClientes(cliente6);
		
		Integer clientesEnLaEsperaEsperados = 4;
		Integer clientesEnLaEsperaObtenidos = actual.obtenerClientesAtendidos().size();
		
		Assert.assertEquals(clientesEnLaEsperaEsperados, clientesEnLaEsperaObtenidos);
	}
	
	@Test
	public void queNoPuedaHaberPersonasDuplicadasPorCelular() {
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234, true);
		Cliente cliente1 = new Cliente("Joaquin", 1234, false);
		Cliente cliente2 = new Cliente("Gianella", 12345, true);
		
		actual.agregarClientes(cliente);
		actual.agregarClientes(cliente1);
		actual.agregarClientes(cliente2);
		
		Integer clientesEnLaEsperaEsperados = 2;
		Integer clientesEnLaEsperaObtenidos = actual.obtenerClientes();
		
		Assert.assertEquals(clientesEnLaEsperaEsperados, clientesEnLaEsperaObtenidos);
	}
	
	@Test
	public void queSeOrdenenLosClientesPorCelular() {
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234);
		Cliente cliente1 = new Cliente("Emanuel", 1111);
		Cliente cliente2 = new Cliente("Gianella", 012);
		
		actual.agregarClientes(cliente);
		actual.agregarClientes(cliente1);
		actual.agregarClientes(cliente2);
		
		String primeroEsperado = cliente2.getNombre();
		String primeroObtenido = actual.ordenarPorCelular().first().getNombre();
		
		String ultimoEsperado = cliente.getNombre();
		String ultimoObtenido = actual.ordenarPorCelular().last().getNombre();
		
		Assert.assertEquals(primeroEsperado, primeroObtenido);
		Assert.assertEquals(ultimoEsperado, ultimoObtenido);
	}
	
	@Test
	public void queSePuedaRemoverLosClientesPorqueYaFueronAtendidos() {
		ServicioMecanico actual = new ServicioMecanico("El Mecanismo");
		Cliente cliente = new Cliente("Joaquin", 1234, true);
		Cliente cliente1 = new Cliente("Emanuel", 1111, false);
		Cliente cliente2 = new Cliente("Gianella", 012, true);
		
		actual.agregarClientes(cliente);
		actual.agregarClientes(cliente1);
		actual.agregarClientes(cliente2);
		
		actual.removerClientesAtendidos(cliente);
		actual.removerClientesAtendidos(cliente1); //No me lo remueve porque aun no esta atendido
		actual.removerClientesAtendidos(cliente2);
		
		Integer clientesNoAtendidosEsperado = 1;
		Integer clientesNoAtendidosObtenido = actual.obtenerClientes();
		
		Assert.assertEquals(clientesNoAtendidosEsperado, clientesNoAtendidosObtenido);
	}
}
