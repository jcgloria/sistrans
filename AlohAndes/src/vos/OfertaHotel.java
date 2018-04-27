package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class OfertaHotel {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="tipo_habitacion")
	private String tipoHabitacion;
	
	@JsonProperty(value="precio")
	private Long precio;
	
	@JsonProperty(value="hotel")
	private Long hotel;
	
	@JsonProperty(value="estado")
	private String estado;

	public OfertaHotel(@JsonProperty(value="id")Long id, @JsonProperty(value="tipo_habitacion")String tipoHabitacion, @JsonProperty(value="precio")Long precio, @JsonProperty(value="hotel")Long hotel, @JsonProperty(value="estado") String estado) {
		this.id = id;
		this.tipoHabitacion = tipoHabitacion;
		this.precio = precio;
		this.hotel = hotel;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public Long getHotel() {
		return hotel;
	}

	public void setHotel(Long hotel) {
		this.hotel = hotel;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
