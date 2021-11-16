package controllers;

import models.vo.OfertaLaboralVO;
import models.vo.PostulanteVO;
import models.vo.PublicacionVO;

import java.util.List;

public class PublicacionController {
    private List<PublicacionVO> publicaciones;
    private PostulanteController postulanteController;
    private OfertaController ofertaController;


    public PublicacionController() {
    }

    public List<PublicacionVO> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<PublicacionVO> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public void addPostulante(PostulanteVO postulanteVO, Integer publicacionId){
        // TODO: Implement. Find publicacion with publicacionId.
    }

    public void setPostulanteController(PostulanteController postulanteController) {
        this.postulanteController = postulanteController;
    }

    public List<OfertaLaboralVO> getOfertasLaborales(Integer idEmpresa) {
        return ofertaController.ObtenerOfertasLaborales(idEmpresa);
    }
}
