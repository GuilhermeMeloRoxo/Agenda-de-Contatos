package repositorio.db4o;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;

import modelo_negocio.Contato;
import modelo_negocio.ContatoPessoal;
import modelo_negocio.ContatoComercial;
import modelo_negocio.Cidade;

public class Util {
	private static ObjectContainer manager;
	private static String ip = "localhost";
	
	private static final Logger logger = LogManager.getLogger(Util.class);

	public static ObjectContainer conectar() throws Exception {
		if (manager != null)
			return manager; 
		
		logger.info("-------- vai conectar com banco de dados db4o "+ip);

		if (ip.equals("localhost"))
			manager = conectarBancoLocal(); 
		else
			manager = conectarBancoRemoto(); 

		logger.info("-------- conectou ao db4o ");
		System.out.println("conectou ao db4o => " + ip);

		GeradorID.ativar(manager);
		return manager;
	}

	private static ObjectContainer conectarBancoLocal() throws Exception{
		try {
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			
			config.common().objectClass(Contato.class).cascadeOnDelete(false);
			config.common().objectClass(Contato.class).cascadeOnUpdate(true);
			config.common().objectClass(Contato.class).cascadeOnActivate(true);
			
			config.common().objectClass(ContatoPessoal.class).cascadeOnDelete(false);
			config.common().objectClass(ContatoPessoal.class).cascadeOnUpdate(true);
			config.common().objectClass(ContatoPessoal.class).cascadeOnActivate(true);

			config.common().objectClass(ContatoComercial.class).cascadeOnDelete(false);
			config.common().objectClass(ContatoComercial.class).cascadeOnUpdate(true);
			config.common().objectClass(ContatoComercial.class).cascadeOnActivate(true);

			config.common().objectClass(Cidade.class).cascadeOnDelete(false);
			config.common().objectClass(Cidade.class).cascadeOnUpdate(true);
			config.common().objectClass(Cidade.class).cascadeOnActivate(true);

			config.common().activationDepth(100); 
			manager = Db4oEmbedded.openFile(config, "banco.db4o");
		} catch (Exception e) {
			throw new Exception("Erro ao conectar ao banco db4o local \n" + e.getMessage());
		}
		return manager;
	}

	private static ObjectContainer conectarBancoRemoto() throws Exception {
		try {
			ClientConfiguration config = Db4oClientServer.newClientConfiguration();
			
			config.common().objectClass(Contato.class).cascadeOnDelete(false);
			config.common().objectClass(Contato.class).cascadeOnUpdate(true);
			config.common().objectClass(Contato.class).cascadeOnActivate(true);
			
			config.common().objectClass(ContatoPessoal.class).cascadeOnDelete(false);
			config.common().objectClass(ContatoPessoal.class).cascadeOnUpdate(true);
			config.common().objectClass(ContatoPessoal.class).cascadeOnActivate(true);

			config.common().objectClass(ContatoComercial.class).cascadeOnDelete(false);
			config.common().objectClass(ContatoComercial.class).cascadeOnUpdate(true);
			config.common().objectClass(ContatoComercial.class).cascadeOnActivate(true);

			config.common().objectClass(Cidade.class).cascadeOnDelete(false);
			config.common().objectClass(Cidade.class).cascadeOnUpdate(true);
			config.common().objectClass(Cidade.class).cascadeOnActivate(true);

			config.common().activationDepth(100); 
			manager = Db4oClientServer.openClient(config, ip, 34000, "usuario1", "senha1");
		} catch (Exception e) {
			throw new Exception("Erro ao conectar ao banco db4o remoto \n" + e.getMessage());
		}
		return manager;
	}

	public static void desconectar() {
		if (manager != null) {
			manager.close();
			manager = null;
			System.out.println("desconectou ao db4o => " + ip);
			logger.info("-------- desconectou ao db4o ");
		}
	}

	public static String getIPservidor() {
		return ip;
	}
}
