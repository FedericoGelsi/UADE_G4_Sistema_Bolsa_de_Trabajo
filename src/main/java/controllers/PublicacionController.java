package controllers;

import models.Publicacion;
import models.vo.PostulanteVO;
import models.vo.PublicacionVO;

import java.util.List;

public class PublicacionController {
    private List<PublicacionVO> publicaciones;
    private PostulanteController postulanteController;


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
}
