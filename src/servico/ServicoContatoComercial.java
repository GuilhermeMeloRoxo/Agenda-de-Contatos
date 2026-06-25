package servico;
import java.util.List;

import modelo_negocio.ContatoComercial;

public class ServicoContatoComercial extends Servico {
	private ServicoContatoComercial() {
	}
	
	public static ContatoComercial localizarContatoComercial(int id) {
			ContatoComercial e = repContatoComercial.localizar(id);
			return e;
		}
	public static ContatoComercial localizarContatoComercial(String nome) {
		ContatoComercial e = repContatoComercial.localizarNome(nome);
		return e;
	}
	
	public static void criarContatoComercial(String nome, String empresa, int idCidade) throws Exception {
		try {
			repContatoComercial.begin();

			ContatoComercial e = repContatoComercial.localizarNome(nome);
			if (e != null)
				throw new Exception("empresa ja existe:" + empresa);

			e = new ContatoComercial(nome, empresa, idCidade);

			repContatoComercial.criar(e);
			repContatoComercial.commit();
			
		} catch (Exception e) {
			repContatoComercial.rollback();
			throw e;
		}
	}
}