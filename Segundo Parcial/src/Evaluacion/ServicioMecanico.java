package Evaluacion;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ServicioMecanico {

	private String nombre;
	private Set<Cliente> clientesActuales;

	public ServicioMecanico(String nombre) {
		this.nombre = nombre;
		this.clientesActuales = new HashSet<>();
	}

	public Boolean agregarClientes(Cliente cliente) {
		return this.clientesActuales.add(cliente);
	}
	
	public Integer obtenerClientes() {
		return this.clientesActuales.size();
	}

	public Cliente atenderCliente(Cliente clienteAtendido) throws NoHayClientesParaAtender {
		for (Cliente clientes : clientesActuales) {
			if (!clientes.getEstaAtendido()) {
				clientes.setEstaAtendido(true);
				return clientes;
			}
		}
		throw new NoHayClientesParaAtender();
	}

	public HashSet<Cliente> obtenerClientesEnLaEspera() {
		HashSet<Cliente> clientesEnEspera = new HashSet<>();

		for (Cliente clientes : this.clientesActuales) {
			if (!clientes.getEstaAtendido()) {
				clientesEnEspera.add(clientes);
			}
		}
		return clientesEnEspera;
	}

	public HashSet<Cliente> obtenerClientesAtendidos() {
		HashSet<Cliente> clientesAtendidos = new HashSet<>();

		for (Cliente clientes : this.clientesActuales) {
			if (clientes.getEstaAtendido()) {
				clientesAtendidos.add(clientes);
			}
		}
		return clientesAtendidos;
	}

	public Double obtenerElTiempoMedioDeEsperaDeLosClientesYaAtendidos() {
		Double sumaDeLosTiempos = 0.0;
		Double porcentajeDeTiempoDeEspera = 0.0;
		for (Cliente clientes : clientesActuales) {
			if (clientes.getEstaAtendido()) {
				sumaDeLosTiempos += clientes.getTiempoDeEspera();
			}
		}
		porcentajeDeTiempoDeEspera = (sumaDeLosTiempos / this.clientesActuales.size());
		return porcentajeDeTiempoDeEspera;
	}

	public Double obtenerElTiempoMedioDeEsperaDeLosClientesNoAtendidos() {
		Double sumaDeLosTiempos = 0.0;
		Double porcentajeDeTiempoDeEspera = 0.0;
		for (Cliente clientes : clientesActuales) {
			if (!clientes.getEstaAtendido()) {
				sumaDeLosTiempos += clientes.getTiempoDeEspera();
			}
		}
		porcentajeDeTiempoDeEspera = (sumaDeLosTiempos / this.clientesActuales.size());
		return porcentajeDeTiempoDeEspera;
	}

	public TreeSet<Persona> ordenarPorNombre() {
		TreeSet<Persona> clientesOrdenadosPorNombre = new TreeSet<>();
		clientesOrdenadosPorNombre.addAll(clientesActuales);
		return clientesOrdenadosPorNombre;
	}

	public TreeSet<Cliente> ordenarPorCelular() {
		TreeSet<Cliente> clientesOrdenadosPorNombre = new TreeSet<>(new OrdenarPorNumeroDeCelular());
		clientesOrdenadosPorNombre.addAll(clientesActuales);
		return clientesOrdenadosPorNombre;
	}

	public void removerClientesAtendidos(Cliente cliente) {
		if (cliente.getEstaAtendido()) {
			this.clientesActuales.remove(cliente);
		}
	}

	public String getNombre() {
		return nombre;
	}
}
