package servico;

import repositorio.db4o.Repositorio;
import repositorio.db4o.RepositorioContatoPessoal;
import repositorio.db4o.RepositorioContatoComercial;
import repositorio.db4o.RepositorioCidade;
import repositorio.db4o.RepositorioContato;

public class Servico {
	protected Servico() {}

	protected static RepositorioContatoPessoal repContatoPessoal = new RepositorioContatoPessoal();
	protected static RepositorioContatoComercial repContatoComercial = new RepositorioContatoComercial();
	protected static RepositorioCidade repCidade = new RepositorioCidade();
	protected static RepositorioContato repContato = new RepositorioContato();
	
	public static void conectar() throws Exception {
		Repositorio.conectar();
	}

	public static void desconectar()throws Exception {
		Repositorio.desconectar();
	}

}
