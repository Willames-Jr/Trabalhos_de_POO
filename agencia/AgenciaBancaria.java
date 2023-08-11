import java.util.ArrayList;
import java.util.HashMap;

public class AgenciaBancaria {

	private String numero;
	private HashMap<String,ContaBancaria> contas;

	public AgenciaBancaria(String numero){
		this.numero = numero;
		this.contas = new HashMap<String,ContaBancaria>();
	}

	public void setNumero(String value) {this.numero = value;}

	public String getNumero() {return this.numero;}

	public void setContas( HashMap<String,ContaBancaria> value) {this.contas = value;}

	public HashMap<String,ContaBancaria> getContas() {return this.contas;}

	public boolean addConta(ContaBancaria newAccount) {
		if (this.contas.containsKey(newAccount.getNumero())) {
			return false;
		}

		this.contas.put(newAccount.getNumero(),newAccount);
		return true;
	}
}
