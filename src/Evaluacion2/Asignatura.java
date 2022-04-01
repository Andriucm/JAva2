package Evaluacion2;

import java.util.Objects;

public class Asignatura implements Comparable<Asignatura> {
// Propiedades
	private String codigo, descripcion;
	private double nota;

//	Constructor Por defecto
	public Asignatura() {
		this.codigo = "";
		this.descripcion = "";
		this.nota = 0.0;
	}

// Constructor Copia
	public Asignatura(Asignatura a) {
		this.codigo = a.codigo;
		this.descripcion = a.descripcion;
		this.nota = a.nota;
	}

	// Constructor Pers
	public Asignatura(String c, String d, double n) {
		this.codigo = c;
		this.descripcion = d;
		this.nota = n;

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, descripcion, nota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return (this.codigo.equals(other.codigo) && this.nota == other.nota);
	}

	@Override
	public int compareTo(Asignatura other) {
		int comparacion = this.codigo.compareTo(other.codigo);
		if (comparacion == 0) {
			Double n1 = this.nota;
			Double n2 = other.nota;
			comparacion = n1.compareTo(n2);
		}
		return (comparacion);
	}

	@Override
	public String toString() {
		return codigo + ", " + descripcion + ", " + nota;
	}

}
