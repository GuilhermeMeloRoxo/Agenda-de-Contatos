package servico;
import java.util.List;

import modelo_negocio.Cidade;
import modelo_negocio.ContatoPessoal;

public class ServicoContatoPessoal extends Servico {
	private ServicoContatoPessoal() {
	}

	public static ContatoPessoal localizarContatoPessoal(int id) {
		ContatoPessoal p = repContatoPessoal.localizar(id);
		return p;
	}
	public static ContatoPessoal localizarContatoPessoal(String nome) {
		ContatoPessoal p = repContatoPessoal.localizarNome(nome);
		return p;
	}

	public static void criarContatoPessoal(String nome, int grauDeProximidade, int idCidade) throws Exception {
		try {
			repContatoPessoal.begin();

			ContatoPessoal p = repContatoPessoal.localizarNome(nome);
			if (p != null)
				throw new Exception("usuario ja existe:" + nome);

			p = new ContatoPessoal(nome, grauDeProximidade, idCidade);

			repContatoPessoal.criar(p);
			repContatoPessoal.commit();
			
		} catch (Exception e) {
			repContatoPessoal.rollback();
			throw e;
		}
	}
	
	public static void alterarContatoPessoal(int id, String nome, int grauDeProximidade, int idCidade) throws Exception {
		try {
			repContatoPessoal.begin();
			ContatoPessoal p = repContatoPessoal.localizar(id);
			if (p == null)
				throw new Exception("alterar contato pessoal - contato inexistente:" + nome);

			p.setGrauProximidade(grauDeProximidade);
			
	        if (idCidade != p.getCidade().getId()) {
	            Cidade c = repCidade.localizarCidade(idCidade);
	            p.setCidade(c);
	        }


			repContatoPessoal.atualizar(p);
			repContatoPessoal.commit();

		} catch (Exception e) {
			repContatoPessoal.rollback();
			throw e;
		}
	}

	public static List<ContatoPessoal> listarContatoPessoais() {
		List<ContatoPessoal> result = repContatoPessoal.listar();
		return result;
	}
}
