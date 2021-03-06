package views;

import controllers.InformeController;
import models.vo.InformeVO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaReporte extends JFrame {

	private JPanel contentPane;
	private InformeController miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador
	private JTextField txtMes;
	private JTextField txtAnio;

	/**
	 * Create the frame.
	 */
	public VentanaReporte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);	
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte Oferta Laboral con mayor postulaciones");
		lblNewLabel.setBounds(5, 5, 675, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mes");
		lblNewLabel_1.setBounds(30, 74, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Año");
		lblNewLabel_2.setBounds(30, 114, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		txtMes = new JTextField();
		txtMes.setBounds(103, 60, 130, 44);
		contentPane.add(txtMes);
		txtMes.setColumns(10);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(103, 100, 130, 44);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
				
		JLabel lblNewLabel_3 = new JLabel("Oferta:");
		lblNewLabel_3.setBounds(30, 236, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Postulantes:");
		lblNewLabel_4.setBounds(30, 274, 90, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblOfertaTitle = new JLabel("");
		lblOfertaTitle.setBounds(172, 236, 334, 16);
		contentPane.add(lblOfertaTitle);
		
		JLabel lblPostulantes = new JLabel("");
		lblPostulantes.setBounds(172, 274, 334, 16);
		contentPane.add(lblPostulantes);
		
		JButton btnNewButton = new JButton("Generar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformeVO miReporte = miCoordinador.getReporteMayorOfertasLaborales(txtMes.getText(), txtAnio.getText());
				
				lblOfertaTitle.setText(miReporte.getTitulo());
				lblPostulantes.setText(miReporte.getCantidad_entre_fechas().toString() + " candidatos");
			}
		});
		btnNewButton.setBounds(103, 167, 117, 29);
		contentPane.add(btnNewButton);		
	}
	
	public void setCoordinador(InformeController miCoordinador) {
		System.out.println("contro: " + miCoordinador.toString());
		this.miCoordinador=miCoordinador;
	}
}
