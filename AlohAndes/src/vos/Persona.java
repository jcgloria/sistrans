package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Persona {
	
	@JsonProperty(value="ID")
	private Long id;
	
	@JsonProperty(value="NOMBRE")
	private String nombre;
	
	@JsonProperty(value="CORREO")
	private String correo;
	
	@JsonProperty(value="AFILIACION")
	private String afiliacion;
	
	public Persona(@JsonProperty(value="ID")Long id, @JsonProperty(value="NOMBRE")String nombre, @JsonProperty(value="CORREO")String correo, @JsonProperty(value="AFILIACION")String afiliacion) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.afiliacion = afiliacion;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getAfiliacion() {
		return afiliacion;
	}
	public void setAfiliacion(String afiliacion) {
		this.afiliacion = afiliacion;
	}

}
