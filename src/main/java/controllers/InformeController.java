package controllers;

import models.Publicacion;
import models.enums.Requisito;
import models.vo.InformeVO;
import models.vo.OfertaLaboralVO;
import models.vo.PublicacionVO;
import models.vo.ReporteVO;

import java.util.List;

public class InformeController {
    private Publicacion publicacion;
    public InformeController() {
    }
    public InformeVO getInformeOfertaMasAccesible(){

        String title = "";
        int menosRequisitos = 0;
        List<Requisito> requisitosList;
        ReporteVO res = new ReporteVO();
        List<PublicacionVO> publicaciones = publicacion.getPublicaciones();
        for(PublicacionVO ol : publicaciones) {
            requisitosList = ol.getOfertaLaboral.getRequisitos();
            if (requisitosList.size() < menosRequisitos) {
                menosRequisitos = requisitosList.size();
                title = ol.getTitulo();
            }
        }
        res.setTitulo_oferta(title);
        return res;
    }

}
