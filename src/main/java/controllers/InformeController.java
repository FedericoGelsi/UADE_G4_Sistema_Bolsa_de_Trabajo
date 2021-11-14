package controllers;

import models.Publicacion;
import models.enums.Requisito;
import models.vo.PublicacionVO;
import models.vo.ReporteVO;

import java.util.List;

public class InformeController {
    private Publicacion publicacion;
    public InformeController() {
    }
    public ReporteVO getInformeOfertaMasAccesible(){

        String title = "";
        int menosRequisitos = 0, menosTareas = 0;
        List<Requisito> requisitosList;
        String modalidad,tipo,descripcion;
        ReporteVO res = new ReporteVO();
        List<PublicacionVO> publicaciones = publicacion.getPublicaciones();
        for(PublicacionVO oferta : publicaciones) {
            requisitosList = oferta.getOfertaLaboral.getRequisitos();
            modalidad = oferta.getOfertaLaboral.getModalidad();
            tipo = oferta.getOfertaLaboral.getTipo();
            descripcion = oferta.getOfertaLaboral.getDescripcion();
            if (modalidad == "PART_TIME" && tipo == "REMOTO"){
                if (descripcion.length() < menosTareas) {
                    if (requisitosList.size() < menosRequisitos) {
                        menosRequisitos = requisitosList.size();
                        menosTareas = descripcion.length();
                        title = oferta.getTitulo();
                    }
                }
            }
        }
        res.setTitulo_oferta(title);
        return res;
    }

}
