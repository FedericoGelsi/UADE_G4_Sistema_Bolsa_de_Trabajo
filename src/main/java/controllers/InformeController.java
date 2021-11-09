package controllers;

import models.enums.Categoria;
import models.vo.InformeVO;
import models.vo.OfertaLaboralVO;

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



    private static List<Categoria> getKeysWithMaxValue(Map<Categoria, Integer> map){
        List<Categoria> resultList = new ArrayList<>();
        int currentMaxValue = 1;
        for (Map.Entry<Categoria, Integer> entry : map.entrySet()){
            if (entry.getValue() >= currentMaxValue){
                resultList.clear();
                resultList.add(entry.getKey());
                currentMaxValue = entry.getValue();
            }
        }
        return resultList;
    }

}
