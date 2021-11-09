package models.vo;

import models.enums.Conocimiento;

import java.util.List;

public class PublicacionVO {
	private String titulo;
	private Double sueldo;
	private List<PostulanteVO> postulaciones;
	private List<Conocimiento> conocimientos;

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

    public List<Conocimiento> getConocimientos() {
		return conocimientos;
    }

	public void setConocimientos(List<Conocimiento> conocimientos){
		this.conocimientos = conocimientos;
	}

	/**
	 * Recibe un enum Conocimiento para agregar a la lista de requisitos
	 * @param conocimientos
	 */
	//public void setConocimientos(Conocimiento conocimientos) {
		//this.conocimientos.add(conocimientos);
	//}
}
