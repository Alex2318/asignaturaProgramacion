package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;

public class Juego extends JFrame {

	private JPanel contentPane;
	private Jugador player1;//Se pone la variable y se importa el paquete de la clase jugador para que se accesible.
	private JLabel EtiquetaBienvenida;

	


	/**
	 * Create the frame.
	 */
	public Juego() {
		setTitle("Math Dice-Juego");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\USUARIO.LAPTOP-QGQP1H9N\\OneDrive - Florida Centre de Formaci\u00F3 Coop.V\\DAM\\Programaci\u00F3n\\icono-dado1.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		EtiquetaBienvenida = new JLabel("New Label");
		EtiquetaBienvenida.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		EtiquetaBienvenida.setBounds(10, 11, 414, 29);
		contentPane.add(EtiquetaBienvenida);
	}
	
	public void setJugador (Jugador player1) {//Setter en toda regla.
		this.player1=player1;
		EtiquetaBienvenida.setText("Hola "+player1.getNombre()+" "+player1.getApellidos()+" bienvenido a Math Dice.");
	}
		
	
}
