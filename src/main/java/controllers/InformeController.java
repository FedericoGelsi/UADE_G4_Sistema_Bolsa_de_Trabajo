package controllers;

import models.Publicacion;
import models.enums.Categoria;
import models.enums.Requisito;
import models.vo.*;
import views.VentanaReporte;

import java.util.*;

public class InformeController {

    private PublicacionController publicacionController;
    private Publicacion publicacion;
    private VentanaReporte miVentanaReporte;

    public InformeVO categoriasMasSeleccionadas(Integer idEmpresa, Integer cantidad) {
        Map<Categoria, Integer> ofertas = new HashMap<>();
        List<Categoria> categoriasMasSeleccionadas;
        InformeVO informe;
        List<OfertaLaboralVO> ofertasLaborales = publicacionController.getOfertasLaborales(idEmpresa);

        ofertasLaborales.forEach(oferta -> {
            oferta.getCategorias().forEach( categoria -> {
                 if(ofertas.containsKey(categoria)) {
                     ofertas.put(categoria, ofertas.get(categoria)+1);
                 } else {
                     ofertas.put(categoria, 1);
                 }
            });
        });

        categoriasMasSeleccionadas = getKeysWithMaxValue(ofertas, cantidad);

        informe = new InformeVO(
                "Categorias",
                String.join(";", categoriasMasSeleccionadas.toString())
        );

        return informe;
    }

    private static List<Categoria> getKeysWithMaxValue(Map<Categoria, Integer> ofertas, Integer qty) {
        Map<Categoria, Integer> ofertasCopia = new HashMap<Categoria, Integer>(ofertas);
        Map.Entry<Categoria,Integer> maxCategory = null;
        List<Categoria> categorias = new ArrayList<>();

        while(qty != 0) {
            for (Map.Entry<Categoria, Integer> cat : ofertasCopia.entrySet()) {
                if (maxCategory == null || cat.getValue().compareTo(maxCategory.getValue()) > 0) {
                    maxCategory = cat;
                }
            }
            categorias.add(maxCategory.getKey());
            ofertasCopia.remove(maxCategory.getKey());
            qty--;
        }
        return categorias;
    }

    public InformeVO getReporteMayorOfertasLaborales(String mes, String anio) {
        InformeVO res = new InformeVO();
        List<PublicacionVO> publicaciones = publicacion.getPublicaciones();
        String title = "";
        int mayor = 0;
        for(PublicacionVO ol : publicaciones) {
            int cant = 0;
            for(PostulanteVO postulacion : ol.getPostulaciones()) {
                if(postulacion.getAnio().toString().equals(anio.trim())) {
                    if(!mes.trim().equals("") && postulacion.getMes().toString().equals(mes.trim())) {
                        cant++;
                    }
                    else if(mes.trim().equals("")){
                        cant++;
                    }
                }
            }
            if(cant > mayor) {
                title = ol.getOfertaLaboralVO().getTitulo();
                mayor = cant;
            }
        }

        res.setTitulo(title);
        res.setCantidad_entre_fechas(mayor);
        return res;
    }

    public InformeVO trabajoMasExigente() {
        String title = "";
        String texto = "";
        int cantRequisitos = 0;
        int id = -1;

        List<PublicacionVO> publicaciones = publicacionController.getPublicaciones();
        for (PublicacionVO p : publicaciones) {
            List<Requisito> requisitos = p.getOfertaLaboralVO().getRequisitos();
            if (requisitos.size() > cantRequisitos) {
                cantRequisitos = requisitos.size();
                title = p.getOfertaLaboralVO().getTitulo();
                id = p.getOfertaLaboralVO().getOfertaId();
                texto = p.getOfertaLaboralVO().getDescripcion();
            }
        }
        return new InformeVO(title, texto);
    }

    public void setMiVentanaReporte(VentanaReporte miVentanaReporte) {
        this.miVentanaReporte = miVentanaReporte;
    }

    public VentanaReporte getMiVentanaReporte() {
        return miVentanaReporte;
    }
    public void mostrarVentanaReporte() {
        miVentanaReporte.setVisible(true);
    }
}
