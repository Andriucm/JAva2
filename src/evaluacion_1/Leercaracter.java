package evaluacion_1;

import java.util.Scanner;

public class Leercaracter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Leer un caracter por teclado y mostrar por pantalla.
		
		char c;
		
		//defino un objeto de la clase scanner..
		Scanner teclado;
		
		//Creo un objeto nuevo  de la clse scanner.
		teclado = new Scanner(System.in);
		
		//leo c.
		System.out.println("Introuce un caracter: ");
		c=teclado.nextLine().charAt(0);
		
		//Libero la memoria del  teclado.
		teclado.close();
		
		//Lo muestro por pantalla.
		System.out.print("El caracter introducido es: "+c);
		

	}

}
