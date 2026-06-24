package repositorio.db4o;

import java.util.List;
import com.db4o.query.Query;
import modelo_negocio.ContatoPessoal;

public class RepositorioContatoPessoal extends Repositorio<ContatoPessoal> {
	
	public List<ContatoPessoal> localizarPorGrauProximidade(int grau) {
		Query q = manager.query();
		q.constrain(ContatoPessoal.class);
		q.descend("grauProximidade").constrain(grau);
		return q.execute();
	}
}
