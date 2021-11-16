package models.vo;

import models.enums.EstadoPublicacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PublicacionVO {
	private OfertaLaboralVO ofertaLaboralVO;
	private List<PostulanteVO> postulaciones;
	private LocalDateTime vigenciaDesde;
	private LocalDateTime vigenciaHasta;
	private static final long semanasCerrada = 4;
	private final Integer publicacionId;
	private static final AtomicInteger count = new AtomicInteger(0);

	public PublicacionVO(OfertaLaboralVO ofertaLaboralVO,LocalDateTime vigenciaDesde, LocalDateTime vigenciaHasta) {
		this.vigenciaDesde = vigenciaDesde;
		this.vigenciaHasta = vigenciaHasta;
		this.postulaciones = new ArrayList<>();
		this.ofertaLaboralVO = ofertaLaboralVO;
		this.publicacionId = count.incrementAndGet();
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

	public EstadoPublicacion getEstadoOferta(){
		EstadoPublicacion estadoPublicacion;
		if (isVigente()){
			estadoPublicacion = EstadoPublicacion.ABIERTA;
		}else if (!isVigente() && LocalDateTime.now().isBefore(vigenciaHasta.plusWeeks(semanasCerrada))){
			estadoPublicacion = EstadoPublicacion.CERRADA;
		}else {
			estadoPublicacion = EstadoPublicacion.INACTIVA;
		}
		return estadoPublicacion;
	}

	public Integer getPublicacionId() {
		return publicacionId;
	}
}
