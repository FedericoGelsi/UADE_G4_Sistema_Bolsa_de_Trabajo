package models.vo;

import models.enums.Categoria;
import models.enums.Conocimiento;
import models.enums.Idioma;

import java.util.Date;
import java.util.List;

public class CandidatoVO {
	private String nombre;
	private String apellido;
	private Integer DNI;
	private Date fechaNacimiento;
	private String nacionalidad;
	private List<Conocimiento> conocientos;
	private List<Idioma> idiomas;
	private List<Categoria> categorias;

	public CandidatoVO() {

	}

	public CandidatoVO(String nombre, String apellido, Integer DNI) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Integer getDNI() {
		return DNI;
	}
	public void setDNI(Integer dNI) {
		DNI = dNI;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<Conocimiento> getConocientos() {
		return conocientos;
	}

	public void setConocientos(List<Conocimiento> conocientos) {
		this.conocientos = conocientos;
	}

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
