package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VORFC12OF {
	
	@JsonProperty(value="SEMANA")
	private Long semana;
	
	@JsonProperty(value="DEMANDA")
	private Long demanda;
	
	@JsonProperty(value="ID_OFERTA")
	private Long id_oferta;

	public VORFC12OF(@JsonProperty(value="SEMANA")Long semana, @JsonProperty(value="DEMANDA")Long demanda, @JsonProperty(value="ID_OFERTA")Long id_oferta) {
		this.semana = semana;
		this.demanda = demanda;
		this.id_oferta = id_oferta;
	}

	public Long getSemana() {
		return semana;
	}

	public void setSemana(Long semana) {
		this.semana = semana;
	}

	public Long getDemanda() {
		return demanda;
	}

	public void setDemanda(Long demanda) {
		this.demanda = demanda;
	}

	public Long getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(Long id_oferta) {
		this.id_oferta = id_oferta;
	}
	

}
