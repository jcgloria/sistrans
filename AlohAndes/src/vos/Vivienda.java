package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Vivienda Universitaria
 * @author juancg
 *
 */
public class Vivienda {

	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="ubicacion")
	private String ubicacion;

	public Vivienda(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre, @JsonProperty(value="ubicacion")String ubicacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}
