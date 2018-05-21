package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class VORFC13 {

	@JsonProperty(value="ID")
	private Long id;
	
	@JsonProperty(value="NOMBRE")
	private String nombre;
	
	@JsonProperty(value="CORREO")
	private String correo;
	
	@JsonProperty(value="AFILIACION")
	private String afiliacion;
	
	@JsonProperty(value="COSTO_CALCULADO")
	private Long costo_calculado;
	
	public VORFC13(@JsonProperty(value="ID")Long id, @JsonProperty(value="NOMBRE")String nombre, @JsonProperty(value="CORREO")String correo, @JsonProperty(value="AFILIACION")String afiliacion,@JsonProperty(value="COSTO_CALCULADO")Long costo_calculado) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.afiliacion = afiliacion;
		this.costo_calculado = costo_calculado;
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

	public Long getCosto_calculado() {
		return costo_calculado;
	}

	public void setCosto_calculado(Long costo_calculado) {
		this.costo_calculado = costo_calculado;
	}

}
