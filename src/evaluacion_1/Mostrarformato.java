package evaluacion_1;

public class Mostrarformato {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Coge el  valor de una variable de tipo string y el valor de una variable de tipo real y muestra en la pantalla la cadena y la varable real con 2 ddecimaes.
		double r;
		r=1.0;
		String n;
		n="5";
		System.out.print("La variable de tipo string es "+n);
		System.out.printf(" Y la vaiable de tipo real es %.2f", r);
	}

}
