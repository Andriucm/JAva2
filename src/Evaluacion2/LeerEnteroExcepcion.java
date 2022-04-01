package Evaluacion2;

import java.util.Scanner;

public class LeerEnteroExcepcion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		lee un string por teclado
//		lo muestra por pantalla
		String valor;
		int n;
//		defino un objeto de la clase scanner
		Scanner teclado;
//		cre un nuevo eobjeto de la clase scanner
		teclado = new Scanner(System.in);

		try {

//		leo valor
			System.out.println("introduce un numero entero: ");
			valor = teclado.nextLine();
//	lo convierto en entero
			n = Integer.parseInt(valor);

//		lo muestra por pantalla
			System.out.println("El calor de la variable es " + n);
		} catch (NumberFormatException e) {
			System.out.println("Se ha producido un error al leer el numero");
		}
//		libero la memoria de taclado
		teclado.close();
	}

}
