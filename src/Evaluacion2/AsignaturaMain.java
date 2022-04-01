package Evaluacion2;

public class AsignaturaMain {

	public static void main(String[] args) {
		// Defino la clase de "Ejecucion"
		//Constructores
		// Constructores por defecto
		Asignatura a1 = new Asignatura();
	// Constructor Copia
		Asignatura a2 = new Asignatura(a1);
		// Constructor Pers
		Asignatura a3 = new Asignatura("X1", "Examen", 0.2);
	}

}
