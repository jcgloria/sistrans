package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class OfertaEvento {
	
	@JsonProperty(value="id")
	private Long id;
	@JsonProperty(value="precio")
	private Long precio;
	@JsonProperty(value="num_habitaciones")
	private Long numHabitaciones;
	@JsonProperty(value="direccion")
	private String direccion;
	@JsonProperty(value="menaje")
	private String menaje;
	@JsonProperty(value="evento")
	private Long evento;
	
	public OfertaEvento(@JsonProperty(value="id")Long id, @JsonProperty(value="precio")Long precio, @JsonProperty(value="num_habitaciones")Long numHabitaciones, 
			@JsonProperty(value="direccion")String direccion, @JsonProperty(value="menaje")String menaje, @JsonProperty(value="evento")Long evento) {
		super();
		this.id = id;
		this.precio = precio;
		this.numHabitaciones = numHabitaciones;
		this.direccion = direccion;
		this.menaje = menaje;
		this.evento = evento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public Long getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(Long numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMenaje() {
		return menaje;
	}

	public void setMenaje(String menaje) {
		this.menaje = menaje;
	}

	public Long getEvento() {
		return evento;
	}

	public void setEvento(Long evento) {
		this.evento = evento;
	}

}
