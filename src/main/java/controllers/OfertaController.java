package controllers;

import models.enums.Categoria;
import models.enums.Modalidad;
import models.enums.Requisito;
import models.enums.Tipo;
import models.vo.EmpresaVO;
import models.vo.OfertaLaboralVO;
import models.vo.PostulanteVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OfertaController {
    private List<OfertaLaboralVO> ofertasLaborales;
    private EmpresaController empresaController;
    private Integer idCounter;

    public OfertaController() {
        this.ofertasLaborales = new ArrayList<>();
        this.idCounter = 0;
    }

    public Integer PublicarOfertaLaboral(EmpresaVO empresa, String titulo, String descripcion, Modalidad modalidad,
                                         Tipo tipo, String lugar, Double sueldo,
                                         List<Requisito> requisitos, List<Categoria> categorias) {
        OfertaLaboralVO ofertaLaboralVO = new OfertaLaboralVO(
                empresa.getEmpresaId(),
                titulo,
                descripcion,
                modalidad,
                tipo,
                lugar,
                sueldo,
                requisitos,
                categorias);
        ofertasLaborales.add(ofertaLaboralVO);
        return idCounter++;
    }

    public void EditarOfertaLaboral(Integer ofertaId, EmpresaVO empresa, String titulo, String descripcion,
                                    Modalidad modalidad, Tipo tipo, String lugar, Double sueldo,
                                    List<Requisito> requisitos, List<Categoria> categorias) {
        OfertaLaboralVO ofertaLaboralExistente =
                ofertasLaborales.stream().filter(oferta -> ofertaId.equals(oferta.getOfertaId())).findAny().orElse(null);
        Integer index = ofertasLaborales.indexOf(ofertaLaboralExistente);
        OfertaLaboralVO ofertaEditada = new OfertaLaboralVO(
                empresa.getEmpresaId(),
                titulo,
                descripcion,
                modalidad,
                tipo,
                lugar,
                sueldo,
                requisitos,
                categorias);
        ofertaEditada.setPostulantes(ofertaLaboralExistente.getPostulantes() );
        ofertasLaborales.set(index, ofertaEditada);
    }

    public void EliminarOfertaLaboral(Integer ofertaId) {
        OfertaLaboralVO ofertaLaboralExistente =
                ofertasLaborales.stream().filter(oferta -> ofertaId.equals(oferta.getOfertaId())).findAny().orElse(null);
        ofertasLaborales.remove(ofertaLaboralExistente);
    }

    public ArrayList<OfertaLaboralVO> ObtenerOfertasLaborales(Integer idEmpresa) {
        ArrayList<OfertaLaboralVO> ofertas = new ArrayList<>();
        ofertasLaborales.forEach(oferta -> {
                if(oferta.getEmpresaId().equals(idEmpresa)) {
                    ofertas.add(oferta);
                }});
        return ofertas;
    }

    public void AgregarPostulanteAOferta(PostulanteVO postulanteVO, Integer ofertaId) {
        OfertaLaboralVO ofertaLaboralExistente =
                ofertasLaborales.stream().filter(oferta -> ofertaId.equals(oferta.getOfertaId())).findAny().orElse(null);
        Integer index = ofertasLaborales.indexOf(ofertaLaboralExistente);
        ofertasLaborales.get(index).agregarPostulante(postulanteVO);
    }

    public void setEmpresaController(EmpresaController empresaController) {
        this.empresaController = empresaController;
    }
}
