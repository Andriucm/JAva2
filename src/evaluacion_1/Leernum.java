package evaluacion_1;

import java.util.Scanner;

public class Leernum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Leer numero por teclado y mostrar por pantalla.
		
		int n;
		
		//defino un objeto de la clase scanner..
		Scanner teclado;
		
		//Creo un objto nuevo  de la clse scanner.
		teclado = new Scanner(System.in);
		
		//leo n.
		System.out.println("Introuce un numero entero: ");
		n=teclado.nextInt();
		
		//Libero la memoria del  teclado.
		teclado.close();
		
		//Lo muestro por pantalla.
		System.out.print("La variable introducida es: "+n);
		

	}

}
