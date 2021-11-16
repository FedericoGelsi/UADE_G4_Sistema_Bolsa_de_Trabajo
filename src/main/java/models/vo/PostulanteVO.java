package models.vo;

import exceptions.PostulanteException;

public class PostulanteVO {
	private Integer mes;
	private Integer anio;
	private CandidatoVO candidato;

	public PostulanteVO(Integer mes, Integer anio, CandidatoVO candidato) {
		this.mes = mes;
		this.anio = anio;
		this.candidato = candidato;
	}

	public PostulanteVO() {
	}

	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public CandidatoVO getCandidato() {
		return candidato;
	}
	public void setCandidato(CandidatoVO candidato) throws PostulanteException {
		if (candidato == null)
			throw new PostulanteException("Cantidato no puede estar vacío.");
		else
			this.candidato = candidato;
	}
}
