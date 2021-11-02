package models;

import models.dao.PublicacionDAO;
import models.vo.PublicacionVO;

import javax.swing.*;
import java.util.List;

public class Publicacion {

	public List<PublicacionVO> getPublicaciones() {
		PublicacionDAO miPublicacionDAO;
		
		try {				
			miPublicacionDAO = new PublicacionDAO();
			return miPublicacionDAO.getPublicaciones();			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
		}
					
		return null;
	}
}
