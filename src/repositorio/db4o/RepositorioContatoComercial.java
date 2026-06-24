package repositorio.db4o;

import java.util.List;
import com.db4o.query.Query;
import modelo_negocio.ContatoComercial;

public class RepositorioContatoComercial extends Repositorio<ContatoComercial> {
	
	public List<ContatoComercial> localizarPorEmpresa(String empresa) {
		Query q = manager.query();
		q.constrain(ContatoComercial.class);
		q.descend("empresa").constrain(empresa).like();
		return q.execute();
	}
}
