package Evaluacion2;

import java.io.Serializable;

public class Complejo implements Comparable<Complejo>, Serializable {
	/***
		 * 
		 */
	private static final long serialVersionUID = -677627610974076940L;
	// defino a clase de "Definicion"
//	Propiedades
	private double real;
	private double imag;

//	Construrctor por defecto de la clase
	public Complejo() {
		this.real = 0.0;
		this.imag = 0.0;
	}

//	Constructor con parametros
	// construrcotr copia
	public Complejo(Complejo c) {
		this.real = c.real;
		this.imag = c.imag;
	}

// Contrusctor personalizado
	public Complejo(double r, double i) {
		this.real = r;
		this.imag = i;
	}

//	Complejo 
	public Complejo(double r) {
		this.real = r;
		this.imag = 0.0;
	}

//métodos setters y getters
	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	// sumar dos números complejos
	// (a, b) + (c, d) = (a + c, b + d);
	public Complejo sumar(Complejo c) {
		Complejo aux = new Complejo();
		aux.real = real + c.real;
		aux.imag = imag + c.imag;
		return aux;
	}

	// restar dos números complejos
	// (a, b) - (c, d) = (a - c, b - d);
	public Complejo restar(Complejo c) {
		Complejo aux = new Complejo();
		aux.real = real - c.real;
		aux.imag = imag - c.imag;
		return aux;
	}

	// multiplicar dos números complejos
	// (a, b) * (c, d) = (a*c – b*d, a*d + b*c)
	public Complejo multiplicar(Complejo c) {
		Complejo aux = new Complejo();
		aux.real = real * c.real - imag * c.imag;
		aux.imag = real * c.imag + imag * c.real;
		return aux;
	}

	// multiplicar un número complejo por un número de tipo double
	// (a, b) * n = (a * n, b * n)
	public Complejo multiplicar(double n) {
		Complejo aux = new Complejo();
		aux.real = real * n;
		aux.imag = imag * n;
		return aux;
	}

	// dividir dos números complejos
	// (a, b) / (c, d) = ((a*c + b*d) / (c^2 + d^2) , (b*c – a*d) / (c^2 + d^2))
	public Complejo dividir(Complejo c) {
		Complejo aux = new Complejo();
		aux.real = (real * c.real + imag * c.imag) / (c.real * c.real + c.imag * c.imag);
		aux.imag = (imag * c.real - real * c.imag) / (c.real * c.real + c.imag * c.imag);
		return aux;
	}

	// método toString
	@Override
	public String toString() {
		return ("(" + real + ", " + imag + ")");
	}

	// método equals
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Complejo other = (Complejo) obj;
		if (this.real != other.real) {
			return false;
		}
		if (this.imag != other.imag) {
			return false;
		}
		return true;

	}

	@Override
	public int compareTo(Complejo other) {
		// Comparo las propiedades
		if (this.real > other.real) {
			return 1;
		} else if (this.real < other.real) {
			return -1;
//			si la parte real es igual
//			comparo la parte imaginaria
		} else {
			if (this.imag > other.imag) {
				return 1;
			} else if (this.imag < other.imag) {
				return -1;
			}
//			si los complejos son iguales
			return 0;
		}
	}

}
