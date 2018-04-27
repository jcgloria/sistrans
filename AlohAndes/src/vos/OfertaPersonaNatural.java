package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class OfertaPersonaNatural {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="precio_mensual")
	private Long precioMensual;
	
	@JsonProperty(value="precio_semestre")
	private Long precioSemestre;
	
	@JsonProperty(value="personaNatural")
	private Long personaNatural;

	public OfertaPersonaNatural(@JsonProperty(value="id")Long id, @JsonProperty(value="precio_mensual")Long precioMensual, @JsonProperty(value="precio_semestre")Long precioSemestre, @JsonProperty(value="personaNatural")Long persona) {
		this.id = id;
		this.precioMensual = precioMensual;
		this.precioSemestre = precioSemestre;
		this.personaNatural = persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(Long precioMensual) {
		this.precioMensual = precioMensual;
	}

	public Long getPrecioSemestre() {
		return precioSemestre;
	}

	public void setPrecioSemestre(Long precioSemestre) {
		this.precioSemestre = precioSemestre;
	}

	public Long getPersona() {
		return personaNatural;
	}

	public void setPersona(Long persona) {
		this.personaNatural = persona;
	}

}
