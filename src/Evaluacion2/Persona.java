package Evaluacion2;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Comparable<Persona>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6672988941436964602L;
	// Atributos
	private String nombre, dni, apellido;
	private Fecha fechanacimiento;

//Constructor por defecto
	public Persona() {
		this.nombre = "";
		this.apellido = "";
		this.dni = "";
		this.fechanacimiento = new Fecha();

	}

//Constructor de copia
	public Persona(Persona persona) {
		this.nombre = persona.nombre;
		this.apellido = persona.apellido;
		this.dni = persona.dni;
		this.fechanacimiento = new Fecha(persona.fechanacimiento);

	}

public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Fecha getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Fecha fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	//	 Constructor personalizado
	public Persona(String nom, String apellido, String dni) {
		this.nombre = nom;
		this.apellido = apellido;
		this.dni = dni;
	}

//Constructor común
	public Persona( String dni, String nom, String apellido, Fecha fecha) {
		this.nombre = nom;
		this.apellido = apellido;
		this.dni = dni;
		this.fechanacimiento = new Fecha(fecha);
	}

	@Override
	public String toString() {
		return dni + " " + nombre + " " + apellido + " " + fechanacimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, fechanacimiento, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return (this.dni.equals(other.dni));
	}

	@Override
	public int compareTo(Persona other) {
	// Comparo las propiedades
			if (this.dni.compareTo(other.dni) > 0) {
				return 1;
			} else if (this.dni.compareTo(other.dni) < 0) {
				return -1;
				}
//				si los complejos son iguales
				return 0;
			}
	}


