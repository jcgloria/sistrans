package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Hotel {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="direccion")
	private String direccion;
	

	public Hotel(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre, @JsonProperty(value="direccion")String direccion) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
