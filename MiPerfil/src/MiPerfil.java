import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTable;

	//Nombre de la clase principal
public class MiPerfil extends JFrame {

	//Atributos con acceso private
	private JPanel contentPane;
	private JTextField cajaNombre;
	private JTextField cajaApellidos;
	private JTextField CajaEdad;
	private JTextField cajaEmail;

	/**
	 * Launch the application.
	 */
	//Función main, puerta de entrada para ejecutar nuestro código
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Objeto generado, de nombre frame
					MiPerfil frame = new MiPerfil();
					//Hacer visible el frame
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//Método
	public MiPerfil() {
		setTitle("Mi Perfil");
		
		//Configuración ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		//Configuración contenedor
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta nombre
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setBounds(10, 11, 49, 14);
		contentPane.add(etiquetaNombre);
		
		//Caja para poner el nombre
		cajaNombre = new JTextField();
		cajaNombre.setText("Alejandro");
		cajaNombre.setBounds(10, 36, 184, 20);
		contentPane.add(cajaNombre);
		cajaNombre.setColumns(10);
		
		//Etiqueta apellidos
		JLabel etiquetaApellidos = new JLabel("Apellidos");
		etiquetaApellidos.setBounds(10, 62, 75, 14);
		contentPane.add(etiquetaApellidos);
		
		//Caja para poner apellidos
		cajaApellidos = new JTextField();
		cajaApellidos.setText("Monchol\u00ED Berlanga");
		cajaApellidos.setBounds(10, 87, 184, 20);
		contentPane.add(cajaApellidos);
		cajaApellidos.setColumns(10);
		
		//Etiqueta edad
		JLabel etiquetaEdad = new JLabel("Edad");
		etiquetaEdad.setBounds(10, 128, 46, 14);
		contentPane.add(etiquetaEdad);
		
		//Caja para poner edad
		CajaEdad = new JTextField();
		CajaEdad.setText("31");
		CajaEdad.setBounds(10, 153, 184, 20);
		contentPane.add(CajaEdad);
		CajaEdad.setColumns(10);
		
		//Etiqueta email
		JLabel etiquetaEmail = new JLabel("Email");
		etiquetaEmail.setBounds(10, 197, 46, 14);
		contentPane.add(etiquetaEmail);
		
		//Caja para poner email
		cajaEmail = new JTextField();
		cajaEmail.setText("almobe@floridauniversitaria.es");
		cajaEmail.setBounds(10, 230, 184, 20);
		contentPane.add(cajaEmail);
		cajaEmail.setColumns(10);
	}
}
