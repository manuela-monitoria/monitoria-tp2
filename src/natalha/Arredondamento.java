package natalha;

import java.math.BigDecimal;

public class Arredondamento {

	public static void main(String[] args) {
		System.out.println(arredondaDouble(2.22));
		System.out.println(arredondaDoubleSimples(1.52));

	}
	
	public static double arredondaDouble(double numero) {		
		BigDecimal big = BigDecimal.valueOf(numero);
		big = big.setScale(1, BigDecimal.ROUND_HALF_UP);
		
		return big.doubleValue();
		
	}
	
	public static double arredondaDoubleSimples(double numero) {
		double parteInteira = Math.floor(numero);
		double parteDecimal = numero - parteInteira;
		
		if(parteDecimal >= 0.5) {
			return Math.ceil(numero);
		} else {
			return Math.floor(numero);
		}
		
	}

}
