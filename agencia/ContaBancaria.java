public class ContaBancaria  {

	private String numero;
	private String titular;
	private double saldo;

	public ContaBancaria(String numero, String titular, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}


	public void setNumero(String value) {this.numero = value;}

	public String getNumero() {return this.numero;}

	public void setTitular(String value) {this.titular = value;}

	public String  getTitular() {return this.titular;}

	public void setSaldo(double value) {this.saldo = value;}

	public double getSaldo() {return this.saldo;}

	public void removeAmount(double value) {
		this.saldo = this.saldo - value;
	}

	public void addAmount(double value) {
		this.saldo = this.saldo + value;
	}
}
