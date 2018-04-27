package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Servicio {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="tipo_oferta")
	private String tipoOferta;
	
	@JsonProperty(value="id_oferta")
	private Long idOferta;
	
	@JsonProperty(value="nom_servicio")
	private String nomServicio;
	
	public Servicio(@JsonProperty(value="id") Long id ,@JsonProperty(value="tipo_oferta")String tipoOferta, 
			@JsonProperty(value="id_oferta") Long idOferta, @JsonProperty(value="nom_servicio") String nomServicio) {
		this.id = id;
		this.tipoOferta = tipoOferta;
		this.idOferta = idOferta;
		this.nomServicio = nomServicio;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoOferta() {
		return tipoOferta;
	}
	public void setTipoOferta(String tipoOferta) {
		this.tipoOferta = tipoOferta;
	}
	public Long getIdOferta() {
		return idOferta;
	}
	public void setIdOferta(Long idOferta) {
		this.idOferta = idOferta;
	}
	public String getNomServicio() {
		return nomServicio;
	}
	public void setNomServicio(String nomServicio) {
		this.nomServicio = nomServicio;
	}

}
