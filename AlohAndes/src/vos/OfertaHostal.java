package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class OfertaHostal {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="precio")
	private Long precio;
	
	@JsonProperty(value="hostal")
	private Long hostal;
	
	@JsonProperty(value="estado")
	private String estado;

	public OfertaHostal(@JsonProperty(value="id")Long id, @JsonProperty(value="precio")Long precio, @JsonProperty(value="hostal")Long hostal, @JsonProperty(value="estado") String estado) {
		this.id = id;
		this.precio = precio;
		this.hostal = hostal;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public Long getHostal() {
		return hostal;
	}

	public void setHostal(Long hostal) {
		this.hostal = hostal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
