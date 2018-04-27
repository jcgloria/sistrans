package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class OfertaVivienda {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="costo_noche")
	private Long costoNoche;
	
	@JsonProperty(value="costo_mensual")
	private Long costoMensual;
	
	@JsonProperty(value="costo_semestre")
	private Long costoSemestre;
	
	@JsonProperty(value="menaje")
	private String menaje;
	
	@JsonProperty(value="capacidad")
	private Long capacidad;
	
	@JsonProperty(value="vivienda")
	private Long vivienda;
	
	public OfertaVivienda(@JsonProperty(value="id")Long id, @JsonProperty(value="costo_noche")Long costoNoche, @JsonProperty(value="costo_mensual")
	Long costoMensual, @JsonProperty(value="costo_semestre")Long costoSemestre, @JsonProperty(value="menaje")String menaje,
	@JsonProperty(value="capacidad")Long capacidad, @JsonProperty(value="vivienda")Long vivienda) {
		this.id = id;
		this.costoNoche = costoNoche;
		this.costoMensual = costoMensual;
		this.costoSemestre = costoSemestre;
		this.menaje = menaje;
		this.capacidad = capacidad;
		this.vivienda = vivienda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCostoNoche() {
		return costoNoche;
	}

	public void setCostoNoche(Long costoNoche) {
		this.costoNoche = costoNoche;
	}

	public Long getCostoMensual() {
		return costoMensual;
	}

	public void setCostoMensual(Long costoMensual) {
		this.costoMensual = costoMensual;
	}

	public Long getCostoSemestre() {
		return costoSemestre;
	}

	public void setCostoSemestre(Long costoSemestre) {
		this.costoSemestre = costoSemestre;
	}

	public String getMenaje() {
		return menaje;
	}

	public void setMenaje(String menaje) {
		this.menaje = menaje;
	}

	public Long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Long capacidad) {
		this.capacidad = capacidad;
	}

	public Long getVivienda() {
		return vivienda;
	}

	public void setVivienda(Long vivienda) {
		this.vivienda = vivienda;
	}

}
