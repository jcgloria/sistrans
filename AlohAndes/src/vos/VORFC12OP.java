package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VORFC12OP {
	
	@JsonProperty(value="SEMANA")
	private Long semana;
	
	@JsonProperty(value="DEMANDA")
	private Long demanda;
	
	@JsonProperty(value="ID_OPERADOR")
	private Long id_operador;

	public VORFC12OP(@JsonProperty(value="SEMANA")Long semana, @JsonProperty(value="DEMANDA")Long demanda, @JsonProperty(value="ID_OPERADOR")Long id_operador) {
		this.semana = semana;
		this.demanda = demanda;
		this.id_operador = id_operador;
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
		return id_operador;
	}

	public void setId_oferta(Long id_operador) {
		this.id_operador = id_operador;
	}
	

}
