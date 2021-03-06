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

/*
 * *Ventana donde a trav�s de la clase Login de tipo JFrame presentamos la ventana que aparecer� cuando ejecutemos
 *  la aplicaci�n. 
 * *En ella se presentan distintas etiquetas, cajas de texto para que el usuario introduzca sus datos y de esta forma
 *  crear un nuevo jugador. Este jugador tendr� las caracter�sticas definidas en la clase Jugador, en el paquete Juego.
 * *A la hora de introducir los datos y pasar a la siguente ventan hemos introducido dos metodolog�as diferentes.
 * *La primera es la de hacerlo a trav�s del bot�n, al darle se ejecutar�n las acciones para determinar si los datos
 *  est�n bien introducidos y de ser as� se crear� el jugador y se dar� paso a la siguiente ventana Juego, cerrando la
 *  presente.
 * *La otra opci�n que tambi�n hemos elegido para hacer m�s r�pido el login es la de implementar todas las acciones
 *  anteriores en un listener al apretar intro en la caja donde se introduce la edad (la �ltima de arriba abajo).
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField JTextEdad;
	private JTextField JTextApellidos;
	private JTextField JTextNombre;
	private JTextField JTextCampo;
	private Login referencia;//Creamos referencia sobre Login.
	private JuegoPrincipiante vJuego;
	private JuegoExperto vExperto;
	private Jugador player1=new Jugador();

	
	//Constructor de la ventana Login
	public Login(JuegoPrincipiante vJ, JuegoExperto vE) {
		
		//Metemos aqu� la referencia para que lo que siga lo haga sobre Login.
		referencia=this;
		vJuego=vJ;
		vExperto=vE;
		
		//Inicalizamos player1.
		player1.setNombre("");
		player1.setApellidos("");
		player1.setEdad(0);
		player1.setId(0);
		
		//Propiedades de la ventana y del contentPane	
		setForeground(SystemColor.activeCaption);
		setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		setIconImage(Toolkit.getDefaultToolkit().getImage(JuegoPrincipiante.class.getResource("/Imagenes/dado.png")));
		setTitle("Math Dice");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta t�tulo.
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
				if (player1.isNumeric(JTextEdad.getText())==true)//Si el m�todo creado en la clase jugador nos devuelve un true...
					player1.setEdad(Integer.parseInt(JTextEdad.getText()));//...introducimos la edad como int al player1 
					else//De la otra forma...
						player1.setEdad(999);//...la edad se rellena como 999 y eso nos valdr� para aclarar futuras comprobaciones.
				if (player1.isNumeric(JTextEdad.getText())==true)//Si el m�todo creado en la clase jugador nos devuelve un true...
				player1.setEdad(Integer.parseInt(JTextEdad.getText()));//...introducimos la edad como int al player1 
				else//De la otra forma...
					player1.setEdad(999);//...la edad se rellena como 999 y eso nos valdr� para aclarar futuras comprobaciones.
				//Sentencia if para comprobar que no hay espacios en blanco en los JTextField.
				if(player1.enBlanco(player1.getNombre())){//Cambio m�todo de comprobaci�n de getText.lenght()==0 al m�todo del ejemplo al incluir �ste tambi�n la opci�n de una cadena con espacios en blanco
					JTextCampo.setText("No ha introducido el nombre. Introd�zcalo y pulse Enter.");
				}else if(player1.enBlanco(player1.getApellidos())){
					JTextCampo.setText("No ha introducido los apellidos. Introd�zcalos y pulse Enter.");
				}else if(player1.getEdad()==999){
					JTextCampo.setText("Error u omisi�n al introducir la edad. Introd�zcala y pulse Enter");
				}else{	
					JTextCampo.setText("Creado nuevo jugador: "+player1.getNombre()+" "+player1.getApellidos()+" de "+player1.getEdad()+" a�os.");
					vJuego.setVisible(true);
					referencia.dispose();
				}
			}
		});

		//Campo de texto confirmaci�n.
		JTextCampo = new JTextField();
		JTextCampo.setText("Introduce los datos y elige nivel");
		JTextCampo.setBounds(10, 303, 414, 97);
		contentPane.add(JTextCampo);
		JTextCampo.setColumns(10);
		
		JButton BotonExperto = new JButton("Experto");
		BotonExperto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Guardar nombre.
				player1.setNombre(JTextNombre.getText());
				vExperto.setJugador(player1);
				//Guardar apellidos.
				player1.setApellidos(JTextApellidos.getText());
				//Guardar edad.
				if (player1.isNumeric(JTextEdad.getText())==true)//Si el m�todo creado en la clase jugador nos devuelve un true...
					player1.setEdad(Integer.parseInt(JTextEdad.getText()));//...introducimos la edad como int al player1 
					else//De la otra forma...
						player1.setEdad(999);//...la edad se rellena como 999 y eso nos valdr� para aclarar futuras comprobaciones.
				
				//Dependiendo de los campos de texto vamos a mostrar un mensaje de confirmaci�n o error por el JTextCampo.
				if (player1.getEdad()==999){
					JTextCampo.setText("Edad erronea. Vuelva a rellenarla y pulse Empieza el juego");
				}else if (player1.enBlanco(player1.getNombre())){
					JTextCampo.setText("Falta rellenar el nombre. Rellenelo y pulse Empieza el juego");
				}else if (player1.enBlanco(player1.getApellidos())){
					JTextCampo.setText("Falta rellenar los apellidos. Rellenelos y pulse Empieza el juego");
				}else{	
					JTextCampo.setText("Creado nuevo jugador: "+player1.getNombre()+" "+player1.getApellidos()+" de "+player1.getEdad()+" a�os.");
					vExperto.setVisible(true);
					referencia.dispose();
				}
			}
			
		});
		BotonExperto.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		BotonExperto.setBounds(255, 228, 169, 45);
		contentPane.add(BotonExperto);
		

		//Bot�n confirmaci�n.
		JButton BotonPrincipiante = new JButton("Principiante");
		//En un Listener metemos todas las acciones
		BotonPrincipiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Guardar nombre.
				player1.setNombre(JTextNombre.getText());
				vJuego.setJugador(player1);
				//Guardar apellidos.
				player1.setApellidos(JTextApellidos.getText());
				//Guardar edad.
				if (player1.isNumeric(JTextEdad.getText())==true)//Si el m�todo creado en la clase jugador nos devuelve un true...
					player1.setEdad(Integer.parseInt(JTextEdad.getText()));//...introducimos la edad como int al player1 
					else//De la otra forma...
						player1.setEdad(999);//...la edad se rellena como 999 y eso nos valdr� para aclarar futuras comprobaciones.
				
				//Dependiendo de los campos de texto vamos a mostrar un mensaje de confirmaci�n o error por el JTextCampo.
				if (player1.getEdad()==999){
					JTextCampo.setText("Edad erronea. Vuelva a rellenarla y pulse Empieza el juego");
				}else if (player1.enBlanco(player1.getNombre())){
					JTextCampo.setText("Falta rellenar el nombre. Rellenelo y pulse Empieza el juego");
				}else if (player1.enBlanco(player1.getApellidos())){
					JTextCampo.setText("Falta rellenar los apellidos. Rellenelos y pulse Empieza el juego");
				}else{	
					JTextCampo.setText("Creado nuevo jugador: "+player1.getNombre()+" "+player1.getApellidos()+" de "+player1.getEdad()+" a�os.");
					vJuego.setVisible(true);
					referencia.dispose();
				}
			}
				
		});
		BotonPrincipiante.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		BotonPrincipiante.setBounds(7, 230, 169, 38);
		contentPane.add(BotonPrincipiante);
		
	
		
		
	}
}
