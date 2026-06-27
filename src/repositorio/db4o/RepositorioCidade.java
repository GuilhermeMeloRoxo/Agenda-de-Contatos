package repositorio.db4o;

import java.util.List;
import java.util.regex.Pattern;

import com.db4o.query.Query;
import modelo_negocio.Cidade;

public class RepositorioCidade extends Repositorio<Cidade> {
	
	public Cidade localizarNomeCidade(String nom) throws Exception {
		Query q = manager.query();
		q.constrain(Cidade.class);
		q.descend("nome").constrain(nom);
		List<Cidade> resultados = q.execute();
		if (resultados.isEmpty())
			return null;
		else
			return resultados.getFirst();
	}
}
