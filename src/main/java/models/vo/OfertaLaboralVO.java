package models.vo;

import models.enums.Categoria;
import models.enums.Requisito;

import java.util.List;

public class OfertaLaboralVO {
    private String titulo;
    private String descripcion;
    private String modalidad;
    private String tipo;
    private String lugar;
    private Double sueldo;
    private List<Requisito> requisitos;
    private List<Categoria> categorias;
    private List<PostulanteVO> postulantes;
    private Integer id = 0;

    public OfertaLaboralVO(String titulo, String descripcion, String modalidad, String tipo, String lugar, Double sueldo, List<Requisito> requisitos, List<Categoria> categorias, List<PostulanteVO> postulantes) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
        this.tipo = tipo;
        this.lugar = lugar;
        this.sueldo = sueldo;
        this.requisitos = requisitos;
        this.categorias = categorias;
        this.postulantes = postulantes;
        this.id += 1;
    }

    public List<Categoria> getCategorias() { return this.categorias; }

    public String getTitulo() {
        return this.titulo;
    }
}
