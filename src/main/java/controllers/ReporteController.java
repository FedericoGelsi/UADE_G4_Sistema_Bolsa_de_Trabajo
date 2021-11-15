package controllers;

import models.Publicacion;
import models.enums.Requisito;
import models.vo.*;
import views.VentanaReporte;

import java.util.List;

// TODO: Replace this class with InformeController.

public class ReporteController {

	private PublicacionController publicacionController;
	private VentanaReporte miVentanaReporte;
	
	public ReporteController() {
		publicacionController = new Publicacion();
	}
	
	public VentanaReporte getMiVentanaReporte() {
		return miVentanaReporte;
	}
	public void setMiVentanaReporte(VentanaReporte miVentanaReporte) {
		this.miVentanaReporte = miVentanaReporte;
	}	
	public Publicacion getMiLogica() {
		return publicacionController;
	}
	
//////////////////////////////////////////////////////////
	
	public void mostrarVentanaReporte() {
		miVentanaReporte.setVisible(true);
	}	
	
	public ReporteVO getReporteMayorOfertasLaborales(String mes, String anio) {
		ReporteVO res = new ReporteVO();
		List<PublicacionVO> publicaciones = publicacionController.getPublicaciones();
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
				title = ol.getTitulo();
				mayor = cant;
			}
		}
		
		res.setTitulo_oferta(title);
		res.setCantidad_entre_fechas(mayor);
		return res;
	}

}
