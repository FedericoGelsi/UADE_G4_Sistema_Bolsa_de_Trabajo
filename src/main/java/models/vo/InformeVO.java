package models.vo;

public class InformeVO {
    private String titulo;
    private Integer id;
    private String texto;

    public InformeVO(String titulo, Integer id, String texto) {
        this.titulo = titulo;
        this.id = id;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
