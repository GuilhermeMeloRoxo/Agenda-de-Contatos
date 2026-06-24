package repositorio.db4o;

import java.util.ArrayList;
import java.util.List;
import com.db4o.query.Query;
import modelo_negocio.Contato;

public class RepositorioContato extends Repositorio<Contato> {
	
	public Contato localizarNome(String nom) {
		Query q = manager.query();
		q.constrain(Contato.class);
		q.descend("nome").constrain(nom);
		List<Contato> resultados = q.execute();
		if (resultados.isEmpty())
			return null;
		else
			return resultados.getFirst();
	}

	public Contato localizarNumero(String num) {
		Query q = manager.query();
		q.constrain(Contato.class);
		q.descend("telefones").constrain(num);
		List<Contato> resultados = q.execute();
		if (resultados.isEmpty())
			return null;
		else
			return resultados.getFirst();
	}

	public List<String> listarNumeros(String digitos) {
		Query q = manager.query();
		q.constrain(Contato.class);
		q.descend("telefones").constrain(digitos).like();
		List<Contato> contatos = q.execute();
		
		if (contatos.isEmpty())
			return null;

		List<String> telefonesFiltrados = new ArrayList<>();
		for (Contato c : contatos) {
			for (String tel : c.getTelefones()) {
				if (tel.contains(digitos)) {
					telefonesFiltrados.add(tel);
				}
			}
		}
		return telefonesFiltrados;
	}
}
