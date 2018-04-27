package vos;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class ReservaColectiva {
	
	@JsonProperty(value="cantidad")
	private Long cantidad;
	@JsonProperty(value="tipoHabitacion")
	private String tipoHabitacion;
	@JsonProperty(value="fechaInicio")
	private Date fechaInicio;
	@JsonProperty(value="fechaFin")
	private Date fechaFin;
	@JsonProperty(value="persona")
	private Long persona;
	@JsonProperty(value="servicios")
	private String servicios; //los servicios van separados por coma

	
	
	
	public ReservaColectiva(@JsonProperty(value="cantidad") Long cantidad,@JsonProperty(value="tipoHabitacion") String tipoHabitacion, @JsonProperty(value="fechaInicio")Date fechaInicio,@JsonProperty(value="fechaFin")Date fechaFin, @JsonProperty(value="persona") Long persona, @JsonProperty(value="servicios") String servicios) {
		this.cantidad = cantidad;
		this.tipoHabitacion = tipoHabitacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.persona = persona;
		this.servicios = servicios;
	}


	public Long getCantidad() {
		return cantidad;
	}


	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public Long getPersona() {
		return persona;
	}


	public void setPersona(Long persona) {
		this.persona = persona;
	}


	public String getTipoHabitacion() {
		return tipoHabitacion;
	}


	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}


	public String getServicios() {
		return servicios;
	}


	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

}
