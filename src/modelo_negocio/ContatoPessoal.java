package modelo_negocio;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class ContatoPessoal extends Contato {
	private int grauProximidade;

	public ContatoPessoal(){}
	public ContatoPessoal(String nome, List<String> telefones, Cidade cidade, int grauProximidade){
		super(nome, telefones, cidade);
		this.grauProximidade = grauProximidade;
	}
	public ContatoPessoal(String nome, int grauDeProximidade, int idCidade) {
		// TODO Auto-generated constructor stub
	}
	public int getGrauProximidade() {
		return grauProximidade;
	}
	public void setGrauProximidade(int grauProximidade) {
		this.grauProximidade = grauProximidade;
	}
}