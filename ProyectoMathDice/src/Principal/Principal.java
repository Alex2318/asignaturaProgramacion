package Principal;

import Ventanas.Instrucciones;
import Ventanas.JuegoExperto;
import Ventanas.JuegoPrincipiante;
import Ventanas.Login;

public class Principal {

	public static void main(String[] args) {
		
	

		//Ventanas a utilizar

	    JuegoPrincipiante vJuego=new JuegoPrincipiante();
		
		JuegoExperto vExperto=new JuegoExperto();

		
		Login vLogin=new Login(vJuego, vExperto);
		vLogin.setVisible(true);
		

		


	}

}
