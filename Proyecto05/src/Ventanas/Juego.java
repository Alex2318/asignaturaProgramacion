package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;

public class Juego extends JFrame {

	private JPanel contentPane;
	private Jugador player1;//Se pone la variable y se importa el paquete de la clase jugador para que se accesible.
	private JLabel EtiquetaBienvenida;

	


	/**
	 * Create the frame.
	 */
	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		EtiquetaBienvenida = new JLabel("New Label");
		EtiquetaBienvenida.setBounds(10, 11, 414, 14);
		contentPane.add(EtiquetaBienvenida);
	}
	
	public void setJugador (Jugador player1) {//Setter en toda regla.
		this.player1=player1;
		EtiquetaBienvenida.setText("Hola "+player1.getNombre()+" "+player1.getApellidos()+" bienvenido a Math Dice.");
	}
		
	
}
