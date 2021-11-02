package models.vo;

import java.util.List;

public class OfertaLaboralVO {
    private String titulo;
    private String descripcion;
    private String modalidad;
    private String tipo;
    private String lugar;
    private Double sueldo;
    private List<RequisitoVO> requisitos;
    private List<CategoriaVO> categorias;
    private List<PostulacionVO> postulantes;
    private Integer id = 0;

    public OfertaLaboralVO(String titulo, String descripcion, String modalidad, String tipo, String lugar, Double sueldo, List<RequisitoVO> requisitos, List<CategoriaVO> categorias, List<PostulacionVO> postulantes) {
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



    public String getTitulo() {
        return this.titulo;
    }
}
