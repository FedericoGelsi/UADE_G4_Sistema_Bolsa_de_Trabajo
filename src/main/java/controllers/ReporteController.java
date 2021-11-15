package controllers;

import models.Publicacion;
import models.vo.*;
import views.VentanaReporte;

import java.util.List;

// TODO: Replace this class with InformeController.

public class ReporteController {

	private Publicacion publicacion;
	private VentanaReporte miVentanaReporte;
	
	public ReporteController() {
		publicacion = new Publicacion();
	}
	
	public VentanaReporte getMiVentanaReporte() {
		return miVentanaReporte;
	}
	public void setMiVentanaReporte(VentanaReporte miVentanaReporte) {
		this.miVentanaReporte = miVentanaReporte;
	}	
	public Publicacion getMiLogica() {
		return publicacion;
	}
	
//////////////////////////////////////////////////////////
	
	public void mostrarVentanaReporte() {
		miVentanaReporte.setVisible(true);
	}	
	

}
