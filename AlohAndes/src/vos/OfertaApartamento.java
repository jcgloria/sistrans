package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class OfertaApartamento {

	@JsonProperty(value="id")
	private Long id;
	@JsonProperty(value="costo")
	private Long costo;
	@JsonProperty(value="servicios")
	private String servicios;
	@JsonProperty(value="internet_tv")
	private String internetTv;
	@JsonProperty(value="administracion")
	private String administracion;
	@JsonProperty(value="persona")
	private Long persona;

	public OfertaApartamento(@JsonProperty(value="id")Long id, @JsonProperty(value="costo")Long costo, @JsonProperty(value="servicios")String servicios, 
			@JsonProperty(value="internet_tv")String internetTv, @JsonProperty(value="administracion")String administracion,
			@JsonProperty(value="persona")Long persona) {
		this.id = id;
		this.costo = costo;
		this.servicios = servicios;
		this.internetTv = internetTv;
		this.administracion = administracion;
		this.persona = persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCosto() {
		return costo;
	}

	public void setCosto(Long costo) {
		this.costo = costo;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	public String getInternetTv() {
		return internetTv;
	}

	public void setInternetTv(String internetTv) {
		this.internetTv = internetTv;
	}

	public String getAdministracion() {
		return administracion;
	}

	public void setAdministracion(String administracion) {
		this.administracion = administracion;
	}

	public Long getPersona() {
		return persona;
	}

	public void setPersona(Long persona) {
		this.persona = persona;
	}

}
