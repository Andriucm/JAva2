package evaluacion_1;

import java.util.Scanner;

public class PrimoCub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Variables
		boolean esprimo;
		int cubo;
		int n;
		int cont;
		//Defino clase scanner
		Scanner teclado;
		//Creo ojeto scaner
		teclado = new Scanner (System.in);
		
		//Lee variable
		System.out.println("Introduce un número:");
		n =teclado.nextInt();
		
		
		
		//CODIGO
		while (n > 0) {
			if ((n % 2)==0) {
				cubo = n *n *n;
				System.out.println("El cubo de " +n+ " es " +cubo);
				}
			else {
				esprimo = true;
				cont = 3;
				while ((cont <  n) && (esprimo)) {
					if ((n % cont) == 0) {
						esprimo = false;
					}
					cont = cont +2;
				}
				if (esprimo) {
					System.out.println("El numero " + n + " es primo");
				}
				else {
					System.out.println("El numero " + n + " no es primo");
				}
			}
			System.out.println("Escribe otro número: ");
			n =teclado.nextInt();
		}
		System.out.println("Has escrito un numero negativo");
	//Libero memoria teclado
			teclado.close();
	}

}
