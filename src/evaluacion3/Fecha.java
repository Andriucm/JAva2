package evaluacion3;

import java.io.Serializable;
import java.util.Objects;

public class Fecha implements Comparable<Fecha>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 362264919096923329L;
	private int dia;
	private int mes;
	private int a�o;

	// Constructor por defecto
	public Fecha() {
		this.dia = 1;
		this.mes = 1;
		this.a�o = 2020;
	}

// Contructor copia
	public Fecha(Fecha f) {
		this.dia = f.dia;
		this.mes = f.mes;
		this.a�o = f.a�o;
	}

	// Constructor con par�metros
	public Fecha(int dia, int mes, int a�o) {
		this.dia = dia;
		this.mes = mes;
		this.a�o = a�o;
	}

	// setters y getters
	public void setDia(int d) {
		dia = d;
	}

	public void setMes(int m) {
		mes = m;
	}

	public void setA�o(int a) {
		a�o = a;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getA�o() {
		return a�o;
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + a�o;
	}

	@Override
	public int hashCode() {
		return Objects.hash(a�o, dia, mes);
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
		return a�o == other.a�o && dia == other.dia && mes == other.mes;
	}

	@Override
	public int compareTo(Fecha other) {
		if (this.a�o > other.a�o) {
			return 1;
		} else if (this.a�o < other.a�o) {
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
