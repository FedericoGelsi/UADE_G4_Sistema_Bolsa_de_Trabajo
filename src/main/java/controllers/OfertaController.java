package controllers;

import models.vo.OfertaLaboralVO;
import models.vo.PostulanteVO;

import java.util.ArrayList;
import java.util.List;

public class OfertaController {
    private List<OfertaLaboralVO> ofertasLaborales;

    public OfertaController() {
        this.ofertasLaborales = new ArrayList<>();
    }

    public Integer PublicarOfertaLaboral() {
        return 1;
    }

    public void EditarOfertaLaboral(Integer idOferta) {

    }

    public void EliminarOfertaLaboral(Integer idOferta) {

    }

    public ArrayList<OfertaLaboralVO> ObtenerOfertasLaborales(Integer idEmpresa) {
        return new ArrayList<>();
    }

    public Integer AgregarPostulanteAOferta(PostulanteVO postulanteVO, Integer idOferta) {
        return 1;
    }
}
