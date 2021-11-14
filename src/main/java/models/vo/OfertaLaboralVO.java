package models.vo;

import models.enums.Categoria;
import models.enums.Modalidad;
import models.enums.Requisito;
import models.enums.Tipo;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OfertaLaboralVO {
    private String titulo;
    private String descripcion;
    private Modalidad modalidad;
    private Tipo tipo;
    private String lugar;
    private Double sueldo;
    private List<Requisito> requisitos;
    private List<Categoria> categorias;
    private List<PostulanteVO> postulantes;
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int ofertaId;


    public OfertaLaboralVO() {
        this.ofertaId = count.incrementAndGet();
    }

    public OfertaLaboralVO(String titulo, String descripcion, Modalidad modalidad, Tipo tipo, String lugar, Double sueldo, List<Requisito> requisitos, List<Categoria> categorias, List<PostulanteVO> postulantes) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
        this.tipo = tipo;
        this.lugar = lugar;
        this.sueldo = sueldo;
        this.requisitos = requisitos;
        this.categorias = categorias;
        this.postulantes = postulantes;
        this.ofertaId = count.incrementAndGet();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getLugar() {
        return lugar;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public List<Requisito> getRequisitos() {
        return requisitos;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<PostulanteVO> getPostulantes() {
        return postulantes;
    }

    public Integer getId() {
        return ofertaId;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
        this.lugar = this.tipo == Tipo.REMOTO ? null : this.lugar;
    }
}
