package Evaluacion2;

public class RelacionMain {

	public static void main(String[] args) {
		// Defino la clase de "Ejecucion"
		Racional r1;
//	Constructores
		// Constructores por defecto
		r1 = new Racional(); // 0/1
		System.out.println(r1);

//	Constructor Copia
		Racional r2;
		r2 = new Racional(r1);
		r2.setNumerador(2);
		System.out.println(r1);
		System.out.println(r2);

		// Contructores personalizados
		Racional r3;
		r3 = new Racional(3, 4);
		System.out.println(r3);

		Racional r4;
		r4 = new Racional(7);
		System.out.println(r4);

//	Obtener o cambiar valores de las propiedades
//Getters and Setters
		System.out.println("Numerador: "+ r3.getNumerador());
		System.out.println("Denominador: "+ r3.getDenominador());
//		Equals
		Racional r6 = new Racional(6,8);
		if (r6.equals(r3)) {
			System.out.println(r6 + " y " + r3 +"son iguales");
			}else {
				System.out.println(r6 + " y " + r3 +"no son iguales");
				
			}
//		compareTo
		if (r3.compareTo(r4)>0) {
//			si r3 > r4
			System.out.println(r3 + " es mayor " + r4 );
			
			
		}
		
	}

}
