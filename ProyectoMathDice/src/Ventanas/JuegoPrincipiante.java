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

public class JuegoPrincipiante extends JFrame {

	//Definimos variables
	
	//ContentPane
	private JPanel contentPane;
	//Player1 de la clase jugador
	private Jugador player1;
	//Etiqueta bienvenida creada en el proyecto 05
	private JLabel LabelBienvenida;
	//Etiquetas para meter imágenes de dados
	private JLabel LabelDado_12;
	private JLabel LabelDado_3_1,LabelDado_3_2,LabelDado_3_3;
	private JLabel LabelDado_6_1,LabelDado_6_2;
	//Etiqueta para sacar puntuación obtenida
	private JLabel LabelPuntuacion;
	//Etiqueta donde saldrá la confirmación de que la operación está bien hecha
	private JLabel LabelResultado; 
	//JText dónde haremos las operaciones del juego
	private JTextField JTextOperacion;
	//Etiquetas suma y resta
	private JLabel LabelSuma, LabelResta;
	//Botón Mathdice
	private JButton ButtonMathdice;
	//Botón para resetear el juego
	private JButton btnReset;

	private Instrucciones vIns;

	//Diferentes imágenes
    private ImageIcon dado3_1 = null;
    private ImageIcon dado3_2 = null;
    private ImageIcon dado3_3 = null;
    private ImageIcon dado6_1 = null;
    private ImageIcon dado6_2 = null;
    private ImageIcon dado12 = null;
    private ImageIcon dado_gris=new ImageIcon (getClass().getResource("/Imagenes/dadogris.png"));
    //Arrays de los distintos dados para posteriorment sacar el valor 
    private int [] valor_3caras=new int [3];
    private int [] valor_6caras=new int [2];
    
    //Valor del dado de doce caras, producido por la función Math.random
    private int valor12 = (int) (Math.round(Math.random() *(1-12)+12));
    //(Math.random() *(mínimo-máximo)+máximo)
    
    //Variables booleanas para activar/desactivar listeners posteriormente
	private boolean mouseListenerIsActive=true;
	private boolean mouseListenerIsActive2=true;
	private boolean mouseListenerIsActive3=true;
	private boolean mouseListenerIsActive4=true;
	private boolean mouseListenerIsActive5=true;
	
	//Variable onteger para hacer de semáforo entre el dado y el símbolo
	private int tocaDado=0;
	
	//Variable String para acumular la operación que vamos haciendo
	private String operacion="";
	
	//Variable int para controlar el número de símbolos que introducimos (no pueden haber más de 4)
	private int nSimbolos=0;
	
	private int resultado;
	private JLabel LabelInterrogante;
    
	

    //Constructor ventana
	public JuegoPrincipiante() {
		
		setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(JuegoPrincipiante.class.getResource("/Imagenes/dado.png")));
		setTitle("MATH DICE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 620);
	
		
	
		//JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta de bienvenida 
		LabelBienvenida = new JLabel("New Label");
		LabelBienvenida.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		LabelBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBienvenida.setBounds(10, 11, 964, 32);
		contentPane.add(LabelBienvenida);
		
		//Etiqueta de dado de 12 caras
		LabelDado_12 = new JLabel("");
		LabelDado_12.setBounds(159, 75, 173, 173);
		contentPane.add(LabelDado_12);
		
		//Etiqueta primer dado 3 caras
		LabelDado_3_1 = new JLabel("New label");
		LabelDado_3_1.setBounds(10, 259, 150, 150);
		contentPane.add(LabelDado_3_1);
		LabelDado_3_1.addMouseListener(
				new MouseAdapter(){
					@Override
				public void mousePressed(MouseEvent arg0){
						if (mouseListenerIsActive && tocaDado==0){
						JTextOperacion.setText(operacion=operacion+String.valueOf(valor_3caras[0]));
						LabelDado_3_1.setIcon(dado_gris);
						tocaDado=1;
						mouseListenerIsActive = false;
						}
	            }
	        });
		
		//Etiqueta segundo dado 3 caras
		LabelDado_3_2 = new JLabel("New label");
		LabelDado_3_2.setBounds(170, 259, 150, 150);
		contentPane.add(LabelDado_3_2);
		LabelDado_3_2.addMouseListener(
				new MouseAdapter(){
					@Override
				public void mousePressed(MouseEvent arg0){
						if (mouseListenerIsActive2 && tocaDado==0){
						JTextOperacion.setText(operacion=operacion+String.valueOf(valor_3caras[1]));
						LabelDado_3_2.setIcon(dado_gris);
					    tocaDado=1;
					    mouseListenerIsActive2 = false;
						}
					}
			}
		);
		
		//Etiqueta tercer dado 3 caras
		LabelDado_3_3 = new JLabel("New label");
		LabelDado_3_3.setBounds(330, 259, 150, 150);
		contentPane.add(LabelDado_3_3);
		LabelDado_3_3.addMouseListener(
				new MouseAdapter(){
					@Override
				public void mousePressed(MouseEvent arg0){
						if (mouseListenerIsActive3 && tocaDado==0){
						JTextOperacion.setText(operacion=operacion+String.valueOf(valor_3caras[2]));
						LabelDado_3_3.setIcon(dado_gris);
						 tocaDado=1;
						 mouseListenerIsActive3 = false;
						}
					}
				}
		);
		
		//Etiqueta primer dado 6 caras
		LabelDado_6_1 = new JLabel("New label");
		LabelDado_6_1.setBounds(90, 420, 150, 150);
		contentPane.add(LabelDado_6_1);
		LabelDado_6_1.addMouseListener(
				new MouseAdapter(){
					@Override
				public void mousePressed(MouseEvent arg0){
						if (mouseListenerIsActive4 && tocaDado==0){
						JTextOperacion.setText(operacion=operacion+String.valueOf(valor_6caras[0]));
						LabelDado_6_1.setIcon(dado_gris);
						 tocaDado=1;
						 mouseListenerIsActive4 = false;
					}
					}
				}
		);
		
		//Etiqueta segundo dado 6 caras
		LabelDado_6_2 = new JLabel("New label");
		LabelDado_6_2.setBounds(251, 420, 150, 150);
		contentPane.add(LabelDado_6_2);
		LabelDado_6_2.addMouseListener(
				new MouseAdapter(){
					@Override
				public void mousePressed(MouseEvent arg0){
						if (mouseListenerIsActive5 && tocaDado==0){
						JTextOperacion.setText(operacion=operacion+String.valueOf(valor_6caras[1]));
						LabelDado_6_2.setIcon(dado_gris);
						tocaDado=1;
						mouseListenerIsActive5 = false;
						}
					}
				}
		);
		
		
		//Etiqueta puntuación total
		LabelPuntuacion = new JLabel("");
		LabelPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPuntuacion.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		LabelPuntuacion.setBounds(535, 530, 410, 40);
		contentPane.add(LabelPuntuacion);
		
		//Etiqueta símbolo suma
		LabelSuma = new JLabel("New label");
		LabelSuma.setIcon(new ImageIcon(JuegoPrincipiante.class.getResource("/Imagenes/suma.png")));
		LabelSuma.setBounds(535, 75, 150, 150);
		contentPane.add(LabelSuma);
		LabelSuma.addMouseListener(
				new MouseAdapter(){
					@Override
				public void mousePressed(MouseEvent arg0){
						if (tocaDado==1&&nSimbolos<4){
						JTextOperacion.setText(operacion=operacion+String.valueOf(" + "));
						tocaDado=0;
						nSimbolos++;//Suma uno a la variable nSimbolos para contabilizarlos y que no se llegue a más de 4
						}
					}
				}
		);
		
		
		//Etiqueta símbolo resta
		LabelResta = new JLabel("New label");
		LabelResta.setIcon(new ImageIcon(JuegoPrincipiante.class.getResource("/Imagenes/resta.png")));
		LabelResta.setBounds(795, 75, 150, 150);
		contentPane.add(LabelResta);
		LabelResta.addMouseListener(
				new MouseAdapter(){
					@Override
				public void mousePressed(MouseEvent arg0){
						if (tocaDado==1&&nSimbolos<4){
						JTextOperacion.setText(operacion=operacion+String.valueOf(" - "));
						tocaDado=0;
						nSimbolos++;//Suma uno a la variable nSimbolos para contabilizarlos y que no se llegue a más de 4
						}
					}
				}
		);
		
		//JTextField dónde recogeremos tanto los número como los símbolos de las operaciones
		JTextOperacion = new JTextField();
		JTextOperacion.setFont(new Font("Modern No. 20", Font.PLAIN, 30));
		JTextOperacion.setBackground(new Color(255, 255, 153));
		JTextOperacion.setForeground(Color.BLACK);
		JTextOperacion.setEditable(false);
		JTextOperacion.setBounds(534, 248, 411, 57);
		contentPane.add(JTextOperacion);
		JTextOperacion.setColumns(10);
		JTextOperacion.setText(operacion);
		
		//Botón de comprobación MATHDICE
		ButtonMathdice = new JButton("MATHDICE");
		ButtonMathdice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					//Método para transformar String de una operación en un valor int
					    ScriptEngineManager mgr = new ScriptEngineManager();
					    ScriptEngine engine = mgr.getEngineByName("JavaScript");
					    try {
							int i = ((Integer) (engine.eval(operacion))).intValue();//El objeto generado por las clases importadas lo pasamos a un int
							if (i==valor12){
								LabelResultado.setText("Eres una máquina");//Texto de confirmación
								player1.setPuntos(player1.getPuntos()+5);//Añadimos 5 puntos a los puntos de player1
								LabelPuntuacion.setText("Puntuación total: "+player1.getPuntos()+" puntos.");//Sacamos por la etiqueta los puntos que lleva acumulados player1
								ButtonMathdice.setEnabled(false);//Deshabilitamos botón mathdice
								btnReset.setEnabled(true);//Habilitamos botón reset
							}else{
								LabelResultado.setText("Sigue buscando");
								btnReset.setEnabled(true);//Habilitamos botón reset
								ButtonMathdice.setEnabled(false);//Deshabilitamos botón mathdice
							}
						} catch (ScriptException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					});
		ButtonMathdice.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		ButtonMathdice.setBounds(535, 329, 411, 57);
		contentPane.add(ButtonMathdice);
		
		//Botón para volver a jugar
		btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Reseteamos todos los valores que intervienen en la ventana como al inicio
				valor12 = (int) (Math.round(Math.random() *(1-12)+12));//Vuelve a generar un valor para el dado12
				IniciarArrays();//Se generan valores para los dados de tres y seis caras
				SacarImagen();//Se sacan las respectivas imágenes en las etiquetas
				nSimbolos=0;//Se resetean semáforos
				tocaDado=0;
				operacion="";//Se resetea la operación
				JTextOperacion.setText(operacion);
				mouseListenerIsActive=true;//Se vuelven a activar todos los mouseListeners
				mouseListenerIsActive2=true;
				mouseListenerIsActive3=true;
				mouseListenerIsActive4=true;
				mouseListenerIsActive5=true;
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
		
		//Instancia de la clase Instrucciones para crear ventana de instrucciones
		vIns=new Instrucciones ();
		
		//Etiqueta acceso a ventana instrucciones
		LabelInterrogante = new JLabel("New label");
		LabelInterrogante.setBounds(0, 0, 58, 57);
		contentPane.add(LabelInterrogante);
		LabelInterrogante.setIcon(new ImageIcon(JuegoPrincipiante.class.getResource("/Imagenes/interrogante.png")));
		LabelInterrogante.addMouseListener(
				new MouseAdapter(){
					@Override
				public void mousePressed(MouseEvent arg0){
						vIns.setVisible(true);
					}
				}
		);
		//Ejecución del método InicarArrays
		IniciarArrays();
		
		//Ejecución del método SacarImagen
		SacarImagen();
	
		trucarImpar();
	}



	//Setter de puntos y nombres del objeto player1 de la clase Jugador
	public void setJugador (Jugador player1) {
		this.player1=player1;
		LabelBienvenida.setText("Hola "+player1.getNombre()+" bienvenid@ a Math Dice.");
		
	}
	
	//Metodo a través de arrays sacar valor diferentes dados
	public void IniciarArrays(){
		
		for(int i=0;i<valor_3caras.length;i++){
			valor_3caras[i]= (int) (Math.round(Math.random() *(1-3)+3));
		}
		for(int i=0;i<valor_6caras.length;i++){
			valor_6caras[i]= (int) (Math.round(Math.random() *(1-6)+6));
		}
	}
	
	public void trucarImpar(){
		if (valor12%2 != 0 && valor_3caras[0]%2==0 && valor_3caras[1]%2==0 && valor_3caras[2]%2==0 && 
				valor_6caras[0]%2==0 ){

					    if(valor_6caras[1]%2 ==0)
					    {
					          if(valor_6caras[1]==6) {
					        	  valor_6caras[1] = valor_6caras[1] - 1;  
					          }else{
					        	  valor_6caras[1] = valor_6caras[1] +1;
					          }
					    }
		}
	}
	
	//Inicio dedl método para asignar una imagen a cada valor
	public void SacarImagen(){
		
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
        
        //Dado de doce caras
        if (valor12 == 1) {
            dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_1.png"));
        } else if (valor12 == 2) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_2.png"));
        } else if (valor12 == 3) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_3.png"));
        } else if (valor12 == 4) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_4.png"));
        } else if (valor12 == 5) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_5.png"));
        } else if (valor12 == 6) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_6.png"));
        } else if (valor12 == 7){
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_7.png"));
        } else if (valor12 == 8) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_8.png"));
        } else if (valor12 == 9) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_9.png"));
        } else if (valor12 == 10) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_10.png"));
        } else if (valor12 == 11) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_11.png"));
        } else if (valor12 == 12) {
        	dado12 = new ImageIcon(getClass().getResource("/Imagenes/dadodoce_12.png"));
        } 
        LabelDado_12.setIcon(dado12);
        
	}
}
