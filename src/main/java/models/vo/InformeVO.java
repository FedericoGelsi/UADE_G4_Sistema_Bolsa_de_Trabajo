package models.vo;


import java.util.concurrent.atomic.AtomicInteger;

public class InformeVO {
    private String titulo;
    private Integer informeId;
    private String texto;
    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer cantidad_entre_fechas;


    public InformeVO(String titulo, String texto) {
        this.titulo = titulo;
        this.informeId = count.incrementAndGet();
        this.texto = texto;
    }

    public InformeVO() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getId() {
        return informeId;
    }

    public void setId(Integer id) {
        this.informeId = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public Integer getCantidad_entre_fechas() {
        return cantidad_entre_fechas;
    }
    public void setCantidad_entre_fechas(Integer cantidad_entre_fechas) {
        this.cantidad_entre_fechas = cantidad_entre_fechas;
    }
}
