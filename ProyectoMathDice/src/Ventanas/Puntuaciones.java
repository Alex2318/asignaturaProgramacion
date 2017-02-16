package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

	/*
	 VENTANA EN LA QUE POSTERIORMENTE SE PONDR� UNA CLASIFICACI�N DE LAS 10 PRIMERAS PUNTUACIONES EN BASE A LOS 10 USUARIOS
	 QUE M�S PUNTOS LLEVEN EN EL TOTAL. 
	 
	 */
public class Puntuaciones extends JFrame {

	private JPanel contentPane;

	private JLabel LabelTitulo, LabelPuntuacion, LabelUsuario, LabelUsuario1, LabelUsuario2, LabelUsuario3, LabelUsuario4,
	LabelUsuario5, LabelUsuario6, LabelUsuario7, LabelUsuario8, LabelUsuario9, LabelUsuario10, LabelPuntuacion1, 
	LabelPuntuacion2, LabelPuntuacion3, LabelPuntuacion4, LabelPuntuacion5, LabelPuntuacion6, LabelPuntuacion7,
	LabelPuntuacion8, LabelPuntuacion9, LabelPuntuacion10;

	public static void main(String[] args) {
		
	}


	public Puntuaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 6200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{483, 503, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		LabelTitulo = new JLabel("PUNTUACIONES HIST\u00D3RICAS");
		LabelTitulo.setFont(new Font("Modern No. 20", Font.PLAIN, 30));
		GridBagConstraints gbc_LabelTitulo = new GridBagConstraints();
		gbc_LabelTitulo.gridwidth = 2;
		gbc_LabelTitulo.ipady = 40;
		gbc_LabelTitulo.ipadx = 2;
		gbc_LabelTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_LabelTitulo.gridheight = 2;
		gbc_LabelTitulo.weightx = 1.0;
		gbc_LabelTitulo.gridx = 0;
		gbc_LabelTitulo.gridy = 1;
		contentPane.add(LabelTitulo, gbc_LabelTitulo);
		
		LabelPuntuacion = new JLabel("PUNTUACI\u00D3N");
		LabelPuntuacion.setFont(new Font("Modern No. 20", Font.PLAIN, 17));
		GridBagConstraints gbc_LabelPuntuacion = new GridBagConstraints();
		gbc_LabelPuntuacion.insets = new Insets(0, 0, 5, 0);
		gbc_LabelPuntuacion.gridwidth = 0;
		gbc_LabelPuntuacion.weightx = 0.5;
		gbc_LabelPuntuacion.gridx = 1;
		gbc_LabelPuntuacion.gridy = 5;
		contentPane.add(LabelPuntuacion, gbc_LabelPuntuacion);
		
		LabelUsuario = new JLabel("USUARIO");
		LabelUsuario.setFont(new Font("Modern No. 20", Font.PLAIN, 17));
		GridBagConstraints gbc_LabelUsuario = new GridBagConstraints();
		gbc_LabelUsuario.ipadx = 1;
		gbc_LabelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario.weightx = 0.5;
		gbc_LabelUsuario.gridx = 0;
		gbc_LabelUsuario.gridy = 5;
		contentPane.add(LabelUsuario, gbc_LabelUsuario);
		
		LabelUsuario1 = new JLabel("Usuario1");
		GridBagConstraints gbc_LabelUsuario1 = new GridBagConstraints();
		gbc_LabelUsuario1.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario1.gridx = 0;
		gbc_LabelUsuario1.gridy = 7;
		contentPane.add(LabelUsuario1, gbc_LabelUsuario1);
		
		LabelPuntuacion1 = new JLabel("Puntuaci\u00F3n1");
		GridBagConstraints gbc_LabelPuntuacion1 = new GridBagConstraints();
		gbc_LabelPuntuacion1.insets = new Insets(0, 0, 5, 0);
		gbc_LabelPuntuacion1.gridx = 1;
		gbc_LabelPuntuacion1.gridy = 7;
		contentPane.add(LabelPuntuacion1, gbc_LabelPuntuacion1);
		
		LabelUsuario2 = new JLabel("Usuario 2");
		GridBagConstraints gbc_LabelUsuario2 = new GridBagConstraints();
		gbc_LabelUsuario2.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario2.gridx = 0;
		gbc_LabelUsuario2.gridy = 9;
		contentPane.add(LabelUsuario2, gbc_LabelUsuario2);
		
		LabelPuntuacion2 = new JLabel("Puntuaci\u00F3n2");
		GridBagConstraints gbc_LabelPuntuacion2 = new GridBagConstraints();
		gbc_LabelPuntuacion2.insets = new Insets(0, 0, 5, 0);
		gbc_LabelPuntuacion2.gridx = 1;
		gbc_LabelPuntuacion2.gridy = 9;
		contentPane.add(LabelPuntuacion2, gbc_LabelPuntuacion2);
		
		LabelUsuario3 = new JLabel("Usuario 3");
		GridBagConstraints gbc_LabelUsuario3 = new GridBagConstraints();
		gbc_LabelUsuario3.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario3.gridx = 0;
		gbc_LabelUsuario3.gridy = 11;
		contentPane.add(LabelUsuario3, gbc_LabelUsuario3);
		
		LabelPuntuacion3 = new JLabel("Puntuaci\u00F3n3");
		GridBagConstraints gbc_LabelPuntuacion3 = new GridBagConstraints();
		gbc_LabelPuntuacion3.insets = new Insets(0, 0, 5, 0);
		gbc_LabelPuntuacion3.gridx = 1;
		gbc_LabelPuntuacion3.gridy = 11;
		contentPane.add(LabelPuntuacion3, gbc_LabelPuntuacion3);
		
		LabelUsuario4 = new JLabel("Usuario 4");
		GridBagConstraints gbc_LabelUsuario4 = new GridBagConstraints();
		gbc_LabelUsuario4.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario4.gridx = 0;
		gbc_LabelUsuario4.gridy = 13;
		contentPane.add(LabelUsuario4, gbc_LabelUsuario4);
		
		LabelPuntuacion4 = new JLabel("Puntuaci\u00F3n4");
		GridBagConstraints gbc_LabelPuntuacion4 = new GridBagConstraints();
		gbc_LabelPuntuacion4.insets = new Insets(0, 0, 5, 0);
		gbc_LabelPuntuacion4.gridx = 1;
		gbc_LabelPuntuacion4.gridy = 13;
		contentPane.add(LabelPuntuacion4, gbc_LabelPuntuacion4);
		
		LabelUsuario5 = new JLabel("Usuario 5");
		GridBagConstraints gbc_LabelUsuario5 = new GridBagConstraints();
		gbc_LabelUsuario5.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario5.gridx = 0;
		gbc_LabelUsuario5.gridy = 15;
		contentPane.add(LabelUsuario5, gbc_LabelUsuario5);
		
		LabelPuntuacion5 = new JLabel("Puntuaci\u00F3n5");
		GridBagConstraints gbc_LabelPuntuacion5 = new GridBagConstraints();
		gbc_LabelPuntuacion5.insets = new Insets(0, 0, 5, 0);
		gbc_LabelPuntuacion5.gridx = 1;
		gbc_LabelPuntuacion5.gridy = 15;
		contentPane.add(LabelPuntuacion5, gbc_LabelPuntuacion5);
		
		LabelUsuario6 = new JLabel("Usuario 6");
		GridBagConstraints gbc_LabelUsuario6 = new GridBagConstraints();
		gbc_LabelUsuario6.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario6.gridx = 0;
		gbc_LabelUsuario6.gridy = 17;
		contentPane.add(LabelUsuario6, gbc_LabelUsuario6);
		
		LabelPuntuacion6 = new JLabel("Puntuaci\u00F3n6");
		GridBagConstraints gbc_LabelPuntuacion6 = new GridBagConstraints();
		gbc_LabelPuntuacion6.insets = new Insets(0, 0, 5, 0);
		gbc_LabelPuntuacion6.gridx = 1;
		gbc_LabelPuntuacion6.gridy = 17;
		contentPane.add(LabelPuntuacion6, gbc_LabelPuntuacion6);
		
		LabelUsuario7 = new JLabel("Usuario 7");
		GridBagConstraints gbc_LabelUsuario7 = new GridBagConstraints();
		gbc_LabelUsuario7.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario7.gridx = 0;
		gbc_LabelUsuario7.gridy = 19;
		contentPane.add(LabelUsuario7, gbc_LabelUsuario7);
		
		LabelPuntuacion7 = new JLabel("Puntuaci\u00F3n7");
		GridBagConstraints gbc_LabelPuntuacion7 = new GridBagConstraints();
		gbc_LabelPuntuacion7.insets = new Insets(0, 0, 5, 0);
		gbc_LabelPuntuacion7.gridx = 1;
		gbc_LabelPuntuacion7.gridy = 19;
		contentPane.add(LabelPuntuacion7, gbc_LabelPuntuacion7);
		
		LabelUsuario8 = new JLabel("Usuario 8");
		GridBagConstraints gbc_LabelUsuario8 = new GridBagConstraints();
		gbc_LabelUsuario8.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario8.gridx = 0;
		gbc_LabelUsuario8.gridy = 21;
		contentPane.add(LabelUsuario8, gbc_LabelUsuario8);
		
		LabelPuntuacion8 = new JLabel("Puntuaci\u00F3n8");
		GridBagConstraints gbc_LabelPuntuacion8 = new GridBagConstraints();
		gbc_LabelPuntuacion8.insets = new Insets(0, 0, 5, 0);
		gbc_LabelPuntuacion8.gridx = 1;
		gbc_LabelPuntuacion8.gridy = 21;
		contentPane.add(LabelPuntuacion8, gbc_LabelPuntuacion8);
		
		LabelUsuario9 = new JLabel("Usuario 9");
		GridBagConstraints gbc_LabelUsuario9 = new GridBagConstraints();
		gbc_LabelUsuario9.insets = new Insets(0, 0, 5, 5);
		gbc_LabelUsuario9.gridx = 0;
		gbc_LabelUsuario9.gridy = 23;
		contentPane.add(LabelUsuario9, gbc_LabelUsuario9);
		
		LabelPuntuacion9 = new JLabel("Puntuaci\u00F3n9");
		GridBagConstraints gbc_LabelPuntuacion9 = new GridBagConstraints();
		gbc_LabelPuntuacion9.insets = new Insets(0, 0, 5, 0);
		gbc_LabelPuntuacion9.gridx = 1;
		gbc_LabelPuntuacion9.gridy = 23;
		contentPane.add(LabelPuntuacion9, gbc_LabelPuntuacion9);
		
		LabelUsuario10 = new JLabel("Usuario 10");
		GridBagConstraints gbc_LabelUsuario10 = new GridBagConstraints();
		gbc_LabelUsuario10.insets = new Insets(0, 0, 0, 5);
		gbc_LabelUsuario10.gridx = 0;
		gbc_LabelUsuario10.gridy = 25;
		contentPane.add(LabelUsuario10, gbc_LabelUsuario10);
		
		LabelPuntuacion10 = new JLabel("Puntuaci\u00F3n10");
		GridBagConstraints gbc_LabelPuntuacion10 = new GridBagConstraints();
		gbc_LabelPuntuacion10.gridx = 1;
		gbc_LabelPuntuacion10.gridy = 25;
		contentPane.add(LabelPuntuacion10, gbc_LabelPuntuacion10);
	}

}
