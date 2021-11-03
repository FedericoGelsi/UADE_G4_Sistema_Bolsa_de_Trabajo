package controllers;

import models.vo.EmpresaVO;
import models.vo.OfertaLaboralVO;

import java.util.ArrayList;
import java.util.List;

public class EmpresaController {
    private List<EmpresaVO> empresas;

    public EmpresaController() {
        this.empresas = new ArrayList<>();
    }

    public Integer PublicarTrabajo() {
        return 1;
    }

    public void EditarTrabajo() {

    }

    public void EliminarTrabajo() {

    }

    public ArrayList<OfertaLaboralVO> ObtenerTrabajos() {
        return new ArrayList<>();
    }

    public void CrearInforme() {

    }
}
