package modelo_negocio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private List<String> telefones;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Cidade cidade;

	public Contato() {}
	public Contato(String nome, List<String> telefones, Cidade cidade) {
		this.nome = nome;
		this.telefones = telefones;
		this.cidade = cidade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getTelefones() {
		return new ArrayList<>(telefones);
	}
	public void addTelefones(List<String> telefones) {
		this.telefones = telefones;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
