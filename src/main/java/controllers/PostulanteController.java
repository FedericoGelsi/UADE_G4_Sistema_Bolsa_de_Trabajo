package controllers;

import models.Publicacion;
import models.vo.PostulanteVO;
import models.vo.PublicacionVO;

import java.util.ArrayList;
import java.util.List;

public class PostulanteController {
    private List<PostulanteVO> postulantes;
    private PublicacionController publicacionController;
    private CandidatoController candidatoController;

    public PostulanteController() {
        this.postulantes = new ArrayList<>();
    }

    public void agregarPostulante(Integer publicacionId) {
        PostulanteVO postulanteVO = new PostulanteVO();
        postulantes.add(postulanteVO);
        publicacionController.addPostulante(postulanteVO, publicacionId);
    }

    public void setPublicacionController(PublicacionController publicacionController) {
        this.publicacionController = publicacionController;
    }

    public List<PublicacionVO> getPublicaciones(){
        return publicacionController.getPublicaciones();
    }
}
