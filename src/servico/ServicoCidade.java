package servico;

import java.text.Normalizer;
import java.util.regex.Pattern;

import modelo_negocio.Cidade;

public class ServicoCidade extends Servico {
	private ServicoCidade() {
		
	}
	public static Cidade localizarCidade(int id) {
		
		Cidade c = repCidade.localizar(id);
		return c;
	}
	public static Cidade localizarCidade(String nome) throws Exception {
		try {
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	        String name = pattern.matcher(nome).replaceAll("");
			String n = name.toUpperCase().trim();
			if (n.equals("")) {
				throw new Exception("cidade inválida");
			}
			Cidade c = repCidade.localizarNomeCidade(n);
			return c;
		} catch (Exception e) {
			repCidade.rollback();
			throw e;
		}
		
	}
	public static void criarCidade(String nome) throws Exception {
		try {
			if (nome != null && nome.matches(".*\\d.*")) {
	            throw new Exception("cidade inválida: não deve conter números");
	        }
			String nom = Normalizer.normalize(nome, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	        String name = pattern.matcher(nom).replaceAll("");
			String n = name.toUpperCase().trim();
			if (n.equals("")) {
				throw new Exception("cidade inválida");
			}
			repCidade.begin();
			Cidade c = ServicoCidade.localizarCidade(n);
			if (c != null) {
				throw new Exception("cidade já existe: " + n);
			}
			c = new Cidade(n);
			repCidade.criar(c);
			repCidade.commit();
			
		} catch (Exception e) {
			repCidade.rollback();
			throw e;
		}
	}
}