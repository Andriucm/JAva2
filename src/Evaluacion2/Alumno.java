package Evaluacion2;

public class Alumno extends Persona {

	// Atributos
	private String grupo;

	public Alumno() {
		super();
		this.grupo = "";
	}

	public Alumno(Alumno alumno) {
		this.grupo = alumno.grupo;
	}

	public Alumno(String grupo) {
		this.grupo = grupo;
	}

}
