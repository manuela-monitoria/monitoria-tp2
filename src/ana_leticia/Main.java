package ana_leticia;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite um numero com casas decimais:");
		float numero = scan.nextFloat();
		System.out.println(arredondaFloat(numero));
		scan.close();

	}
	
	public static float arredondaFloat(float numero) {		
		BigDecimal big = BigDecimal.valueOf(numero);
		big = big.setScale(1, BigDecimal.ROUND_HALF_UP);
		return big.floatValue();
		
	}

}
