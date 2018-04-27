package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Gustan {
	
	@JsonProperty(value="persona")
	private Long persona;
	@JsonProperty(value="servicio")
	private String servicio;
	
	public Gustan(@JsonProperty(value="persona") Long persona, @JsonProperty(value="servicio") String servicio) {
		this.persona = persona;
		this.servicio = servicio;
	}

	public Long getPersona() {
		return persona;
	}

	public void setPersona(Long persona) {
		this.persona = persona;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

}
