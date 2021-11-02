package models.vo;

import java.util.List;

public class PublicacionVO {
	private String titulo;
	private Double sueldo;
	private List<models.vo.PostulacionVO> postulaciones;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	public List<models.vo.PostulacionVO> getPostulaciones() {
		return postulaciones;
	}
	public void setPostulaciones(List<models.vo.PostulacionVO> postulaciones) {
		this.postulaciones = postulaciones;
	}
}
