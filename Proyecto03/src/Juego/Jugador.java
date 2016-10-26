package Juego;

public class Jugador {
	//Atributos de la clase jugador
	private String nombre;
	private String apellidos;
	private int puntos;
	private int edad;
	private int id;
	
	
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	
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
	public String toString(){
		return this.nombre+" "+this.apellidos+" de "+this.edad+" años.";
	}

}
