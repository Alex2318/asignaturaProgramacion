package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField JTextEdad;
	private JTextField JTextApellidos;
	private JTextField JTextNombre;
	private JTextField JTextCampo;
	private Login referencia;//Creamos referencia sobre Login.
	private Juego vJuego;
	private Jugador player1=new Jugador();

	
	
	public Login(Juego vJ) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/dado.png")));
		setForeground(SystemColor.activeCaption);
		setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		setTitle("Math Dice");
		
		referencia=this;//Metemos aquí la referencia para que lo que siga lo haga sobre Login.
		vJuego=vJ;
		
		//Inicalizamos player1.

		player1.setNombre("");
		player1.setApellidos("");
		player1.setEdad(0);
		player1.setId(0);

		//Propiedades de la ventana y del contentPane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta título.
		JLabel lblIntroduzcaLosDatos = new JLabel("Introduzca los datos del jugador");
		lblIntroduzcaLosDatos.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		lblIntroduzcaLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduzcaLosDatos.setBounds(90, 10, 237, 45);
		contentPane.add(lblIntroduzcaLosDatos);
		
		//Etiqueta nombre.
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		lblNombre.setBounds(10, 65, 86, 20);
		contentPane.add(lblNombre);
		
		//Etiqueta apellidos.
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		lblApellidos.setBounds(10, 120, 86, 20);
		contentPane.add(lblApellidos);
		
		//Etiqueta edad.
		JLabel lblEdad = new JLabel("Edad ");
		lblEdad.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		lblEdad.setBounds(10, 175, 86, 20);
		contentPane.add(lblEdad);
		
		//Campo de texto nombre.
		JTextNombre = new JTextField();
		JTextNombre.setBounds(90, 66, 334, 20);
		contentPane.add(JTextNombre);
		JTextNombre.setColumns(10);
	
		//Campo de texto apellidos.
		JTextApellidos = new JTextField();
		JTextApellidos.setBounds(90, 121, 334, 20);
		contentPane.add(JTextApellidos);
		JTextApellidos.setColumns(10);
		
		//Campo de texto edad.
		JTextEdad = new JTextField();
		JTextEdad.setBounds(90, 176, 86, 20);
		contentPane.add(JTextEdad);
		JTextEdad.setColumns(10);
		JTextEdad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Guardar nombre.
				player1.setNombre(JTextNombre.getText());
				vJuego.setJugador(player1);
				//Guardar apellidos.
				player1.setApellidos(JTextApellidos.getText());

				//Guardar edad.
				if (player1.isNumeric(JTextEdad.getText())==true)//Si el método creado en la clase jugador nos devuelve un true...
					player1.setEdad(Integer.parseInt(JTextEdad.getText()));//...introducimos la edad como int al player1 
					else//De la otra forma...
						player1.setEdad(999);//...la edad se rellena como 999 y eso nos valdrá para aclarar futuras comprobaciones.
				if (player1.isNumeric(JTextEdad.getText())==true)//Si el método creado en la clase jugador nos devuelve un true...
				player1.setEdad(Integer.parseInt(JTextEdad.getText()));//...introducimos la edad como int al player1 
				else//De la otra forma...
					player1.setEdad(999);//...la edad se rellena como 999 y eso nos valdrá para aclarar futuras comprobaciones.
				//Sentencia if para comprobar que no hay espacios en blanco en los JTextField.
				if(player1.enBlanco(player1.getNombre())){//Cambio método de comprobación de getText.lenght()==0 al método del ejemplo al incluir éste también la opción de una cadena con espacios en blanco
					JTextCampo.setText("No ha introducido el nombre. Introdúzcalo y pulse Enter.");
				}else if(player1.enBlanco(player1.getApellidos())){
					JTextCampo.setText("No ha introducido los apellidos. Introdúzcalos y pulse Enter.");
				}else if(player1.getEdad()==999){
					JTextCampo.setText("Error u omisión al introducir la edad. Introdúzcala y pulse Enter");
				}else{	
					JTextCampo.setText("Creado nuevo jugador: "+player1.getNombre()+" "+player1.getApellidos()+" de "+player1.getEdad()+" años.");
				}
			}
		});

		//Campo de texto confirmación.
		JTextCampo = new JTextField();
		JTextCampo.setBounds(10, 303, 414, 97);
		contentPane.add(JTextCampo);
		JTextCampo.setColumns(10);

		//Botón confirmación.
		JButton Boton = new JButton("Empieza el juego");
		//En un Listener metemos todas las acciones
		Boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Guardar nombre.
				player1.setNombre(JTextNombre.getText());
				vJuego.setJugador(player1);
				//Guardar apellidos.
				player1.setApellidos(JTextApellidos.getText());

				//Guardar edad.
				if (player1.isNumeric(JTextEdad.getText())==true)//Si el método creado en la clase jugador nos devuelve un true...
					player1.setEdad(Integer.parseInt(JTextEdad.getText()));//...introducimos la edad como int al player1 
					else//De la otra forma...
						player1.setEdad(999);//...la edad se rellena como 999 y eso nos valdrá para aclarar futuras comprobaciones.
				
				//Dependiendo de los campos de texto vamos a mostrar un mensaje de confirmación o error por el JTextCampo.
				if (player1.getEdad()==999){
					JTextCampo.setText("Edad erronea. Vuelva a rellenarla y pulse Empieza el juego");
				}else if (player1.enBlanco(player1.getNombre())){
					JTextCampo.setText("Falta rellenar el nombre. Rellenelo y pulse Empieza el juego");
				}else if (player1.enBlanco(player1.getApellidos())){
					JTextCampo.setText("Falta rellenar los apellidos. Rellenelos y pulse Empieza el juego");
				}else{	
					JTextCampo.setText("Creado nuevo jugador: "+player1.getNombre()+" "+player1.getApellidos()+" de "+player1.getEdad()+" años.");
					vJuego.setVisible(true);
					referencia.dispose();
				}
			}
				
		});
		Boton.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		Boton.setBounds(7, 230, 417, 38);
		contentPane.add(Boton);
		
		
		
	}

}
