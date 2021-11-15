package controllers;

import models.enums.Categoria;
import models.enums.Requisito;
import models.vo.InformeVO;
import models.vo.OfertaLaboralVO;
import models.vo.PublicacionVO;

import java.util.*;

public class InformeController {

    private OfertaController ofertaController;

    public List<Categoria> categoriasMasSeleccionadas(Integer idEmpresa, Integer cantidad) {
        Map<Categoria, Integer> ofertas = new HashMap<>();

        List<OfertaLaboralVO> ofertasLaborales = ofertaController.ObtenerOfertasLaborales(idEmpresa);

        ofertasLaborales.forEach(oferta -> {
            oferta.getCategorias().forEach( categoria -> {
                 if(ofertas.containsKey(categoria)) {
                     ofertas.put(categoria, ofertas.get(categoria)+1);
                 } else {
                     ofertas.put(categoria, 1);
                 }
            });
        });

        return getKeysWithMaxValue(ofertas, cantidad);
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

    public InformeVO getInformeOfertaMasAccesible(){
        String title = "Oferta Mas Accesible";
        int menosRequisitos = 0, menosTareas = 0;
        List<Requisito> requisitosList;
        String modalidad, tipo, descripcion, resultado = null;

        List<PublicacionVO> publicaciones = publicacionController.getPublicaciones();
        for(PublicacionVO publicacionVO : publicaciones) {
            OfertaLaboralVO ofertaLaboralVO = publicacionVO.getOfertaLaboral();
            requisitosList = ofertaLaboralVO.getRequisitos();
            modalidad = ofertaLaboralVO.getModaIidad();
            tipo = ofertaLaboralVO.getTipo();
            descripcion = ofertaLaboralVO.getDescripcion();

            if (modalidad == Modalidad.PART_TIME && tipo == Tipo.REMOTO) {
                if (descripcion.length() < menosTareas) {
                    if (requisitosList.size() < menosRequisitos) {
                        menosRequisitos = requisitosList.size();
                        menosTareas = descripcion.length();
                        resultado = ofertaLaboralVO.getTitulo();
                    }
                }
            }
        }

        return new InformeVO(title,resultado) ;
    }

}
