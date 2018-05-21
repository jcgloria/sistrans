package vos;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Reserva {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="id_oferta")
	private Long idOferta;
	
	@JsonProperty(value="fecha_reserva")
	private Date fechaReserva;
	
	@JsonProperty(value="fecha_inicio")
	private Date fechaInicio;
	
	@JsonProperty(value="fecha_fin")
	private Date fechaFin;
	
	@JsonProperty(value="fecha_oportuna")
	private Date fechaOportuna;
	
	@JsonProperty(value="costo_calculado")
	private Long costoCalculado;
	
	@JsonProperty(value="estado")
	private String estado;
	
	@JsonProperty(value="persona")
	private Long persona;

	public Reserva(@JsonProperty(value="id") Long id, @JsonProperty(value="id_oferta") Long idOferta, @JsonProperty(value="fecha_reserva") Date fechaReserva, @JsonProperty(value="fecha_inicio") Date fechaInicio, @JsonProperty(value="fecha_fin") Date fechaFin,
			@JsonProperty(value="fecha_cancelacion") Date fechaOportuna, @JsonProperty(value="costo_calculado") Long costoCalculado, @JsonProperty(value="estado") String estado, @JsonProperty(value="persona") Long persona) {
		this.id = id;
		this.idOferta = idOferta;
		this.fechaReserva = fechaReserva;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaOportuna = fechaOportuna;
		this.costoCalculado = costoCalculado;
		this.estado = estado;
		this.persona = persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Long idOferta) {
		this.idOferta = idOferta;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
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

	public Date getFechaOportuna() {
		return fechaOportuna;
	}

	public void setFechaOportuna(Date fechaOportuna) {
		this.fechaOportuna = fechaOportuna;
	}

	public Long getCostoCalculado() {
		return costoCalculado;
	}

	public void setCostoCalculado(Long costoCalculado) {
		this.costoCalculado = costoCalculado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getPersona() {
		return persona;
	}

	public void setPersona(Long persona) {
		this.persona = persona;
	}

}
