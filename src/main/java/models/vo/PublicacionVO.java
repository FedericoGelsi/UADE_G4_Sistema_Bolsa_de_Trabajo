package models.vo;

import java.util.List;

public class PublicacionVO {
	private String titulo;
	private Double sueldo;
	private List<PostulanteVO> postulaciones;

	// TODO: Delete this class. OfertaLaboralVO will replace it.

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
	public List<PostulanteVO> getPostulaciones() {
		return postulaciones;
	}
	public void setPostulaciones(List<PostulanteVO> postulaciones) {
		this.postulaciones = postulaciones;
	}
}
