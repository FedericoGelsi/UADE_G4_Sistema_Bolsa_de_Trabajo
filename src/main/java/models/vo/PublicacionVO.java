package models.vo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PublicacionVO {
	private OfertaLaboralVO ofertaLaboralVO;
	private List<PostulanteVO> postulaciones;
	private LocalDateTime vigenciaDesde;
	private LocalDateTime vigenciaHasta;

	public PublicacionVO(OfertaLaboralVO ofertaLaboralVO,LocalDateTime vigenciaDesde, LocalDateTime vigenciaHasta) {
		this.vigenciaDesde = vigenciaDesde;
		this.vigenciaHasta = vigenciaHasta;
		this.postulaciones = new ArrayList<>();
		this.ofertaLaboralVO = ofertaLaboralVO;
	}

	public OfertaLaboralVO getOfertaLaboralVO() {
		return ofertaLaboralVO;
	}

	public void setOfertaLaboralVO(OfertaLaboralVO ofertaLaboralVO) {
		this.ofertaLaboralVO = ofertaLaboralVO;
	}

	public List<PostulanteVO> getPostulaciones() {
		return postulaciones;
	}
	public void setPostulaciones(List<PostulanteVO> postulaciones) {
		this.postulaciones = postulaciones;
	}

	public LocalDateTime getVigenciaDesde() {
		return vigenciaDesde;
	}

	public void setVigenciaDesde(LocalDateTime vigenciaDesde) {
		this.vigenciaDesde = vigenciaDesde;
	}

	public LocalDateTime getVigenciaHasta() {
		return vigenciaHasta;
	}

	public void setVigenciaHasta(LocalDateTime vigenciaHasta) {
		this.vigenciaHasta = vigenciaHasta;
	}

	public boolean isVigente() {
		return LocalDateTime.now().isBefore(vigenciaHasta) && LocalDateTime.now().isAfter(vigenciaDesde);
	}
}
