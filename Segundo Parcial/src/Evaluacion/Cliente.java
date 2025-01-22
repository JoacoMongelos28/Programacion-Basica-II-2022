package Evaluacion;

public class Cliente extends Persona {
	
	private Integer fechaDeLlegada;
	private Double horaDeLlegada;
	private Integer fechaDeAtencion;
	private Double horaDeAtencion;
	private Boolean estaAtendido;
	private Double tiempoDeEspera;

	public Cliente(String nombre, Integer numeroDeMovil) {
		super(nombre, numeroDeMovil);
	}
	
	public Cliente(String nombre, Integer numeroDeMovil, Integer fechaDeLlegada, Double horaDeLlegada, Integer fechaDeAtencion, Double horaDeAtencion) {
		super(nombre, numeroDeMovil);
		this.fechaDeLlegada = fechaDeLlegada;
		this.horaDeLlegada= horaDeLlegada;
		this.fechaDeAtencion = fechaDeAtencion;
		this.horaDeAtencion = horaDeAtencion;
		this.estaAtendido = false;
	}
	
	public Cliente(String nombre, Integer numeroDeMovil, Boolean estaAtendido) {
		super(nombre, numeroDeMovil);
		this.estaAtendido = estaAtendido;
	}
	
	public Cliente(String nombre, Integer numeroDeMovil, Boolean estaAtendido, Double tiempoDeEspera) {
		super(nombre, numeroDeMovil);
		this.estaAtendido = estaAtendido;
		this.tiempoDeEspera = tiempoDeEspera;
	}

	public Boolean getEstaAtendido() {
		return estaAtendido;
	}

	public void setEstaAtendido(Boolean estaAtendido) {
		this.estaAtendido = estaAtendido;
	}

	public Double getTiempoDeEspera() {
		return tiempoDeEspera;
	}

	public Integer getFechaDeLlegada() {
		return fechaDeLlegada;
	}

	public Double getHoraDeLlegada() {
		return horaDeLlegada;
	}

	public Integer getFechaDeAtencion() {
		return fechaDeAtencion;
	}

	public Double getHoraDeAtencion() {
		return horaDeAtencion;
	}

}
