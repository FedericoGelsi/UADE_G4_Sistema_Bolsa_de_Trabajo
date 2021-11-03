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

    public void EditarOfertaLaboral(int idOferta) {

    }

    public void EliminarOfertaLaboral(int idOferta) {

    }

    public ArrayList<OfertaLaboralVO> ObtenerOfertasLaborales(int idEmpresa) {
        return new ArrayList<>();
    }

    public Integer AgregarPostulanteAOferta(PostulanteVO postulanteVO, int idOferta) {
        return 1;
    }
}
