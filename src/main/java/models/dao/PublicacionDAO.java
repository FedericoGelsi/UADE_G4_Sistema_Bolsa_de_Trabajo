package models.dao;

import exceptions.PostulanteException;
import models.connections.Conexion;
import models.vo.*;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PublicacionDAO {
	public List<PublicacionVO> getPublicaciones() {
		Conexion conex= new Conexion();
		List<PublicacionVO> publicaciones= new ArrayList<PublicacionVO>();		
		List<PostulanteVO> postulaciones= new ArrayList<PostulanteVO>();

		try {			
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM publicacion pub"
					+ " inner join postulacion pos on pub.id = pos.publicacion_id inner join candidato c on c.id = pos.candidato_id");
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				int i = indexOfArray(publicaciones, res.getString("titulo"));
				
				if(i == -1) {
					OfertaLaboralVO ofertaLaboralVO = new OfertaLaboralVO();
					PublicacionVO publicacion= new PublicacionVO(
							ofertaLaboralVO,
							LocalDateTime.now(),
							LocalDateTime.now().plusMonths(2)
					);
					postulaciones= new ArrayList<PostulanteVO>();
					
					PostulanteVO pos = new PostulanteVO();
					pos.setMes(Integer.parseInt(res.getString("mes")));
					pos.setAnio(Integer.parseInt(res.getString("anio")));
					
					CandidatoVO cand = new CandidatoVO(
							res.getString("nombre"),
							res.getString("apellido"),
							Integer.parseInt(res.getString("DNI"))
					);
					pos.setCandidato(cand);
					postulaciones.add(pos);
					
					publicacion.setPostulaciones(postulaciones);
					publicaciones.add(publicacion);
				}
				else {
					PublicacionVO publicacion = publicaciones.get(i);
					PostulanteVO pos = new PostulanteVO();
					pos.setMes(Integer.parseInt(res.getString("mes")));
					pos.setAnio(Integer.parseInt(res.getString("anio")));

					CandidatoVO cand = new CandidatoVO(
							res.getString("nombre"),
							res.getString("apellido"),
							Integer.parseInt(res.getString("DNI"))
					);
					pos.setCandidato(cand);
					publicacion.getPostulaciones().add(pos);
					publicaciones.set(i, publicacion);
				}				
			}
			res.close();
			conex.desconectar();				
					
		} catch (SQLException | PostulanteException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}
		
		return publicaciones;
	}
	
	private int indexOfArray(List<PublicacionVO> publicaciones, String job) {
		int index = -1;
		for(int i = 0; i< publicaciones.size(); i++) {
			if(job.equals(publicaciones.get(i).getOfertaLaboralVO().getTitulo()))
					index = i;
		}
		return index;
	}
}
