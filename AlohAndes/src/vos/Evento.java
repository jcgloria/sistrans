package vos;

import java.sql.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Evento {

	@JsonProperty(value="id")
	private Long id;

	@JsonProperty(value="nombre")
	private String nombre;

	@JsonProperty(value="fecha_inicio")
	private Date fechaInicio;

	@JsonProperty(value="fecha_final")
	private Date fechaFinal;

	public Evento(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre, @JsonProperty(value="fecha_inicio")Date fechaInicio, @JsonProperty(value="fecha_final")Date fechaFinal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

}
