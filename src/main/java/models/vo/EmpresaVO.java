package models.vo;

import java.util.concurrent.atomic.AtomicInteger;

public class EmpresaVO {
    private String nombre;
    private Integer cuit;
    private final Integer empresaId;
    private static final AtomicInteger count = new AtomicInteger(0);

    public EmpresaVO(String nombre, Integer cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.empresaId = count.incrementAndGet();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCuit() {
        return cuit;
    }

    public void setCuit(Integer cuit) {
        this.cuit = cuit;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

}
