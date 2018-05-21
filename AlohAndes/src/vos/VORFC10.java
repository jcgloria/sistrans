package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VORFC10 {
	
	@JsonProperty(value="id")
	private Long id;
	@JsonProperty(value="inicio")
	private String inicio;
	@JsonProperty(value="fin")
	private String fin;
	
	public VORFC10(@JsonProperty(value="id") Long id, @JsonProperty(value="inicio") String inicio, @JsonProperty(value="fin") String fin ) {
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}
}
