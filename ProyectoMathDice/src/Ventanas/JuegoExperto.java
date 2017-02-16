package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;


import Juego.Jugador;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JuegoExperto extends JFrame {

	//Definimos variables
	
	//ContentPane
	private JPanel contentPane;
	//Player1 de la clase jugador
	private Jugador player1;
	//Etiqueta bienvenida creada en el proyecto 05
	private JLabel LabelBienvenidaExp;
	//Etiquetas para meter im�genes de dados
	private JLabel LabelDado_12_1,LabelDado_12_2;
	private JLabel LabelDado_3_1,LabelDado_3_2,LabelDado_3_3;
	private JLabel LabelDado_6_1,LabelDado_6_2,LabelDado_6_3;
	//Etiqueta para sacar puntuaci�n obtenida
	private JLabel LabelPuntuacion;
	//Etiqueta donde saldr� la confirmaci�n de que la operaci�n est� bien hecha
	private JLabel LabelResultado; 
	//Etiqueta para sacar el n�mero de aciertos seguidos.
	private JLabel LabelAciertosSeguidos;
	//JText d�nde haremos las operaciones del juego
	private JTextField JTextOperacion;
	//Bot�nes operaciones
	private JButton botonSuma, botonResta, botonProducto, botonDivision, botonParentesis, botonParentesisCierre;
	//Bot�n Mathdice
	private JButton ButtonMathdice;
	//Bot�n para resetear el juego
	private JButton btnReset;
	//Etiqueta interrogante
	private JLabel LabelInterrogante;
	//Ventana de instrucciones que abriremos con un listener en LabelInterrogante
	private InstruccionesExperto vInsE;
	//Etiqueta objetivo
	private JLabel LabelObjetivo;

	//Diferentes im�genes
    private ImageIcon dado3_1 = null;
    private ImageIcon dado3_2 = null;
    private ImageIcon dado3_3 = null;
    private ImageIcon dado6_1 = null;
    private ImageIcon dado6_2 = null;
    private ImageIcon dado6_3 = null;
    private ImageIcon dado12 = null;
    private ImageIcon dado12_2= null;
    private ImageIcon dado_gris=new ImageIcon (getClass().getResource("/Imagenes/dadogris.png"));
    
    //Arrays de los distintos dados para posteriorment sacar el valor 
    private int [] valor_3caras=new int [3];
    private int [] valor_6caras=new int [3];
    
    //Valor del dado de doce caras, producido por la funci�n Math.random
    private int valor12_1 = (int) (Math.round(Math.random() *(1-12)+12));
    private int valor12_2 = (int) (Math.round(Math.random() *(1-12)+12));
    //(Math.random() *(m�nimo-m�ximo)+m�ximo)
    
	
	//Variable objetivo que la incializamos a cero para posteriormente pedirle que sea el resultado del producto de los valores de los dados de doce caras
	private int objetivo=0;

	//Variable integer para hacer de sem�foro entre el dado y el s�mbolo
	private int tocaDado=0;
	
	//Sem�foro par�ntesis
	private boolean parentesisCerrado=true;
	
	//Variable String para acumular la operaci�n que vamos haciendo
	private String operacion="";
	
	//Variable int para controlar el n�mero de s�mbolos que introducimos (no puede haber m�s de 5)
	private int nSimbolos=0;
	
	
    //Constructor ventana
	public JuegoExperto() {
		
		setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(JuegoPrincipiante.class.getResource("/Imagenes/dado.png")));
		setTitle("MATH DICE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 720);
	
	
		//JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta de bienvenida 
		LabelBienvenidaExp = new JLabel("New Label");
		LabelBienvenidaExp.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		LabelBienvenidaExp.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBienvenidaExp.setBounds(10, 11, 964, 32);
		contentPane.add(LabelBienvenidaExp);
		
		//Etiqueta de primer dado de 12 caras
		LabelDado_12_1 = new JLabel("");
		LabelDado_12_1.setBounds(228, 75, 173, 173);
		contentPane.add(LabelDado_12_1);
		
		//Etiqueta de segundo dado de 12 caras
		LabelDado_12_2 = new JLabel("");
		LabelDado_12_2.setBounds(10, 75, 173, 173);
		contentPane.add(LabelDado_12_2);
		
		//Etiqueta para sacar por pantalla el objetivo
		LabelObjetivo = new JLabel("New Label");
		LabelObjetivo.setHorizontalAlignment(SwingConstants.CENTER);
		LabelObjetivo.setFont(new Font("Modern No. 20", Font.BOLD, 27));
		LabelObjetivo.setBounds(10, 259, 439, 89);
		contentPane.add(LabelObjetivo);
		
		//Etiqueta primer dado 3 caras
		LabelDado_3_1 = new JLabel("New label");
		LabelDado_3_1.setBounds(10, 359, 150, 150);
		contentPane.add(LabelDado_3_1);
		LabelDado_3_1.addMouseListener(new miBotonDado());
		
		//Etiqueta segundo dado 3 caras
		LabelDado_3_2 = new JLabel("New label");
		LabelDado_3_2.setBounds(170, 359, 150, 150);
		contentPane.add(LabelDado_3_2);
		LabelDado_3_2.addMouseListener(new miBotonDado());
		
		//Etiqueta tercer dado 3 caras
		LabelDado_3_3 = new JLabel("New label");
		LabelDado_3_3.setBounds(330, 359, 150, 150);
		contentPane.add(LabelDado_3_3);
		LabelDado_3_3.addMouseListener(new miBotonDado());
		
		//Etiqueta primer dado 6 caras
		LabelDado_6_1 = new JLabel("New label");
		LabelDado_6_1.setBounds(10, 520, 150, 150);
		contentPane.add(LabelDado_6_1);
		LabelDado_6_1.addMouseListener(new miBotonDado());
		
		//Etiqueta segundo dado 6 caras
		LabelDado_6_2 = new JLabel("New label");
		LabelDado_6_2.setBounds(170, 520, 150, 150);
		contentPane.add(LabelDado_6_2);
		LabelDado_6_2.addMouseListener(new miBotonDado());
		
		//Etiqueta tercer dado 6 caras
		LabelDado_6_3 = new JLabel("New label");
		LabelDado_6_3.setBounds(330, 520, 150, 150);
		contentPane.add(LabelDado_6_3);
		LabelDado_6_3.addMouseListener(new miBotonDado());
		
		//Bot�n para sumar en la operaci�n
		botonSuma = new JButton("+");
		botonSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tocaDado==1&&nSimbolos<5){
					JTextOperacion.setText(operacion=operacion+String.valueOf(" + "));
					tocaDado=0;
					nSimbolos++;//Suma uno a la variable nSimbolos para contabilizarlos y que no se llegue a m�s de 4
					}
			}
		});
		botonSuma.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		botonSuma.setBounds(531, 55, 80, 80);
		contentPane.add(botonSuma);

		//Bot�n para restar en la operaci�n
		botonResta = new JButton("-");
		botonResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tocaDado==1&&nSimbolos<5){
					JTextOperacion.setText(operacion=operacion+String.valueOf(" - "));
					tocaDado=0;
					nSimbolos++;//Suma uno a la variable nSimbolos para contabilizarlos y que no se llegue a m�s de 4
					}
			}
		});
		botonResta.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		botonResta.setBounds(707, 54, 80, 80);
		contentPane.add(botonResta);
		
		//Bot�n para multiplicar en la operaci�n
		botonProducto = new JButton("*");
		botonProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tocaDado==1&&nSimbolos<5){
					JTextOperacion.setText(operacion=operacion+String.valueOf(" * "));
					tocaDado=0;
					nSimbolos++;//Suma uno a la variable nSimbolos para contabilizarlos y que no se llegue a m�s de 4
					}
			}
		});
		botonProducto.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		botonProducto.setBounds(865, 54, 80, 80);
		contentPane.add(botonProducto);
		
		//Bot�n para dividir en la operaci�n
		botonDivision = new JButton("/");
		botonDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tocaDado==1&&nSimbolos<5){
					JTextOperacion.setText(operacion=operacion+String.valueOf(" / "));
					tocaDado=0;
					nSimbolos++;//Suma uno a la variable nSimbolos para contabilizarlos y que no se llegue a m�s de 4
					}
			}
		});
		botonDivision.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		botonDivision.setBounds(531, 158, 80, 80);
		contentPane.add(botonDivision);
		
		//Bot�n para abrir un par�ntesis en la operaci�n
		botonParentesis = new JButton("(");
		botonParentesis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (parentesisCerrado==true && tocaDado==0){
					JTextOperacion.setText(operacion=operacion+String.valueOf(" ( "));
					parentesisCerrado=false;
					tocaDado=0;
					}
					}
		});
		botonParentesis.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		botonParentesis.setBounds(707, 157, 80, 80);
		contentPane.add(botonParentesis);

		//Bot�n para cerrar un par�ntesis en la operaci�n
		botonParentesisCierre = new JButton(")");
		botonParentesisCierre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (tocaDado==1 && parentesisCerrado==false ){
					JTextOperacion.setText(operacion=operacion+String.valueOf(" ) "));
					parentesisCerrado=true;
					tocaDado=1;
					}
					}
		});
		botonParentesisCierre.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		botonParentesisCierre.setBounds(865, 157, 80, 80);
		contentPane.add(botonParentesisCierre);
		

		//Etiqueta puntuaci�n total
		LabelPuntuacion = new JLabel("");
		LabelPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPuntuacion.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		LabelPuntuacion.setBounds(535, 520, 410, 40);
		contentPane.add(LabelPuntuacion);
		
		//JTextField d�nde recogeremos tanto los n�meros como los s�mbolos de las operaciones
		JTextOperacion = new JTextField();
		JTextOperacion.setFont(new Font("Modern No. 20", Font.PLAIN, 30));
		JTextOperacion.setBackground(new Color(255, 255, 153));
		JTextOperacion.setForeground(Color.BLACK);
		JTextOperacion.setEditable(false);
		JTextOperacion.setBounds(534, 248, 411, 57);
		contentPane.add(JTextOperacion);
		JTextOperacion.setColumns(10);
		JTextOperacion.setText(operacion);
		
		//Bot�n de comprobaci�n MATHDICE
		ButtonMathdice = new JButton("MATHDICE");
		ButtonMathdice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
						//M�todo para transformar String de una operaci�n en un valor int
						    ScriptEngineManager mgr = new ScriptEngineManager();
						    ScriptEngine engine = mgr.getEngineByName("JavaScript");
						    try {
								int i = ((Integer) (engine.eval(operacion))).intValue();//El objeto generado por las clases importadas lo pasamos a un int
								if (i==objetivo){
									LabelResultado.setText("Eres una m�quina");//Texto de confirmaci�n
									player1.setPuntos(player1.getPuntos()+5);//A�adimos 5 puntos a los puntos de player1
									LabelPuntuacion.setText("Puntuaci�n total: "+player1.getPuntos()+" puntos.");//Sacamos por la etiqueta los puntos que lleva acumulados player1
									ButtonMathdice.setEnabled(false);//Deshabilitamos bot�n mathdice
									btnReset.setEnabled(true);//Habilitamos bot�n reset
									player1.setSeguidos(player1.getSeguidos()+1);
									if(player1.getSeguidos()>1)
									LabelAciertosSeguidos.setText("Enhorabuena, llevas "+player1.getSeguidos()+" aciertos seguidos.");
								}else if  (i>objetivo && i<objetivo+(objetivo*0.10) || i<objetivo && i>objetivo-(objetivo*0.10)){
									LabelResultado.setText("Casiiiiiiiiii");//Texto de confirmaci�n
									player1.setPuntos(player1.getPuntos()+3);//A�adimos 5 puntos a los puntos de player1
									LabelPuntuacion.setText("Puntuaci�n total: "+player1.getPuntos()+" puntos.");//Sacamos por la etiqueta los puntos que lleva acumulados player1
									ButtonMathdice.setEnabled(false);//Deshabilitamos bot�n mathdice
									btnReset.setEnabled(true);//Habilitamos bot�n reset
									player1.setSeguidos(0);
									LabelAciertosSeguidos.setText("");
								}else{
									LabelResultado.setText("Sigue buscando");
									btnReset.setEnabled(true);//Habilitamos bot�n reset
									ButtonMathdice.setEnabled(false);//Deshabilitamos bot�n mathdice
									player1.setSeguidos(0);
									LabelAciertosSeguidos.setText("");
								}
							} catch (ScriptException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								LabelResultado.setText("Error al introducir datos");
								btnReset.setEnabled(true);//Habilitamos bot�n reset
								ButtonMathdice.setEnabled(false);//Deshabilitamos bot�n mathdice
							}
					}
					});
		ButtonMathdice.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		ButtonMathdice.setBounds(535, 329, 411, 57);
		contentPane.add(ButtonMathdice);
		
		
		//Bot�n para volver a jugar
		btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Reseteamos todos los valores que intervienen en la ventana como al inicio
				valor12_1 = (int) (Math.round(Math.random() *(1-12)+12));//Vuelve a generar un valor para el dado12
				valor12_2 = (int) (Math.round(Math.random() *(1-12)+12));//Vuelve a generar un valor para el dado12_2
				AsignarValor();//Se generan valores para los dados de tres y seis caras
				AsignarImagen();//Se sacan las respectivas im�genes en las etiquetas
				sacarObjetivo();
				nSimbolos=0;//Se resetean sem�foros
				tocaDado=0;
				operacion="";//Se resetea la operaci�n
				JTextOperacion.setText(operacion);
				LabelDado_3_1.setEnabled(true);
				LabelDado_3_2.setEnabled(true);
				LabelDado_3_3.setEnabled(true);
				LabelDado_6_1.setEnabled(true);
				LabelDado_6_2.setEnabled(true);
				LabelDado_6_3.setEnabled(true);
				btnReset.setEnabled(false);//Se dejan los botones como al principio
				ButtonMathdice.setEnabled(true);

			}
		});
		btnReset.setEnabled(false);
		btnReset.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		btnReset.setBounds(535, 407, 411, 57);
		contentPane.add(btnReset);
		
		//Etiqueta para sacar resultado obtenido
		LabelResultado = new JLabel("");
		LabelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		LabelResultado.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		LabelResultado.setBounds(593, 479, 301, 40);
		contentPane.add(LabelResultado);
		
		LabelAciertosSeguidos = new JLabel("");
		LabelAciertosSeguidos.setHorizontalAlignment(SwingConstants.CENTER);
		LabelAciertosSeguidos.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		LabelAciertosSeguidos.setBounds(535, 579, 410, 40);
		contentPane.add(LabelAciertosSeguidos);
		
		//Instancia de la clase Instrucciones para crear ventana de instrucciones
		vInsE=new InstruccionesExperto ();
		
		//Etiqueta acceso a ventana instrucciones
		LabelInterrogante = new JLabel("New label");
		LabelInterrogante.setBounds(0, 0, 58, 57);
		contentPane.add(LabelInterrogante);
		LabelInterrogante.setIcon(new ImageIcon(JuegoPrincipiante.class.getResource("/Imagenes/interrogante.png")));
		//Listener para acceder a la ventana de instrucciones del modo experto (vInsE)
		LabelInterrogante.addMouseListener(
				new MouseAdapter(){
					@Override
				public void mousePressed(MouseEvent arg0){
						vInsE.setVisible(true);
					}
				}
		);
		//Ejecuci�n del m�todo InicarArrays
		AsignarValor();
		
		//Ejecuci�n del m�todo SacarImagen
		AsignarImagen();
		
		//Ejecuci�n del m�todo sacarObjetivo
		sacarObjetivo();

		
	}

	//IMPLEMENTACI�N DE INNER CLASS PARA OPTIMIZAR C�DIGO
		private class miBotonDado implements MouseListener {

			//Formato que tiene que aparecer en una inner class de un mouseListener
			@Override
			public void mouseClicked(MouseEvent arg0) {}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			//MouseListener que vamos a utilizar
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (tocaDado==0){
					JLabel b=(JLabel)arg0.getSource();
					JTextOperacion.setText(operacion=operacion+(b.getName()));
					b.setIcon(dado_gris);
					tocaDado=1;
					b.setEnabled(false);
					b.removeMouseListener(this);
				}
			}	
		}
	//Setter de puntos y nombres del objeto player1 de la clase Jugador
	public void setJugador (Jugador player1) {
			this.player1=player1;
			LabelBienvenidaExp.setText("Hola "+player1.getNombre()+" bienvenid@ a Math Dice.");
				
	}


	//M�todo para multiplicar los valores de los dos dados de doce caras y asignar objetivo
	public void sacarObjetivo(){
		objetivo=valor12_1*valor12_2;
		LabelObjetivo.setText("Objetivo = "+objetivo);
		
	}
	//Metodo a trav�s de arrays sacar valor diferentes dados
	public void AsignarValor(){
		
		for(int i=0;i<valor_3caras.length;i++){
			valor_3caras[i]= (int) (Math.round(Math.random() *(1-3)+3));
		}
		for(int i=0;i<valor_6caras.length;i++){
			valor_6caras[i]= (int) (Math.round(Math.random() *(1-6)+6));
		}
		/*+ A TRAV�S DE UN setName LE DOY EL VALOR A CADA IMAGEN QUE HEMOS SACADO CON EL RANDOM
		 * 
		 */
		LabelDado_3_1.setName(String.valueOf(valor_3caras[0]));
		LabelDado_3_2.setName(String.valueOf(valor_3caras[1]));
		LabelDado_3_3.setName(String.valueOf(valor_3caras[2]));
		LabelDado_6_1.setName(String.valueOf(valor_6caras[0]));
		LabelDado_6_2.setName(String.valueOf(valor_6caras[1]));
		LabelDado_6_3.setName(String.valueOf(valor_6caras[2]));
	}

	//Inicio del m�todo para asignar una imagen a cada valor
	public void AsignarImagen(){
		
		//Primer dado de tres caras
        if (valor_3caras[0] == 1) {
            dado3_1 = new ImageIcon(getClass().getResource("/Imagenes/dado1_3.png"));
        } else if (valor_3caras[0] == 2) {
            dado3_1 = new ImageIcon(getClass().getResource("/Imagenes/dado2_3.png"));
        } else if (valor_3caras[0] == 3) {
            dado3_1 = new ImageIcon(getClass().getResource("/Imagenes/dado3_3.png"));
        } 
        LabelDado_3_1.setIcon(dado3_1);
        
        //Segundo dado de tres caras
        if (valor_3caras[1] == 1) {
            dado3_2 = new ImageIcon(getClass().getResource("/Imagenes/dado1_3.png"));
        } else if (valor_3caras[1] == 2) {
            dado3_2 = new ImageIcon(getClass().getResource("/Imagenes/dado2_3.png"));
        } else if (valor_3caras[1] == 3) {
            dado3_2 = new ImageIcon(getClass().getResource("/Imagenes/dado3_3.png"));
        } 
        LabelDado_3_2.setIcon(dado3_2);
        
        //Tercer dado de tres caras
        if (valor_3caras[2] == 1) {
            dado3_3 = new ImageIcon(getClass().getResource("/Imagenes/dado1_3.png"));
        } else if (valor_3caras[2] == 2) {
            dado3_3 = new ImageIcon(getClass().getResource("/Imagenes/dado2_3.png"));
        } else if (valor_3caras[2] == 3) {
            dado3_3 = new ImageIcon(getClass().getResource("/Imagenes/dado3_3.png"));
        } 
        LabelDado_3_3.setIcon(dado3_3);
        
        //Primer dado de seis caras
        if (valor_6caras[0] == 1) {
            dado6_1 = new ImageIcon(getClass().getResource("/Imagenes/dado1_6.png"));
        } else if (valor_6caras[0] == 2) {
        	dado6_1 = new ImageIcon(getClass().getResource("/Imagenes/dado2_6.png"));
        } else if (valor_6caras[0] == 3) {
        	dado6_1 = new ImageIcon(getClass().getResource("/Imagenes/dado3_6.png"));
        } else if (valor_6caras[0] == 4) {
        	dado6_1 = new ImageIcon(getClass().getResource("/Imagenes/dado4_6.png"));
        } else if (valor_6caras[0] == 5) {
        	dado6_1 = new ImageIcon(getClass().getResource("/Imagenes/dado5_6.png"));
        } else if (valor_6caras[0] == 6) {
        	dado6_1 = new ImageIcon(getClass().getResource("/Imagenes/dado6_6.png"));
        } 
        LabelDado_6_1.setIcon(dado6_1);
        
        //Segundo dado de seis caras
        if (valor_6caras[1] == 1) {
            dado6_2 = new ImageIcon(getClass().getResource("/Imagenes/dado1_6.png"));
        } else if (valor_6caras[1] == 2) {
        	dado6_2 = new ImageIcon(getClass().getResource("/Imagenes/dado2_6.png"));
        } else if (valor_6caras[1] == 3) {
        	dado6_2 = new ImageIcon(getClass().getResource("/Imagenes/dado3_6.png"));
        } else if (valor_6caras[1] == 4) {
        	dado6_2 = new ImageIcon(getClass().getResource("/Imagenes/dado4_6.png"));
        } else if (valor_6caras[1] == 5) {
        	dado6_2 = new ImageIcon(getClass().getResource("/Imagenes/dado5_6.png"));
        } else if (valor_6caras[1] == 6) {
        	dado6_2 = new ImageIcon(getClass().getResource("/Imagenes/dado6_6.png"));
        } 
        LabelDado_6_2.setIcon(dado6_2);
        
        //Tercer dado de seis caras
        if (valor_6caras[2] == 1) {
            dado6_3 = new ImageIcon(getClass().getResource("/Imagenes/dado1_6.png"));
        } else if (valor_6caras[2] == 2) {
        	dado6_3 = new ImageIcon(getClass().getResource("/Imagenes/dado2_6.png"));
        } else if (valor_6caras[2] == 3) {
        	dado6_3 = new ImageIcon(getClass().getResource("/Imagenes/dado3_6.png"));
        } else if (valor_6caras[2] == 4) {
        	dado6_3 = new ImageIcon(getClass().getResource("/Imagenes/dado4_6.png"));
        } else if (valor_6caras[2] == 5) {
        	dado6_3 = new ImageIcon(getClass().getResource("/Imagenes/dado5_6.png"));
        } else if (valor_6caras[2] == 6) {
        	dado6_3 = new ImageIcon(getClass().getResource("/Imagenes/dado6_6.png"));
        } 
        LabelDado_6_3.setIcon(dado6_3);
        
        //Dado de doce caras
        if (valor12_1 == 1) {
            dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_1.png"));
        } else if (valor12_1 == 2) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_2.png"));
        } else if (valor12_1 == 3) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_3.png"));
        } else if (valor12_1 == 4) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_4.png"));
        } else if (valor12_1 == 5) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_5.png"));
        } else if (valor12_1 == 6) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_6.png"));
        } else if (valor12_1 == 7){
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_7.png"));
        } else if (valor12_1 == 8) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_8.png"));
        } else if (valor12_1 == 9) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_9.png"));
        } else if (valor12_1 == 10) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_10.png"));
        } else if (valor12_1 == 11) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_11.png"));
        } else if (valor12_1 == 12) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_12.png"));
        } 
        LabelDado_12_1.setIcon(dado12);
        
        //Dado de doce caras
        if (valor12_2 == 1) {
            dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_1.png"));
        } else if (valor12_2 == 2) {
        	dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_2.png"));
        } else if (valor12_2 == 3) {
        	dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_3.png"));
        } else if (valor12_2 == 4) {
        	dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_4.png"));
        } else if (valor12_2 == 5) {
        	dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_5.png"));
        } else if (valor12_2 == 6) {
        	dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_6.png"));
        } else if (valor12_2 == 7){
        	dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_7.png"));
        } else if (valor12_2 == 8) {
        	dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_8.png"));
        } else if (valor12_2 == 9) {
        	dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_9.png"));
        } else if (valor12_2 == 10) {
        	dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_10.png"));
        } else if (valor12_2 == 11) {
        	dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_11.png"));
        } else if (valor12_2 == 12) {
        	dado12_2 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_12.png"));
        } 
        LabelDado_12_2.setIcon(dado12_2);
	}
}
