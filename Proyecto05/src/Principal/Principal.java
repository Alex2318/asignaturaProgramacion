package Principal;

import Ventanas.Juego;
import Ventanas.Login;

public class Principal {

	public static void main(String[] args) {
		
		//Ventanas a utilizar
		Juego vJuego=new Juego();
		
		Login vLogin=new Login(vJuego);
		vLogin.setVisible(true);//Al darle a Run, hacemos viisible de salida la ventana Login.
		


	}

}
