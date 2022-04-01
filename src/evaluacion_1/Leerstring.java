package evaluacion_1;

import java.util.Scanner;

public class Leerstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Leer un string por teclado y mostrar por pantalla.
		
		String s;
		
		//defino un objeto de la clase scanner..
		Scanner teclado;
		
		//Creo un objto nuevo  de la clse scanner.
		teclado = new Scanner(System.in);
		
		//leo s.
		System.out.println("Introuce un string: ");
		s=teclado.nextLine();
		
		//Libero la memoria del  teclado.
		teclado.close();
		
		//Lo muestro por pantalla.
		System.out.print("La cadena introducida es: "+s);
		

	}

}
