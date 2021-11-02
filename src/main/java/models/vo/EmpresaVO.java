package models.vo;

public class EmpresaVO {
    private String nombre;
    private String cuit;
    private Integer id;

    public EmpresaVO(String nombre, String cuit, Integer id) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
