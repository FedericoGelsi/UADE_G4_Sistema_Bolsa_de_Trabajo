package models.vo;

import models.enums.Categoria;
import models.enums.Conocimiento;
import models.enums.Idioma;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CandidatoVO {
	private String nombre;
	private String apellido;
	private Integer DNI;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private List<Conocimiento> conocientos;
	private List<Idioma> idiomas;
	private List<Categoria> categorias;
	private Integer userId;
	private static final AtomicInteger count = new AtomicInteger(0);

	public CandidatoVO() {
		this.userId = count.incrementAndGet();
	}

	public CandidatoVO(String nombre, String apellido, Integer DNI) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.userId = count.incrementAndGet();
	}

	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Integer getDNI() {
		return this.DNI;
	}
	public void setDNI(Integer dNI) {
		this.DNI = dNI;
	}

	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
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
