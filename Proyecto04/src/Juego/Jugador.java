package Juego;

public class Jugador {
	
	//Atributos de la clase jugador
	private String nombre;
	private String apellidos;
	private int puntos;
	private int edad;
	private int id;
	
	//Getters y setters de los atributos de la clase
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	


	//M�todo para comprobar que lo que se ingresa en Edad es un n�mero
	public boolean isNumeric(String cadena){//Si hay una cadena de caracteres...
		try{
			Integer.parseInt(cadena);//...lo convierte a un int...
			return true;//...y te devuelve true
		}catch (NumberFormatException nfe){//Si hay una excepci�n...
			return false;//...te devuelve false.
		}
	}

	
	}
	
	

