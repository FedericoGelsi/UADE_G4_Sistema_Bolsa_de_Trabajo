package controllers;

import models.vo.PostulanteVO;

import java.util.ArrayList;
import java.util.List;

public class PostulanteController {
    private List<PostulanteVO> postulantes;
    private OfertaController ofertaController;

    public PostulanteController() {
        this.postulantes = new ArrayList<>();
    }

    public Integer postularCandidato(PostulanteVO postulanteVO, Integer ofertaId){
        //TODO: Implement
        ofertaController.AgregarPostulanteAOferta(postulanteVO, ofertaId);
        return null;
    }

    public void agregarPostulante(PostulanteVO postulanteVO) {
        postulantes.add(postulanteVO);
    }

    public void setOfertaController(OfertaController ofertaController) {
        this.ofertaController = ofertaController;
    }
}
