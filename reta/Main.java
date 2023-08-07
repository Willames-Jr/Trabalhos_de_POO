import java.util.Scanner;

public class Main {
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);

		System.out.println("====== CALCULADORA DE TAMANHO DA RETA ======");

		System.out.print("Digite a posição do primeiro ponto no formato x;y: ");
		String[] p1Str = scan.nextLine().split(";");

		System.out.print("Digite a posição do segundo tempo no formato x;y: ");
		String[] p2Str = scan.nextLine().split(";");

		System.out.println("Calculando o tamanho do segmento de reta ...");

		Ponto p1 = new Ponto(Float.parseFloat(p1Str[0]), Float.parseFloat(p1Str[1]));
		Ponto p2 = new Ponto(Float.parseFloat(p2Str[0]), Float.parseFloat(p2Str[1]));

		Reta r = new Reta(p1,p2);

		System.out.print("O tamanho é: ");
		System.out.println(r.size());

	}
}
