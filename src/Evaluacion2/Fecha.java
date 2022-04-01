package Evaluacion2;

import java.io.Serializable;
import java.util.Objects;

public class Fecha implements Comparable<Fecha>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 362264919096923329L;
	private int dia;
	private int mes;
	private int año;

	// Constructor por defecto
	public Fecha() {
		this.dia = 1;
		this.mes = 1;
		this.año = 2020;
	}

// Contructor copia
	public Fecha(Fecha f) {
		this.dia = f.dia;
		this.mes = f.mes;
		this.año = f.año;
	}

	// Constructor con parámetros
	public Fecha(int dia, int mes, int año) {
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}

	// setters y getters
	public void setDia(int d) {
		dia = d;
	}

	public void setMes(int m) {
		mes = m;
	}

	public void setAño(int a) {
		año = a;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAño() {
		return año;
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + año;
	}

	@Override
	public int hashCode() {
		return Objects.hash(año, dia, mes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		return año == other.año && dia == other.dia && mes == other.mes;
	}

	@Override
	public int compareTo(Fecha other) {
		if (this.año > other.año) {
			return 1;
		} else if (this.año < other.año) {
			return -1;
		} else {
			if (this.mes > other.mes) {
				return 1;
			} else if (this.mes < other.mes) {
				return -1;
			} else {
				if (this.dia > other.dia) {
					return 1;
				} else if (this.dia < other.dia) {
					return -1;
				}

			}
		}
		return 0;
	}
}
