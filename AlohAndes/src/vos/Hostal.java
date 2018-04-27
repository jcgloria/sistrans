package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Hostal {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="direccion")
	private String direccion;
	
	@JsonProperty(value="hora_apertura")
	private String horaApertura;
	
	@JsonProperty(value="hora_cierre")
	private String horaCierre;

	public Hostal(@JsonProperty(value="id")Long id, @JsonProperty(value="nombre")String nombre, @JsonProperty(value="direccion")String direccion, @JsonProperty(value="hora_apertura") String horaApertura, @JsonProperty(value="hora_cierre")String horaCierre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
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

	public String getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(String horaApertura) {
		this.horaApertura = horaApertura;
	}

	public String getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(String horaCierre) {
		this.horaCierre = horaCierre;
	}

}
