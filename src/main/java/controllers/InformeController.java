package controllers;

import models.vo.InformeVO;
import models.vo.OfertaLaboralVO;

import java.util.List;

public class InformeController {
    private List<OfertaLaboralVO> ofertasLaboralesVO;

    public InformeController() {
    }

    public List<OfertaLaboralVO> getOfertasLaboralesVO() {
        return ofertasLaboralesVO;
    }

    public void setOfertasLaboralesVO(List<OfertaLaboralVO> ofertasLaboralesVO) {
        this.ofertasLaboralesVO = ofertasLaboralesVO;
    }

    public InformeVO getInformeOfertaMasAccesible(){

        return null;
    }
}
