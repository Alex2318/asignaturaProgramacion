import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;

public class BailandoTexto extends JFrame {

	private JPanel contentPane;
	private JTextField CampoTextoIzquierda;
	private JTextField CampoTextoDerecha;

	/**
	 * PUNTO DE ENTRADA A NUESTRA APP.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BailandoTexto frame = new BailandoTexto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * CONFIGURACIÓN DE LA VENTANA.
	 */
	public BailandoTexto() {
		setTitle("Bailando Texto");
		//MARCO Y CONTENIDO
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//CAJA IZQUIERDA
		CampoTextoIzquierda = new JTextField();
		CampoTextoIzquierda.setBounds(10, 108, 118, 20);
		contentPane.add(CampoTextoIzquierda);
		CampoTextoIzquierda.setColumns(10);
		
		//CAJA DERECHA
		CampoTextoDerecha = new JTextField();
		CampoTextoDerecha.setBounds(306, 108, 118, 20);
		contentPane.add(CampoTextoDerecha);
		CampoTextoDerecha.setColumns(10);
		
		//BOTÓN ARRIBA PASA DE IZQUIERDA A DERECHA
		JButton BotonArriba = new JButton("----------->");
		//LISTENER+EVENTO
		//-------
		BotonArriba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//COGER TEXTO DE LA CAJA DE LA IZQUIERDA Y PASARLO A LA CAJA DE LA DERECHA
				CampoTextoDerecha.setText(CampoTextoIzquierda.getText());
				//DEJAR LA CAJA DE LA IZQUERDA EN BLANCO
				CampoTextoIzquierda.setText("");
			}
		});
		//-------
		BotonArriba.setBounds(165, 47, 89, 23);
		contentPane.add(BotonArriba);
		
		//BOTÓN ABAJO PASA DE DERECHA A IZQUIERDA
		JButton BotonAbajo = new JButton("<-----------");
		//LISTENER+EVENTO
		//-------
		BotonAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//COGER TEXTO DE CAJA DE LA DERECHA Y PASARLO A LA CAJA DE LA IZQUIERDA
				CampoTextoIzquierda.setText(CampoTextoDerecha.getText());
				//DEJAR LA CAJA DERECHA EN BLANCO
				CampoTextoDerecha.setText("");
			}
		});
		//-------
		BotonAbajo.setBounds(165, 179, 89, 23);
		contentPane.add(BotonAbajo);
		
	}
}
