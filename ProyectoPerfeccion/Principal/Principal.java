package Principal;

import Ventanas.Instrucciones;
import Ventanas.Juego;
import Ventanas.Login;

public class Principal {

	public static void main(String[] args) {
		
	

		//Ventanas a utilizar
		Instrucciones vIns=new Instrucciones();
		Juego vJuego=new Juego(vIns);
		

		
		Login vLogin=new Login(vJuego);
		vLogin.setVisible(true);
		
		
		


	}

}
