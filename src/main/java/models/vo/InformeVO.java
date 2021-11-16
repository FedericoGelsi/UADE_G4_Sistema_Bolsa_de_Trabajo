package models.vo;


import java.util.concurrent.atomic.AtomicInteger;

public class InformeVO {
    private String titulo;
    private Integer informeId;
    private String data;
    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer cantidad_entre_fechas;


    public InformeVO(String titulo, String data) {
        this.titulo = titulo;
        this.informeId = count.incrementAndGet();
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getInformeId() {
        return informeId;
    }

    public void setId(Integer id) {
        this.informeId = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public Integer getCantidad_entre_fechas() {
        return cantidad_entre_fechas;
    }
    public void setCantidad_entre_fechas(Integer cantidad_entre_fechas) {
        this.cantidad_entre_fechas = cantidad_entre_fechas;
    }
}
