package Evaluacion2;

import java.util.Objects;

public class Racional implements Comparable<Racional> {
//	defino la clase de "Definicion"
//	Popiedades
	private int numerador;
	private int denominador;

//	Constructores
//Constructores por defecto
	public Racional() {
		this.numerador = 0;
		this.denominador = 1;
	}

//	Constructor Copia
	public Racional(Racional r) {
		this.numerador = r.numerador;
		this.denominador = r.denominador;
	}

//Contructores personalizados
	public Racional(int n, int d) {
		this.numerador = n;
		this.denominador = d;
	}

	public Racional(int i) {
		this.numerador = i;
		this.denominador = 1;

	}

//Obtener o cambiar valores de las propiedades
//Getters and Setters
	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		if (denominador != 0) {
			this.denominador = denominador;
		}
	}

	// toString
	@Override
	public String toString() {
		return (numerador + "/" + denominador);
	}

	@Override
	public int hashCode() {
		return Objects.hash(denominador, numerador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
//			si es el mismo objeto
			return true;
		if (obj == null)
//			si el objeto obj es de otra Clase diferente
			return false;
		if (getClass() != obj.getClass())
			return false;
//		Comparo las propiedades
		Racional other = (Racional) obj;
		if (this.numerador * other.denominador == this.denominador * other.numerador) {
			return true;
		}
		return false;

	}

	@Override
	public int compareTo(Racional other) {
		if (this.numerador * other.denominador > this.denominador * other.numerador) {
//			SI EL DE LA IZQ ES MAYOR
			return 1;
			
		} else if (this.numerador * other.denominador < this.denominador * other.numerador) {
//		SI EL DE LA IZQ ES MENOS
			return -1;
		} else {
//		SI AMBOS LADOS SON IGUALES
			return 0;
		}

	}

}
