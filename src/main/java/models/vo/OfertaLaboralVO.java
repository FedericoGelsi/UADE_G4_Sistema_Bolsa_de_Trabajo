package models.vo;

import models.enums.Categoria;
import models.enums.Requisito;

import java.util.List;

public class OfertaLaboralVO {
    private Integer empresaId;
    private Integer ofertaId;
    private String titulo;
    private String descripcion;
    private String modalidad;
    private String tipo;
    private String lugar;
    private Double sueldo;
    private List<Requisito> requisitos;
    private List<Categoria> categorias;
    private List<PostulanteVO> postulantes;

    public OfertaLaboralVO(Integer empresaId, Integer ofertaId,  String titulo, String descripcion, String modalidad,
                           String tipo,String lugar, Double sueldo, List<Requisito> requisitos, List<Categoria> categorias) {
        this.empresaId = empresaId;
        this.ofertaId = ofertaId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
        this.tipo = tipo;
        this.lugar = lugar;
        this.sueldo = sueldo;
        this.requisitos = requisitos;
        this.categorias = categorias;
    }

    public OfertaLaboralVO() {

    }

    public void agregarPostulante(PostulanteVO postulanteVO) {
        this.postulantes.add(postulanteVO);
    }

    public String getTitulo() {
        return this.titulo;
    }
    public Integer getEmpresaId() { return this.empresaId; }
    public Integer getOfertaId() { return this.ofertaId; }
    public List<PostulanteVO> getPostulantes() { return this.postulantes; }
    public void setPostulantes(List<PostulanteVO> postulantes) {
        this.postulantes = postulantes;
    }
}
