import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	// Transferir para o escopo da def main e corrigir referencias
	private HashMap<String, AgenciaBancaria> agencias = new HashMap<String,AgenciaBancaria>();

	public static boolean addAgencia(HashMap<String, AgenciaBancaria> agencias, AgenciaBancaria newAgencia) {
		if (agencias.containsKey(newAgencia.getNumero())) {
			return false;
		}

		agencias.put(newAgencia.getNumero(), newAgencia);

		return true;
	}

	public static ContaBancaria findAccount (HashMap<String,AgenciaBancaria> agencias,String agenciaNumber, String accountNumber){
		if (!agencias.containsKey(agenciaNumber)){
			return null;
		}
		if (!agencias.get(agenciaNumber).getContas().containsKey(accountNumber)){
			return null;
		}
		return agencias.get(agenciaNumber).getContas().get(accountNumber);
	}

	public static void addAgenciaMenu(HashMap<String,AgenciaBancaria> agencias){
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o número da nova agêcnia: ");
		String number = scan.nextLine();
		boolean addCompleted = addAgencia(agencias, new AgenciaBancaria(number));
		if (addCompleted) {
			System.out.println("A nova agência foi criada com sucesso!");
		}else {
			System.out.println("Não foi possível criar a agência, já existe uma agência com esse número");
		}
	}

	public static void addContaMenu(HashMap<String,AgenciaBancaria> agencias) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o número da agência: ");
		String agenciaNumber = scan.nextLine();
		System.out.print("Digite o número da conta: ");
		String number = scan.nextLine();
		System.out.print("Digite o seu nome: ");
		String name = scan.nextLine();
		System.out.print("Deposito inicial em R$ (pode ser R$ 0): ");
		double saldo = scan.nextDouble();

		AgenciaBancaria agencia = agencias.get(agenciaNumber);
		if (agencia == null) {
			System.out.println("O número da agência não é válido, tente cadastrar uma agência primeiro");
			return;
		}

		boolean addCompleted = agencia.addConta(new ContaBancaria(number, name, saldo));

		if (addCompleted) {
			System.out.println("A nova conta foi criada com sucesso!");
			System.out.print("Você possui: R$ ");
			System.out.println(saldo);
		}else {
			System.out.println("Não foi possível criar a conta, já existe uma conta com esse número nessa agêcnia");
		}
	}

	public static void depositMenu(HashMap<String, AgenciaBancaria> agencias){
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o número da agência: ");
		String agenciaNumber = scan.nextLine();
		System.out.print("Digite o número da conta: ");
		String contaNumber = scan.nextLine();
		System.out.print("Digite o valor do deposito em R$: ");
		double amount = scan.nextDouble();

		AgenciaBancaria agencia = agencias.get(agenciaNumber);
		if (agencia == null) {
			System.out.println("O número da agência não é válido, tente cadastrar uma agência primeiro");
			return;
		}

		ContaBancaria conta = agencia.getContas().get(contaNumber);
		if (conta == null) {
			System.out.println("O número da conta não é válido, tente cadastrar uma conta primeiro");
			return;
		}

		conta.addAmount(amount);
		System.out.println("Deposito realizado com sucesso!");
		System.out.print("Agora você possui: R$ ");
		System.out.println(conta.getSaldo());
	}

	public static void withdrawalMenu(HashMap<String, AgenciaBancaria> agencias){
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o número da agência: ");
		String agenciaNumber = scan.nextLine();
		System.out.print("Digite o número da conta: ");
		String contaNumber = scan.nextLine();
		System.out.print("Digite o valor do saque em R$: ");
		double amount = scan.nextDouble();

		AgenciaBancaria agencia = agencias.get(agenciaNumber);
		if (agencia == null) {
			System.out.println("O número da agência não é válido, tente cadastrar uma agência primeiro");
			return;
		}

		ContaBancaria conta = agencia.getContas().get(contaNumber);
		if (conta == null) {
			System.out.println("O número da conta não é válido, tente cadastrar uma conta primeiro");
			return;
		}

		conta.removeAmount(amount);
		System.out.println("Saque realizado com sucesso!");
		System.out.print("Agora você possui: R$ ");
		System.out.println(conta.getSaldo());
	}

	public static void saldoMenu(HashMap<String, AgenciaBancaria> agencias){
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o número da agência: ");
		String agenciaNumber = scan.nextLine();
		System.out.print("Digite o número da conta: ");
		String contaNumber = scan.nextLine();

		AgenciaBancaria agencia = agencias.get(agenciaNumber);
		if (agencia == null) {
			System.out.println("O número da agência não é válido, tente cadastrar uma agência primeiro");
			return;
		}

		ContaBancaria conta = agencia.getContas().get(contaNumber);
		if (conta == null) {
			System.out.println("O número da conta não é válido, tente cadastrar uma conta primeiro");
			return;
		}

		System.out.print("O saldo atual da sua conta é: R$ ");
		System.out.println(conta.getSaldo());
	}


	public static String showMenu(){
		System.out.println("=== Menu ===");
		System.out.println("1 - Adicionar agência");
		System.out.println("2 - Adicionar conta");
		System.out.println("3 - Realizar deposito");
		System.out.println("4 - Realizar saque");
		System.out.println("5 - Verificar saldo da conta");
		System.out.println("6 - Sair");

		Scanner scan = new Scanner(System.in);
		System.out.print("Digite a sua opção: ");
		String opt = scan.nextLine();

		return opt;
	}



	public static void handleOption(String opt, HashMap<String,AgenciaBancaria> agencias) {
		switch(opt){
			case "1":
				addAgenciaMenu(agencias);
				break;
			case "2":
				addContaMenu(agencias);
				break;
			case "3":
				depositMenu(agencias);
				break;
			case "4":
				withdrawalMenu(agencias);
				break;
			case "5":
				saldoMenu(agencias);
				break;
			case "6":
				System.out.println("Saindo do programa ...");
				break;
			default:
				System.out.println("Opção inválida....");
				break;
		}
	}

	public static void main(String args[]) {
		Scanner scan= new Scanner(System.in);
		HashMap<String, AgenciaBancaria> agencias = new HashMap<String,AgenciaBancaria>();

		System.out.println("=== Bancos ===");
		String opt = "";

		while (!opt.equals("6")) {
			opt = showMenu();
			handleOption(opt, agencias);
		}

	}
}
