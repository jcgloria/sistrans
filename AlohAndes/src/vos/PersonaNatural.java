package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class PersonaNatural {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="costo_servicios")
	private Long costoServicios;
	
	@JsonProperty(value="persona")
	private Long persona;

	public PersonaNatural(Long id, Long costoServicios, Long persona) {
		this.id = id;
		this.costoServicios = costoServicios;
		this.persona = persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCostoServicios() {
		return costoServicios;
	}

	public void setCostoServicios(Long costoServicios) {
		this.costoServicios = costoServicios;
	}

	public Long getPersona() {
		return persona;
	}

	public void setPersona(Long persona) {
		this.persona = persona;
	}
	
}
