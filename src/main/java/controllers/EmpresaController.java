package controllers;

import models.enums.Categoria;
import models.enums.Requisito;
import models.vo.EmpresaVO;
import models.vo.OfertaLaboralVO;

import java.util.ArrayList;
import java.util.List;

public class EmpresaController {
    private List<EmpresaVO> empresas;
    private OfertaController ofertaController;

    public EmpresaController() {
        this.empresas = new ArrayList<>();
    }

    public Integer PublicarTrabajo(EmpresaVO empresa, String titulo, String descripcion, String modalidad, String tipo,
                                   String lugar, Double sueldo, List<Requisito> requisitos, List<Categoria> categorias) {
        return ofertaController.PublicarOfertaLaboral(empresa, titulo, descripcion, modalidad, tipo, lugar, sueldo,
                requisitos, categorias);
    }

    public void EditarTrabajo(Integer idOferta, EmpresaVO empresa, String titulo, String descripcion, String modalidad, String tipo,
                              String lugar, Double sueldo, List<Requisito> requisitos, List<Categoria> categorias) {
        ofertaController.EditarOfertaLaboral(idOferta, empresa, titulo, descripcion, modalidad, tipo, lugar,
                sueldo, requisitos, categorias);
    }

    public void EliminarTrabajo(Integer id) {
        ofertaController.EliminarOfertaLaboral(id);
    }

    public ArrayList<OfertaLaboralVO> ObtenerTrabajos(Integer empresaId) {
        return ofertaController.ObtenerOfertasLaborales(empresaId);
    }

    public void CrearInforme() {

    }

    public void setOfertaController(OfertaController ofertaController) {
        this.ofertaController = ofertaController;
    }
}
