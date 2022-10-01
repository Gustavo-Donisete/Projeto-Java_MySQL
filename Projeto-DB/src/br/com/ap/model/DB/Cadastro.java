package br.com.ap.model.DB;

public class Cadastro {
	private String Cargo;
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	private int Quantidade;
	
	@Override
	public String toString() {
		return "Cadastro{ " + "Cargo = " + Cargo + ",Quantidade = " + Quantidade + "}";
				
	}
}
